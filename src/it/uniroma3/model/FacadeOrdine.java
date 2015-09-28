package it.uniroma3.model;

import java.util.List;

public interface FacadeOrdine {
	
	public void creaOrdine(Ordine ordine, List<RigaOrdine> lista);
	public void chiudiOrdine(Long id, String stato);
	public Long nuovoIdOrdine();
	public Cliente informazioniCliente(Long id);
	public List<Ordine> ordiniCliente(Cliente cliente);
	public Double costoProdottiOrdinati(Ordine ordine);
	public boolean ordinePresente(Long id,String stato);
	public void ordineEvaso(Long id, String stato);

}
