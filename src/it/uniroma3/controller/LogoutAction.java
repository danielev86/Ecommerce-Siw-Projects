package it.uniroma3.controller;

import it.uniroma3.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LogoutAction extends Azione {

	public String esegui(HttpServletRequest request) throws ServletException{

		HttpSession session = request.getSession();
		session.removeAttribute("cliente");
		session.removeAttribute("amministratore");
		session.invalidate();
		return "logoutOk";
		
	}
}
