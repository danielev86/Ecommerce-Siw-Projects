package it.uniroma3.persistence;
import java.util.*;
import it.uniroma3.model.*;


public interface ClienteRepository {
	
	public Cliente findClienteCognomeEmail(String username,String password);

}
