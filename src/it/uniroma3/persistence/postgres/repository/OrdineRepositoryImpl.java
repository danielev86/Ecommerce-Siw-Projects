package it.uniroma3.persistence.postgres.repository;

import it.uniroma3.persistence.OrdineRepository;
import it.uniroma3.persistence.RigaOrdineRepository;
import it.uniroma3.persistence.postgres.DataSource;
import it.uniroma3.persistence.postgres.IdBroker;
import it.uniroma3.persistence.postgres.proxy.OrdineProxy;

import java.sql.*;
import java.util.*;

import it.uniroma3.model.*;

public class OrdineRepositoryImpl implements OrdineRepository{
	
	
	private DataSource data;

	
	public OrdineRepositoryImpl(){
		data = new DataSource();
		
	}
	
	public Long retrieveNewId(){
		Connection connection = data.getConnection();
		Long id = IdBroker.getId(connection);
		data.close();
		return  id;
		
	}
	
	
	public void addOrdine(Ordine ordine){
		Connection connection = null;
		PreparedStatement statement = null;
	
		
		String sql = "INSERT INTO ordine(id,data,stato,id_cliente) VALUES(?,?,?,?)";
		try{
			connection = data.getConnection();

			statement = connection.prepareStatement(sql);
			statement.setLong(1, ordine.getId());
			statement.setDate(2, new java.sql.Date(ordine.getData().getTime()));
			statement.setString(3, ordine.getStato());
			statement.setLong(4, ordine.getCliente().getId());
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
	
	
	public void updateOrdine(Long id,String stato){
		Connection connection = null;
		PreparedStatement statement = null;
		String sql="UPDATE ordine SET stato=? WHERE id=?";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, stato);
			statement.setLong(2, id);
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
	public Ordine retrieveTuttiOrdini(Cliente cliente){
		Ordine ordine = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Connection connection = null;
		String sql = "select * from ordine as o join rigaordine as r on o.id = r.id_ordine where id_cliente = ?";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, cliente.getId());
			result = statement.executeQuery();
			
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
			
		} return ordine;
		
	}
	
	public Cliente retrieveInfoClienteByIdOrdine(Long id_ordine){
		Cliente cliente = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		Connection connection = null;
		String sql ="select c.id as id, c.nome as nome, c.cognome as cognome, c.email as email, c.indirizzo as indirizzo from ordine o join cliente c on o.id_cliente= c.id where o.id =?";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1,id_ordine);
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
		return cliente;
	}
	
	public List<Ordine> retrieveOrdiniByCliente(Cliente cliente){
		Connection connection = null;
		PreparedStatement statement = null;
		List<Ordine> listaOrdini = new LinkedList<Ordine>();
		ResultSet result = null;
		String sql = "select id ,data, stato from ordine where id_cliente=? order by id,data";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, cliente.getId());
			result = statement.executeQuery();
			while(result.next()){
				Ordine ordine = new OrdineProxy();
				ordine.setId(result.getLong("id"));
				ordine.setData(new java.util.Date(result.getDate("data").getTime()));
				ordine.setStato(result.getString("stato"));
				listaOrdini.add(ordine);
	
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
		return listaOrdini;
	}
	
	
	public boolean verificaStatoOrdine(Long id_ordine,String stato){
		
		boolean presente = false;
		PreparedStatement statement = null;
		ResultSet result = null;
		Connection connection = null;
		
		String sql = "select id,stato from ordine where (id=?) and (stato=?)";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1,id_ordine);
			statement.setString(2, stato);
			result = statement.executeQuery();
			if(result.next()){
				
				presente = true;
				
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
		return presente;
		
	}
	

}
