package it.uniroma3.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import it.uniroma3.model.*;

public class LoginAction extends Azione {
	
	
	public String esegui(HttpServletRequest request)throws ServletException{
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Helper helper = new LoginHelper(request);
		if(helper.convalida()){
			HttpSession session = request.getSession();
			FacadeAmministratore facAmm = new FacadeAmministratoreImpl();
			Amministratore amministratore = facAmm.loginAmministratore(username, password);
			FacadeCliente facCliente = new FacadeClienteImpl();
			Cliente cliente = facCliente.loginCliente(username, password);
			if(amministratore !=null){
				session.setAttribute("amministratore", amministratore);
				return "loginOk";
			}else if(cliente !=null){
				session.setAttribute("cliente", cliente);
				return "loginOk";
			}else return "loginKo";
				
			
			
		}else{
			return "loginKo";
		}
		
	}

}
