package it.uniroma3.controller;

import it.uniroma3.model.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AggiornaStatoOrdineAction extends Azione{
	public String esegui(HttpServletRequest request)throws ServletException{
		String codice_ordine = request.getParameter("codice_ordine");
		FacadeOrdine facOrd = new FacadeOrdineImpl();
		Helper helper = new HelperAggiornaStatoOrdine(request);
		
		if(helper.convalida()){
			Long id_ordine = Long.parseLong(codice_ordine);
			if(facOrd.ordinePresente(id_ordine, "chiuso")){
				facOrd.ordineEvaso(id_ordine, "evaso");
				return "aggiornaOrdineOk";
				
			}else{
				String errore = "L'ordine definito non è stato chiuso";
				request.setAttribute("errore", errore);
				return "aggiornaOrdineKo";
			}
			
		}else{
			request.setAttribute("codice_ordine", codice_ordine);
			return "aggiornaOrdineKo";
		}
		
	}


}
