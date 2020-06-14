package com.cristianruizblog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Models.SoyUnico;

@Controller
public class FacturaController {

	private final static String ROOT = "/";
	private final static String INVOICE_FORM_JSP = "invoiceForm";
	private final static String INVOICE_JSP = "invoice";
	private final static String URL_TARIFICADORA = "http://localhost:4567/";
	private static final String URL_ARCHIVO_TARIFICADORA = "http://localhost:4567/archivo/facturar";
	private static final String URL_SQL_TARIFICADORA = "http://localhost:4567/sql/facturar";
	SoyUnico ricardo = SoyUnico.getSingletonInstance("Ricardo Moya");
	
	@GetMapping(ROOT)
	public String index() {
		return INVOICE_FORM_JSP;
	}
	@RequestMapping("/get/cdr")
	public String getNumberCDR(HttpServletRequest request, Model modelo){
		
		String response = "";
		int lineNumber = Integer.parseInt(request.getParameter("number"));//Esta apuntando al input, con el name number
		int monthNumber = Integer.parseInt(request.getParameter("months"));
		try {
			//URL url = new URL(URL_TARIFICADORA + persistencia + "/facturar"+ "/" + lineNumber + "/" + monthNumber);
			URL url = new URL(URL_ARCHIVO_TARIFICADORA + "/" + lineNumber + "/" + monthNumber);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			while((output = br.readLine()) != null){
				response += output;
			}
			JSONObject obj = new JSONObject(response);
			JSONObject objLinea = (JSONObject) obj.get("linea");
			JSONObject objPlan = (JSONObject) objLinea.get("plan");
			JSONArray objCDRs = (JSONArray) obj.get("listaCdrs");
			String phrase = "";
			double tarifa;
			List<String> list = new ArrayList<String>();
			for(int i = 0; i < objCDRs.length(); i++){
				phrase += objCDRs.getJSONObject(i).getString("telfDestino") + " ";
	            phrase += objCDRs.getJSONObject(i).getString("fecha")  + " ";
	            phrase += objCDRs.getJSONObject(i).getString("horaLlamada")  + " ";
	            phrase += objCDRs.getJSONObject(i).getString("duracionLlamada")  + " ";
	            tarifa = objCDRs.getJSONObject(i).getDouble("tarifa");
	            phrase += Double.toString(tarifa);
	            list.add(phrase);
	            phrase = "";
			}
			
			String numero = (String) objLinea.get("numero");
			String nombreUsuario = (String) objLinea.get("nombreUsuario");
			String nombrePlan = (String) objPlan.get("nombre");
			
			double total = (double) obj.get("totalAPagar");
			modelo.addAttribute("numero",numero);
			modelo.addAttribute("nombreUsuario",nombreUsuario);
			modelo.addAttribute("nombrePlan",nombrePlan);
			modelo.addAttribute("listCDRs", list);
			modelo.addAttribute("total", total);
			ricardo.setNombre(response);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		return INVOICE_JSP;
	}
	
	public JSONObject generarJsonSegunDatosTarificadora(String datos) {
		return null;
		
	}
}
