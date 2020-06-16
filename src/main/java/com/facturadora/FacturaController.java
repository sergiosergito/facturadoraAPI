package com.facturadora;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormatSymbols;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacturaController {

	private final static String ROOT = "/";
	private final static String INVOICE_FORM_JSP = "invoiceForm";
	private final static String INVOICE_JSP = "invoice";
	private final static String URL_TARIFICADORA = "http://localhost:4567/";
	
	
	@GetMapping(ROOT)
	public String index() {
		return INVOICE_FORM_JSP;
	}
	
	@RequestMapping("/getcdr")
	public String getNumberCDR(HttpServletRequest request, Model modelo){
		
		String response = "";
		int lineNumber = Integer.parseInt(request.getParameter("number"));//Esta apuntando al input, con el name number
		int monthNumber = Integer.parseInt(request.getParameter("months"));
		String persistencia= request.getParameter("persistence");
		try {
			URL url = new URL(URL_TARIFICADORA + persistencia + "/facturar"+ "/" + lineNumber + "/" + monthNumber);
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
			
				if(response.contains("{}")) {
					modelo.addAttribute("mensaje","Linea no registrada en sistema");
					return INVOICE_FORM_JSP;
				}
				
			JSONObject objLinea = (JSONObject) obj.get("lineaTelefonica");
			JSONObject objPlan = (JSONObject) objLinea.get("plan");
			int cantidadLlamadas=(int) obj.get("cantLlamadas");
			String numero = (String) objLinea.get("numero");
			String nombreUsuario = (String) objLinea.get("nombreUsuario");
			String nombrePlan = (String) objPlan.get("nombre");
			double total = (double) obj.get("totalAPagar");
			modelo.addAttribute("numero",numero);
			modelo.addAttribute("nombreUsuario",nombreUsuario);
			modelo.addAttribute("nombrePlan",nombrePlan);
			modelo.addAttribute("cantidadLlamadas", cantidadLlamadas);
			modelo.addAttribute("total", String.format("%.2f",total));
			modelo.addAttribute("mes", new DateFormatSymbols().getMonths()[monthNumber-1]);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		return INVOICE_JSP;
	}
	
}
