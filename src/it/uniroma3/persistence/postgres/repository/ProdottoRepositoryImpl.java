package it.uniroma3.persistence.postgres.repository;

import it.uniroma3.model.Prodotto;
import it.uniroma3.persistence.*;
import it.uniroma3.persistence.postgres.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class ProdottoRepositoryImpl implements ProdottoRepository {
	
	private DataSource data;
	
	public ProdottoRepositoryImpl(){
		data = new DataSource();
		
	}
	
	
	public List<Prodotto> findProdotto(){
		List<Prodotto> lista = new LinkedList<Prodotto>();
		PreparedStatement statement = null;
		ResultSet result = null;
		Connection connection = data.getConnection();
		String sql = "select * from prodotto where disponibilita >0 order by nome";
		try {
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while (result.next()){
				Prodotto prodotto = new Prodotto();
				prodotto.setNome(result.getString("nome"));
				prodotto.setCosto(result.getDouble("costo"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setCodice(result.getString("codice"));
				prodotto.setDisponibilita(result.getLong("disponibilita"));
				lista.add(prodotto);
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
		return lista;
	}
	
	public void aggiornaDisponibilita(Prodotto prodotto){
		Connection connection = null;
		PreparedStatement statement = null;
		String sql = "UPDATE prodotto SET disponibilita=? where nome=?";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, prodotto.getDisponibilita());
			statement.setString(2, prodotto.getNome());
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
	
	public Prodotto retrieveProdottoByRigaOrdine(Long id_riga){
		PreparedStatement statement = null;
		Prodotto prodotto = null;
		ResultSet result = null;
		Connection connection = null;
		String sql = "select nome,costo,descrizione,codice,disponibilita from rigaordine join prodotto on nome_prodotto = nome where id=?";
		try {
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setLong(1, id_riga);
			result = statement.executeQuery();
			if(result.next()){
				prodotto = new Prodotto();
				prodotto.setNome(result.getString("nome"));
				prodotto.setCosto(result.getDouble("costo"));
				prodotto.setDescrizione(result.getString("descrizione"));
				prodotto.setCodice(result.getString("codice"));
				prodotto.setDisponibilita(result.getLong("disponibilita"));
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
		return prodotto;
		
	}
	
	public void addProdotto(Prodotto prodotto){
		PreparedStatement statement = null;
		Connection connection = null;
		
		String sql = "insert into prodotto(nome,costo,descrizione, codice, disponibilita) values(?,?,?,?,?)";
		try {
			connection= data.getConnection();
			statement= connection.prepareStatement(sql);
			statement.setString(1, prodotto.getNome());
			statement.setDouble(2, prodotto.getCosto());
			statement.setString(3, prodotto.getDescrizione());
			statement.setString(4, prodotto.getCodice());
			statement.setLong(5, prodotto.getDisponibilita());
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

}


