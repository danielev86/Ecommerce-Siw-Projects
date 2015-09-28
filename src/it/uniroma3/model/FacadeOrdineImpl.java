package it.uniroma3.model;

import it.uniroma3.persistence.*;
import it.uniroma3.persistence.postgres.repository.OrdineRepositoryImpl;
import it.uniroma3.persistence.postgres.repository.RigaOrdineRepositoryImpl;
import java.util.*;

public class FacadeOrdineImpl implements FacadeOrdine{
	
	public void creaOrdine(Ordine ordine,List<RigaOrdine> listaOrd){
		FacadeRigaOrdine facade = new FacadeRigaOrdineImpl();
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		ordRep.addOrdine(ordine);
		for(RigaOrdine result:listaOrd)
			facade.aggiungiProdottoOrdine(result, ordine.getId());
		
		
	}
	public void chiudiOrdine(Long id, String stato){
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		ordRep.updateOrdine(id, stato);
	}
	
	public Long nuovoIdOrdine(){
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		return ordRep.retrieveNewId();
	}
	
	public Cliente informazioniCliente(Long id){
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		return ordRep.retrieveInfoClienteByIdOrdine(id);
		
	}
	
	public List<Ordine> ordiniCliente(Cliente cliente){
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		return ordRep.retrieveOrdiniByCliente(cliente);
	}
	
	public Double costoProdottiOrdinati(Ordine ordine){
		Double tot=0.0;
		for(RigaOrdine result:ordine.getRighe())
			tot += (result.getCosto()*result.getQuantita());
		return tot;
			
			
	}
	public boolean ordinePresente(Long id,String stato){
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		return ordRep.verificaStatoOrdine(id, stato);
		
	}
	
	public void ordineEvaso(Long id, String stato){
		OrdineRepository ordRep = new OrdineRepositoryImpl();
		ordRep.updateOrdine(id, stato);
	}
}
