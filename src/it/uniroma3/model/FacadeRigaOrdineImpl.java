package it.uniroma3.model;

import it.uniroma3.persistence.*;
import it.uniroma3.persistence.RigaOrdineRepository;
import it.uniroma3.persistence.postgres.repository.OrdineRepositoryImpl;
import it.uniroma3.persistence.postgres.repository.RigaOrdineRepositoryImpl;

public class FacadeRigaOrdineImpl implements FacadeRigaOrdine {
	
	public void aggiungiProdottoOrdine(RigaOrdine riga,Long id_ordine){
		RigaOrdineRepository rorRep = new RigaOrdineRepositoryImpl();
		rorRep.addRigaOrdine(riga, id_ordine);
	}
	public Long nuovoIdRiga(){
		RigaOrdineRepository ordRep = new RigaOrdineRepositoryImpl();
		return ordRep.retrieveNewId();
	}

}
