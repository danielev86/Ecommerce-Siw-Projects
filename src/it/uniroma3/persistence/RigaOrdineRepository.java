package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.Prodotto;
import it.uniroma3.model.RigaOrdine;

public interface RigaOrdineRepository {
	
	public void addRigaOrdine(RigaOrdine riga,Long id_ordine);
	public Long retrieveNewId();
	public List<RigaOrdine> retrieveRigaOrdineByOrdine(Long id_ordine);

}
