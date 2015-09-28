package it.uniroma3.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class HelperCompraProdotto extends Helper{
	

	private String quantita;
	
	
	public HelperCompraProdotto(HttpServletRequest request)throws ServletException{
		
		super(request);
		quantita = request.getParameter("quantita");
		
	}
	
	public boolean convalida(){
		Map<String,String> mappaProdottoAggiunto = new HashMap<String,String>();
		boolean convalida=true;
		if(quantita==null||quantita.equals("")){
			mappaProdottoAggiunto.put("quantita", "Campo Obbligatorio");
			convalida = false;
		}
		request.setAttribute("mappaProdottoAggiunto", mappaProdottoAggiunto);
		return convalida;
	}

}