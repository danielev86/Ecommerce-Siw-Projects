package it.uniroma3.persistence;

import it.uniroma3.model.Prodotto;

import java.util.List;

public interface ProdottoRepository {
	public List<Prodotto> findProdotto();
	public void aggiornaDisponibilita(Prodotto prodotto);
	public Prodotto retrieveProdottoByRigaOrdine(Long id_riga);
	public void addProdotto(Prodotto prodotto);
}
