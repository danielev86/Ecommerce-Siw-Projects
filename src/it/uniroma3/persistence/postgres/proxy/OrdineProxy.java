package it.uniroma3.persistence.postgres.proxy;

import java.util.*;

import it.uniroma3.model.*;
import it.uniroma3.persistence.RigaOrdineRepository;
import it.uniroma3.persistence.postgres.repository.RigaOrdineRepositoryImpl;

public class OrdineProxy extends Ordine{
	
	private List<RigaOrdine> righe;
	
	public List<RigaOrdine> getRighe(){
		List<RigaOrdine> righe = new LinkedList<RigaOrdine>();
		RigaOrdineRepository rigRep = new RigaOrdineRepositoryImpl();
		righe = rigRep.retrieveRigaOrdineByOrdine(this.getId());
		for(RigaOrdine result:righe)
			this.setRighe(result);
		return righe;
	}

}
