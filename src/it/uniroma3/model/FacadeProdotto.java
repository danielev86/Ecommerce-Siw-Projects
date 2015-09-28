package it.uniroma3.model;
import java.util.*;

public interface FacadeProdotto {
	
	public List<Prodotto> restituisciProdotti();
	public void aggiornaDisponibilitaProdotto(Prodotto prodotto);
	public Double calcolaCostoUnitario(Prodotto prodotto);
	public void inserisciProdotto(Prodotto prodotto);

}
