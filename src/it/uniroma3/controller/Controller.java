package it.uniroma3.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String,String> comando2azione,esito2pagina;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prossimapagina=null;
		String comando = this.leggiComando(request.getServletPath());
		String nomeAzione = this.comando2azione.get(comando);
		if(nomeAzione==null){
			prossimapagina = "/error.jsp";
		}
		else{
			Azione azione = null;
			try{
				azione = (Azione) Class.forName(nomeAzione).newInstance();
				String esitoAzione = azione.esegui(request);
				prossimapagina = this.esito2pagina.get(esitoAzione);
			}catch(InstantiationException e){
				prossimapagina = "/error.jsp";
			}catch(IllegalAccessException e){
				prossimapagina = "/error.jsp";
			}catch(ClassNotFoundException e){
				prossimapagina = "/error.jsp";
			}
		}
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(prossimapagina);
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String prossimapagina = null;
		String comando = this.leggiComando(request.getServletPath());
		String nomeAzione = this.comando2azione.get(comando);
		if(nomeAzione == null){
			prossimapagina = "/error.jsp";
		}else{
			Azione azione = null;
			try{
				azione = (Azione) Class.forName(nomeAzione).newInstance();
				String esitoAzione = azione.esegui(request);
				prossimapagina = this.esito2pagina.get(esitoAzione);
			}catch(InstantiationException e){
				prossimapagina = "/error.jsp";
			}catch(IllegalAccessException e){
				prossimapagina = "/error.jsp";
			}catch(ClassNotFoundException e){
				prossimapagina = "/error.jsp";
			}
		}
		RequestDispatcher rd = this.getServletContext().getRequestDispatcher(prossimapagina);
		rd.forward(request, response);
	}
	
	private String leggiComando(String servletPath) {
        StringBuffer str = new StringBuffer(servletPath);
        return str.substring(1,str.lastIndexOf(".do"));
	 }
	
	public void init(){
		this.comando2azione = new HashMap<String,String>();
		this.esito2pagina = new HashMap<String,String>();
		this.comando2azione.put("dettaglioProdotto","it.uniroma3.controller.DettaglioProdottoAction");
		this.comando2azione.put("dettaglioProdottoOrdine","it.uniroma3.controller.DettaglioProdottoOrdineAction");
		this.comando2azione.put("login", "it.uniroma3.controller.LoginAction");
		this.comando2azione.put("aggiungiProdottoOrdine", "it.uniroma3.controller.AcquistaProdottoAction");
		this.comando2azione.put("completaOrdine", "it.uniroma3.controller.CompletaOrdineAction");
		this.comando2azione.put("logout","it.uniroma3.controller.LogoutAction");
		this.comando2azione.put("ricercaOrdineCliente", "it.uniroma3.controller.RicercaOrdineClienteAction");
		this.comando2azione.put("inserimentoProdotto", "it.uniroma3.controller.InserimentoProdottoAction");
		this.comando2azione.put("evasioneOrdine", "it.uniroma3.controller.AggiornaStatoOrdineAction");
		
		this.esito2pagina.put("dettaglioProdotto", "/dettaglioProdotto.jsp");
		this.esito2pagina.put("loginOk", "/accesso.jsp");
		this.esito2pagina.put("loginKo", "/login.jsp");
		this.esito2pagina.put("prodottoOk", "/effettuaOrdine.jsp");
		this.esito2pagina.put("prodottoKo", "/aggiungiOrdine.jsp");
		this.esito2pagina.put("dettaglioProdottoOrdine", "/aggiungiOrdine.jsp");
		this.esito2pagina.put("ordineCompletoOk", "/accesso.jsp");
		this.esito2pagina.put("logoutOk", "/home.jsp");
		this.esito2pagina.put("ricercaClientePerOrdineOk", "/dettaglioCliente.jsp");
		this.esito2pagina.put("ricercaClientePerOrdineKo", "/informazioniCliente.jsp");
		this.esito2pagina.put("inserimentoProdottoOK", "/prodottoInserito.jsp");
		this.esito2pagina.put("inserimentoProdottoKO", "/inserisciProdotto.jsp");
		this.esito2pagina.put("aggiornaOrdineOk", "/accesso.jsp");
		this.esito2pagina.put("aggiornaOrdineKo", "/evasioneOrdine.jsp");
		
	}

}
