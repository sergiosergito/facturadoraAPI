package com.cristianruizblog;

public class Usuario {

	private String usuario;
	private String contrasena;
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public void format() {
		String newLine = usuario;
		String name;
		
		
		
		//{"linea":{"numero":"70712345","nombreUsuario":"Jose Perez","plan":{"nombre":"prepago","tarifa":{"tarifaHorarioNormal":1.45,"tarifaHorarioReducido":0.95,"tarifaHorarioSuperReducido":0.7}}},"listaCdrs":[{"id":1,"telfOrigen":"70712345","telfDestino":"70754321","fecha":"26-05-2020","horaLlamada":"10:00","duracionLlamada":"1:30","tarifa":1.45},{"id":2,"telfOrigen":"70712345","telfDestino":"707789012","fecha":"26-05-2020","horaLlamada":"10:30","duracionLlamada":"1:45","tarifa":1.45}]}
	}
	
}
