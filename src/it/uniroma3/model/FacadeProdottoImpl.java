package it.uniroma3.model;
import java.util.*;
import it.uniroma3.persistence.ProdottoRepository;
import it.uniroma3.persistence.postgres.repository.ProdottoRepositoryImpl;

public class FacadeProdottoImpl implements FacadeProdotto {
	
	public List<Prodotto> restituisciProdotti(){
		ProdottoRepository prRep = new ProdottoRepositoryImpl();
		return prRep.findProdotto();
		
	}
	
	public void aggiornaDisponibilitaProdotto(Prodotto prodotto){
		ProdottoRepository prRep = new ProdottoRepositoryImpl();
		prRep.aggiornaDisponibilita(prodotto);
	}
	
	public Double calcolaCostoUnitario(Prodotto prodotto){
		if(prodotto.getDisponibilita()>0)
			return prodotto.getCosto()/prodotto.getDisponibilita();
		else return 0.0;
	}
	public void inserisciProdotto(Prodotto prodotto){
		ProdottoRepository prRep = new ProdottoRepositoryImpl();
		prRep.addProdotto(prodotto);
	}
}

