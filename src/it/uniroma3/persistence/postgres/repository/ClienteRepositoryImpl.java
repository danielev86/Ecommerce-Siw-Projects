
package it.uniroma3.persistence.postgres.repository;
import it.uniroma3.persistence.*;
import it.uniroma3.persistence.postgres.*;
import java.util.*;
import java.sql.*;

import it.uniroma3.model.*;


public class ClienteRepositoryImpl implements ClienteRepository{
	
	private DataSource data;

	
	public ClienteRepositoryImpl(){
		data = new DataSource();
		
	}
	
	
	public Cliente findClienteCognomeEmail(String username,String password){
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement statement = null;
		Cliente cliente = null;
		String sql ="select * from cliente where (email=?) AND (cognome=?)";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			result = statement.executeQuery();
			if(result.next()){
				cliente = new Cliente();
				cliente.setId(result.getLong("id"));
				cliente.setNome(result.getString("nome"));
				cliente.setCognome(result.getString("cognome"));
				cliente.setEmail(result.getString("email"));
				cliente.setIndirizzo(result.getString("indirizzo"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
				data.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		return cliente;
	}
	
	
	

	
}
