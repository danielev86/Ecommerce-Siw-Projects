package it.uniroma3.persistence.postgres.proxy;

import it.uniroma3.model.*;
import it.uniroma3.persistence.ProdottoRepository;
import it.uniroma3.persistence.postgres.repository.ProdottoRepositoryImpl;

public class RigaOrdineProxy extends RigaOrdine {	

	
	
	public Prodotto getProdotto(){
		Prodotto prodotto = new Prodotto();
		ProdottoRepository prodRep = new ProdottoRepositoryImpl();
		prodotto = prodRep.retrieveProdottoByRigaOrdine(this.getId());
		this.setProdotto(prodotto);
		return prodotto;
	}
	
}
