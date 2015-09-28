package it.uniroma3.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class HelperRicercaCliente extends Helper{
	
	private String codice_ordine;
	
	public HelperRicercaCliente(HttpServletRequest request)throws ServletException{
		super(request);
		codice_ordine = request.getParameter("codice_ordine");
		
	}
	
	public boolean convalida(){
		boolean convalida = true;
		Map<String,String> mappaErroriOrdine = new HashMap<String,String>();
		if(codice_ordine==null||codice_ordine.equals("")){
			mappaErroriOrdine.put("codice", "Campo Obbligatorio");
			convalida = false;
		}
		mappaErroriOrdine.put("varie", "Il Campo Immesso Non E' Valido");
		request.setAttribute("mappaErroriOrdine", mappaErroriOrdine);
		return convalida;
	}

}
