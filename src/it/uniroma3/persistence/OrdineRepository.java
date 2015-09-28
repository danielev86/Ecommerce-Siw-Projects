package it.uniroma3.persistence;

import java.util.List;

import it.uniroma3.model.*;

public interface OrdineRepository {
	public void addOrdine(Ordine ordine);
	public void updateOrdine(Long id,String stato);
	public Long retrieveNewId();
	public Cliente retrieveInfoClienteByIdOrdine(Long id_ordine);
	public List<Ordine> retrieveOrdiniByCliente(Cliente cliente);
	public boolean verificaStatoOrdine(Long id_ordine,String stato);

}
