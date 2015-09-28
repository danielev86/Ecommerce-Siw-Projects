package it.uniroma3.controller;

import it.uniroma3.model.Prodotto;
import java.lang.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DettaglioProdottoOrdineAction extends Azione{
	
	public String esegui(HttpServletRequest request)throws ServletException{
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String codice = request.getParameter("codice");
		String disponibilita = request.getParameter("disponibilita");
		Prodotto prodottoOrdine = new Prodotto();
		prodottoOrdine.setNome(nome);
		prodottoOrdine.setDescrizione(descrizione);
		prodottoOrdine.setCosto(Double.parseDouble(prezzo));
		prodottoOrdine.setCodice(codice);
		prodottoOrdine.setDisponibilita(Long.parseLong(disponibilita));
		HttpSession session = request.getSession();
		session.setAttribute("prodottoOrdine", prodottoOrdine);
		return "dettaglioProdottoOrdine";
		
	}

}
