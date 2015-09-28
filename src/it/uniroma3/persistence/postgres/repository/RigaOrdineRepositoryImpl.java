package it.uniroma3.persistence.postgres.repository;

import it.uniroma3.persistence.RigaOrdineRepository;
import it.uniroma3.persistence.postgres.DataSource;
import it.uniroma3.persistence.postgres.IdBroker;
import it.uniroma3.persistence.postgres.proxy.RigaOrdineProxy;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import it.uniroma3.model.*;

public class RigaOrdineRepositoryImpl implements RigaOrdineRepository {
private DataSource data;
	
	public RigaOrdineRepositoryImpl(){
		data = new DataSource();
		
	}
	
	public Long retrieveNewId(){
		Connection connection = data.getConnection();
		Long id = IdBroker.getId(connection);
		data.close();
		return  id;
		
	}
	
	public void addRigaOrdine(RigaOrdine riga,Long id_ordine){
		PreparedStatement statement = null;
		Connection connection = data.getConnection();
		
		
		String sql = "INSERT INTO rigaordine(id,costo_unitario,quantita,nome_prodotto,id_ordine) VALUES(?,?,?,?,?)";
		
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1,riga.getId());
			statement.setDouble(2,riga.getCosto());
			statement.setLong(3, riga.getQuantita());
			statement.setString(4,riga.getProdotto().getNome());
			statement.setLong(5,id_ordine);
			statement.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				if(statement != null) statement.close();
				if(connection != null) connection.close();
				data.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
	}
	
	public List<RigaOrdine> retrieveRigaOrdineByOrdine(Long id_ordine){
		Connection connection = null;
		PreparedStatement statement = null;
		List<RigaOrdine> listaRigaOrdini = new LinkedList<RigaOrdine>();
		ResultSet result = null;
		String sql = "select id, costo_unitario, quantita, nome_prodotto from rigaordine  where id_ordine=? ";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id_ordine);
			result = statement.executeQuery();
			while(result.next()){
				RigaOrdine tmp = new RigaOrdineProxy();
				tmp.setId(result.getLong("id"));
				tmp.setCosto(result.getDouble("costo_unitario"));
				tmp.setQuantita(result.getLong("quantita"));
				listaRigaOrdini.add(tmp);		
				
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(connection !=null) connection.close();
				data.close();
				
			}catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		return listaRigaOrdini;
	}
	
	

	

}
