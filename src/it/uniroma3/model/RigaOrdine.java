package it.uniroma3.model;

public class RigaOrdine {
	
	private Long id;
	private Double costo_unitario;
	private Long quantita;
	private Prodotto prodotto;
	
	
	public RigaOrdine(){
		
		
	}
	
	public Long getId(){
		return id;
	}
	
	public Double getCosto(){
		return costo_unitario;
	}
	
	public Long getQuantita(){
		return quantita;
	}
	
	public Prodotto getProdotto(){
		return prodotto;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	
	public void setCosto(Double costo_unitario){
		this.costo_unitario=costo_unitario;
	}
	
	public void setQuantita(Long quantita){
		this.quantita=quantita;
	}
	
	public void setProdotto(Prodotto prodotto){
		this.prodotto = prodotto;
	}
	
	

}
