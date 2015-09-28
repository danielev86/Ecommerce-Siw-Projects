package it.uniroma3.controller;

import it.uniroma3.model.Cliente;
import it.uniroma3.model.FacadeOrdine;
import it.uniroma3.model.FacadeOrdineImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class RicercaOrdineClienteAction extends Azione {
	
	public String esegui(HttpServletRequest request)throws ServletException{
		String codice_ordine = request.getParameter("codice_ordine");
		FacadeOrdine facOrd = new FacadeOrdineImpl();
		Helper helper = new HelperRicercaCliente(request);
		
		if(helper.convalida()){
			Long id_ordine = Long.parseLong(codice_ordine);
			Cliente clienteInfo = facOrd.informazioniCliente(id_ordine);
			if(clienteInfo!=null){
				facOrd.chiudiOrdine(id_ordine, "chiuso");
				HttpSession session = request.getSession();
				session.setAttribute("clienteInfo", clienteInfo);
				return "ricercaClientePerOrdineOk";
				
			}else{
				request.setAttribute("codice_ordine", codice_ordine);
				return "ricercaClientePerOrdineKo";
			}
			
		}else{
			request.setAttribute("codice_ordine", codice_ordine);
			return "ricercaClientePerOrdineKo";
		}
		
	}

}
