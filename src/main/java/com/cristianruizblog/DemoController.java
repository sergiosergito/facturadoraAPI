package com.cristianruizblog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Models.SoyUnico;

@Controller
public class DemoController {

	private final static String INVOICE_JSP = "invoice";
	private static final String ARCHIVO_URL_SQL = "http://localhost:4567/sql/facturar";
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
		return "menu";
	}
	/*
	@RequestMapping(value = "/invoice")
	public String showInvoice() {
		//System.out.println(ricardo.getNombre());
		
		return INVOICE_JSP;
	}
	*/
	@RequestMapping("/get/cdr")
	public String getNumberCDR(HttpServletRequest request){
		String response="";
		int number = Integer.parseInt(request.getParameter("number"));//Esta apuntando al input, con el name number
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
	/*
	@GetMapping("/invoice")
	public String goToInvoice() {
		return "loginForm";
	}
	*/
	
	@RequestMapping("/invoice")
	public String goToInvoice(Model modelo,Usuario usuario) {
		String resultado ="";
		/*
		if(usuario.getUsuario().isEmpty() || usuario.getContrasena().isEmpty()) {
			resultado = "Fallido ambos campos son obligatorios";
		}else {
			resultado = "Yeah puedes entrar";
		}
		*/
		resultado = ricardo.getNombre();
		System.out.println("Ricardo dice: " + ricardo.getNombre());
		modelo.addAttribute("result",resultado);
		return "menu";
	}
	
	/*
	@RequestMapping(value = "/invoice")
	public String showInvoice() {
		//System.out.println(ricardo.getNombre());
		return INVOICE_JSP;
	}
	*/
}
