package it.uniroma3.controller;

import it.uniroma3.model.*;
import it.uniroma3.model.FacadeOrdineImpl;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class CompletaOrdineAction extends Azione {
	
	public String esegui(HttpServletRequest request)throws ServletException{
		HttpSession session = request.getSession();
		List<RigaOrdine> listaOrd = (List<RigaOrdine>) session.getAttribute("listaOrd");
		Cliente cliente = (Cliente) session.getAttribute("cliente");
		Ordine ordine = (Ordine) session.getAttribute("ordine");
		FacadeOrdine facade = new FacadeOrdineImpl();
		ordine.setId(facade.nuovoIdOrdine());
		facade.creaOrdine(ordine,listaOrd);
		session.removeAttribute("ordine");
		session.removeAttribute("listaOrd");
		session.removeAttribute("prodottoIns");
		return "ordineCompletoOk";
	}

}
