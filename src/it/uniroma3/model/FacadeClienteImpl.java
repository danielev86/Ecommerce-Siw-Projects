package it.uniroma3.model;

import it.uniroma3.persistence.ClienteRepository;
import it.uniroma3.persistence.postgres.repository.ClienteRepositoryImpl;

public class FacadeClienteImpl implements FacadeCliente{
	
	public Cliente loginCliente(String username,String password){
		ClienteRepository cliRep = new ClienteRepositoryImpl();
		return cliRep.findClienteCognomeEmail(username, password);
	}

}
