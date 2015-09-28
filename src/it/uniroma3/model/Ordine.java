package it.uniroma3.model;
import java.io.Serializable;
import java.util.*;

public class Ordine implements Serializable{
	
	private Long id;
	private Date data;
	private String stato;
	private List<RigaOrdine> righe;
	private Cliente cliente;
	
	
	public Ordine(){
		righe = new LinkedList<RigaOrdine>();
	}
	
	
	public Long getId(){
		return id;
	}
	
	
	public Date getData(){
		return data;
	}
	
	public List<RigaOrdine> getRighe(){
		return righe;
	}
	
	public String getStato(){
		return this.stato;
	}
	
	public Cliente getCliente(){
		return cliente;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	
	public void setData(Date data){
		this.data=data;
	}
	
	public void setStato(String stato){
		this.stato=stato;
	}
	
	public void setRighe(RigaOrdine ro){
		righe.add(ro);		
	}
	
	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}
	
	public int hashcode(){
		return id.intValue();
	}


}
