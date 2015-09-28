package it.uniroma3.persistence;

import it.uniroma3.model.Amministratore;

public interface AmministratoreRepository {
	
	public Amministratore findAmministratoreUsernamePassword(String username,String password);

}
