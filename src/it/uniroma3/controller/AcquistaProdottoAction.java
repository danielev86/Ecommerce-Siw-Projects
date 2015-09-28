package it.uniroma3.controller;

import it.uniroma3.model.*;
import it.uniroma3.persistence.ProdottoRepository;
import it.uniroma3.persistence.postgres.repository.ProdottoRepositoryImpl;

import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class AcquistaProdottoAction extends Azione{
	
	public String esegui(HttpServletRequest request)throws ServletException{
	
		String quantita = request.getParameter("quantita");
		
		Helper helper = new HelperCompraProdotto(request);
		if(helper.convalida()){
			
			HttpSession session = request.getSession();
			Prodotto prodottoOrdine = (Prodotto) session.getAttribute("prodottoOrdine");
			Long tot = Long.parseLong(quantita);
			Long tmp = prodottoOrdine.getDisponibilita();
			
			if(tmp>=tot){
				FacadeRigaOrdine facRiga = new FacadeRigaOrdineImpl();
				RigaOrdine rigaOrdine = new RigaOrdine();
				rigaOrdine.setProdotto(prodottoOrdine);
				rigaOrdine.setQuantita(tot);
				rigaOrdine.setCosto(prodottoOrdine.getCosto());
				rigaOrdine.setId(facRiga.nuovoIdRiga());
				List<RigaOrdine> listaOrd = (List<RigaOrdine>) session.getAttribute("listaOrd");
				if(listaOrd==null){
					listaOrd = new LinkedList<RigaOrdine>();
					listaOrd.add(rigaOrdine);
				}else listaOrd.add(rigaOrdine);
				session.setAttribute("listaOrd", listaOrd);
				FacadeProdotto facProd = new FacadeProdottoImpl();
				prodottoOrdine.setDisponibilita(tmp-tot);
				facProd.aggiornaDisponibilitaProdotto(prodottoOrdine);
				boolean prodottoIns = true;
				session.setAttribute("prodottoIns", prodottoIns);
				return "prodottoOk";
			}else return "prodottoKo";
				
			
			
			
			
				
			
		}else return "prodottoKo";
		
		
	
		
		
	}

}