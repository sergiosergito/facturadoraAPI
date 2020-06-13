package com.cristianruizblog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import Models.SoyUnico;

@Controller
public class DemoController {

	private final static String MENU_JSP = "menu";
	private static final String URL_ARCHIVO_TARIFICADORA = "http://localhost:4567/archivo/facturar";
	private static final String URL_SQL_TARIFICADORA = "http://localhost:4567/sql/facturar";
	SoyUnico ricardo = SoyUnico.getSingletonInstance("Ricardo Moya");
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "loginForm";
	}
	
	@PostMapping("/login")
	public String loginForm(Model modelo,Usuario usuario) {
		String resultado ="";
		
		if(usuario.getUsuario().isEmpty() || usuario.getContrasena().isEmpty()) {
			resultado = "Fallido ambos campos son obligatorios";
		}else {
			resultado = "Yeah puedes entrar";
		}
		
		modelo.addAttribute("result",resultado);
		return MENU_JSP;
	}
	
	@RequestMapping("/get/cdr")
	public String getNumberCDR(HttpServletRequest request, Model modelo){
		
		String response="";
		int lineNumber = Integer.parseInt(request.getParameter("number"));//Esta apuntando al input, con el name number
		int monthNumber = Integer.parseInt(request.getParameter("months"));
		System.out.println("Numero de telefono: " + lineNumber);
		System.out.println("Numero de mes: " + monthNumber);
		try {
			URL url = new URL(URL_ARCHIVO_TARIFICADORA + "/" + lineNumber + "/" + monthNumber);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			//JSONObject data = json.loads(output);
			while((output = br.readLine()) != null){
				//System.out.println(output.getClass().getSimpleName());
				response += output;
			}
			System.out.println(response);
			System.out.println("++++++++++++++++++++++++++++++++");
			JSONObject obj = new JSONObject(response);
			System.out.println("*******************************");
			JSONObject objLinea = (JSONObject) obj.get("linea");
			JSONObject objPlan = (JSONObject) objLinea.get("plan");
			
			//JsonParser parser = new JsonParser();
			//JsonElement data = parser.parse(output);
			String numero = (String) objLinea.get("numero");
			String nombreUsuario = (String) objLinea.get("nombreUsuario");
			String nombrePlan = (String) objPlan.get("nombre");
			modelo.addAttribute("numero",numero);
			modelo.addAttribute("nombreUsuario",nombreUsuario);
			modelo.addAttribute("nombrePlan",nombrePlan);
			ricardo.setNombre(response);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		
		/*
		String response="";
		int number = Integer.parseInt(request.getParameter("number"));//Esta apuntando al input, con el name number
		int monthNumber = Integer.parseInt(request.getParameter("months.value"));
		System.out.println("Numero de telefono: " + number);
		System.out.println("Numero de mes: " + monthNumber);
		try {
			URL url = new URL(ARCHIVO_URL_SQL + "/" + number);
			//URL url = new URL(ARCHIVO_URL_SQL + "/" + number + "/" + monthNumber);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			//JSONObject data = json.loads(output);
			while((output = br.readLine()) != null){
				
				System.out.println(output.getClass().getSimpleName());
				response += output;
			}
			JsonParser parser = new JsonParser();
			JsonElement data = parser.parse(output);
			ricardo.setNombre(response);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		*/	
		
		/*
		try {
			URL url = new URL(ARCHIVO_URL_SQL + "/" + number + "/" + monthNumber);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			//JSONObject data = json.loads(output);
			while((output = br.readLine()) != null){
				System.out.println(output.getClass().getSimpleName());
				response += output;
			}
			
			ricardo.setNombre(response);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		*/
		return MENU_JSP;
		//return "redirect:/invoice";
	}
	
	/*
	@RequestMapping(value = "/invoice")
	public String showInvoice() {
		//System.out.println(ricardo.getNombre());
		
		return INVOICE_JSP;
	}
	*/
	/*
	@RequestMapping("/get/cdr")
	public String getNumberCDR(HttpServletRequest request){
		String response="";
		int number = Integer.parseInt(request.getParameter("number"));//Esta apuntando al input, con el name number
		int date = Integer.parseInt(request.getParameter("month"));
		System.out.println(number);
		
		try {
			URL url = new URL(ARCHIVO_URL_SQL + "/" + number);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			if(conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
			}
			InputStreamReader in = new InputStreamReader(conn.getInputStream());
			BufferedReader br = new BufferedReader(in);
			String output;
			//JSONObject data = json.loads(output);
			while((output = br.readLine()) != null){
				System.out.println(output.getClass().getSimpleName());
				response += output;
			}
			
			ricardo.setNombre(response);
		} catch(Exception e) {
			 System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
		}
		return "redirect:/invoice";
	}
	*/
	
	/*
	@GetMapping("/invoice")
	public String goToInvoice() {
		return "loginForm";
	}
	*/
	
	@RequestMapping("/invoice")
	public String goToInvoice(Model modelo,Usuario usuario) {
		String resultado ="";
		resultado = ricardo.getNombre();
		modelo.addAttribute("result",resultado);
		return MENU_JSP;
	}
}
