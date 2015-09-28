package it.uniroma3.model;

import java.io.Serializable;

public class Prodotto implements Serializable {
	
	private String nome,codice,descrizione;
	private Double costo;
	private Long disponibilita; 
	

	
	public Prodotto(){
		
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public Double getCosto(){
		return costo;
	}
	
	public String getCodice(){
		return codice;
	}
	
	public Long getDisponibilita(){
		return disponibilita;
	}
	

	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	
	public void setDescrizione(String descrizione){
		this.descrizione=descrizione;
	}
	
	public void setCosto(Double costo){
		this.costo=costo;
	}
	
	public void setCodice(String codice){
		this.codice=codice;
	}
	
	public int hashcode(){
		return this.nome.hashCode();
	}

	public void setDisponibilita(Long temp){
		disponibilita = temp;
	}
	
	

	

}
