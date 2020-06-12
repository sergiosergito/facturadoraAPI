package com.cristianruizblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	private final static String INVOICE_JSP = "invoice";
	
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
	
	@RequestMapping(value = "/invoice")
	public String showInvoice() {
		//System.out.println(ricardo.getNombre());
		
		return INVOICE_JSP;
	}
	
}
