package it.uniroma3.model;

import it.uniroma3.persistence.AmministratoreRepository;
import it.uniroma3.persistence.postgres.repository.AmministratoreRepositoryImpl;

public class FacadeAmministratoreImpl implements FacadeAmministratore {
	
	public Amministratore loginAmministratore(String username,String password){
		AmministratoreRepository ammRep = new AmministratoreRepositoryImpl();
		return ammRep.findAmministratoreUsernamePassword(username, password);
	}

}
