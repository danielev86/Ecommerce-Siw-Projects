package it.uniroma3.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.*;
import javax.servlet.http.*;

public class HelperInserimentoProdotto extends Helper {

	private String nome,costo,descrizione,codice,disponibilita;
	public HelperInserimentoProdotto(HttpServletRequest request) throws ServletException {
		super(request);
		nome= request.getParameter("nome");
		costo= request.getParameter("costo");
		descrizione= request.getParameter("descrizione");
		codice= request.getParameter("codice");
		disponibilita= request.getParameter("disponibilita");
	}
	
	public boolean convalida(){
		boolean convalida= true;
		Map<String,String> mappaInsProd= new HashMap<String,String>();
		if(nome==null||nome.equals("")){
			mappaInsProd.put("nome","campo obbligatorio");
			convalida=false;
		}
		if(costo==null||costo.equals("")){
			mappaInsProd.put("costo","campo obbligatorio");
			convalida=false;
		}
		if(descrizione==null||descrizione.equals("")){
			mappaInsProd.put("descrizione","campo obbligatorio");
			convalida=false;
		}
		if(codice==null||codice.equals("")){
			mappaInsProd.put("codice","campo obbligatorio");
			convalida=false;
		}
		if(disponibilita==null||disponibilita.equals("")){
			mappaInsProd.put("disponibilita","campo obbligatorio");
			convalida=false;
		}
		request.setAttribute("mappaInsProd", mappaInsProd);
		return convalida;
	}
	
	
}
