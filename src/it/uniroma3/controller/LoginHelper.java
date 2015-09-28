package it.uniroma3.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class LoginHelper extends Helper {
	
	private String username;
	private String password;
	
	public LoginHelper(HttpServletRequest request) throws ServletException{
		super(request);
		username = request.getParameter("username");
		password = request.getParameter("password");
	}
	
	public boolean convalida(){
		Map<String,String> mappaErroriLogin= new HashMap<String,String>();
		boolean convalida = true;
		if(username==null || username.equals("")){
			mappaErroriLogin.put("username", "Campo Obbligatorio");
			convalida = false;
		}
		if(password==null || password.equals("")){
			mappaErroriLogin.put("password", "Campo Obbligatorio");
			convalida = false;
		}
		mappaErroriLogin.put("generico", "Username o Password Immessi Sono Errati");
		request.setAttribute("mappaErroriLogin",mappaErroriLogin);
		request.setAttribute("username", username);
		return convalida;
		
		
	}

}
