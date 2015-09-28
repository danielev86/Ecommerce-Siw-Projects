package it.uniroma3.model;
import java.util.*;

public class Cliente {
	
	private Long id;
	private String nome,cognome,email,indirizzo;
	private Map<Long,Ordine> id2ordine;
	
	public Cliente(){
		id2ordine= new HashMap<Long,Ordine>();
	}
	
	public Long getId(){
		return id;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getCognome(){
		return cognome;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getIndirizzo(){
		return indirizzo;
	}
	
	public Map<Long,Ordine> getOrdini(){
		return id2ordine;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public void setNome(String nome){
		this.nome=nome;
	}
	
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public void setIndirizzo(String indirizzo){
		this.indirizzo=indirizzo;
	}
	
	public void setOrdine(Ordine ordine){
		id2ordine.put(ordine.getId(), ordine);
	}
	

}
