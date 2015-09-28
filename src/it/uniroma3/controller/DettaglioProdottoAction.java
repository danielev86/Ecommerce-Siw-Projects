package it.uniroma3.controller;
import it.uniroma3.model.Prodotto;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DettaglioProdottoAction extends Azione{
	
	public String esegui(HttpServletRequest request)throws ServletException{
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		String prezzo = request.getParameter("prezzo");
		String codice = request.getParameter("codice");
		String disponibilita = request.getParameter("disponibilita");
		Prodotto prodotto = new Prodotto();
		prodotto.setNome(nome);
		prodotto.setDescrizione(descrizione);
		prodotto.setCosto(Double.parseDouble(prezzo));
		prodotto.setCodice(codice);
		prodotto.setDisponibilita(Long.parseLong(disponibilita));
		HttpSession session = request.getSession();
		session.setAttribute("prodotto", prodotto);
		return "dettaglioProdotto";
		
	}

}
