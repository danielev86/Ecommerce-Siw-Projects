package it.uniroma3.controller;
import it.uniroma3.model.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class InserimentoProdottoAction extends Azione{
	public String esegui(HttpServletRequest request) throws ServletException{
		String nome= request.getParameter("nome");
		String costo= request.getParameter("costo");
		String descrizione= request.getParameter("descrizione");
		String codice= request.getParameter("codice");
		String disponibilita= request.getParameter("disponibilita");
		
		Helper helper= new HelperInserimentoProdotto(request);
		
		if (helper.convalida()){
			FacadeProdotto facade= new FacadeProdottoImpl();
			Prodotto prodottoInserito = new Prodotto();
			prodottoInserito.setNome(nome);
			prodottoInserito.setCosto(Double.parseDouble(costo));
			prodottoInserito.setDescrizione(descrizione);
			prodottoInserito.setCodice(codice);
			prodottoInserito.setDisponibilita(Long.parseLong(disponibilita));
			
			facade.inserisciProdotto(prodottoInserito);
			HttpSession session = request.getSession();
			session.setAttribute("prodottoInserito",prodottoInserito);
			return "inserimentoProdottoOK";
		
		}
		else {
			Prodotto prodottoNonInserito = new Prodotto();
			prodottoNonInserito.setNome(nome);
			prodottoNonInserito.setCosto(null);
			prodottoNonInserito.setDescrizione(descrizione);
			prodottoNonInserito.setCodice(codice);
			prodottoNonInserito.setDisponibilita(null);
			request.setAttribute("prodottoNonInserito", prodottoNonInserito);
			return "inserimentoProdottoKO";

		}
	}
}
