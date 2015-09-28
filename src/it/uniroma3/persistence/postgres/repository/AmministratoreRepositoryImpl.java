package it.uniroma3.persistence.postgres.repository;

import it.uniroma3.model.Amministratore;
import it.uniroma3.persistence.postgres.DataSource;
import it.uniroma3.persistence.*;
import java.sql.*;

public class AmministratoreRepositoryImpl implements AmministratoreRepository {
private DataSource data;

	
	public AmministratoreRepositoryImpl(){
		data = new DataSource();
	}
	
	public Amministratore findAmministratoreUsernamePassword(String username,String password){
		Amministratore amministratore = null;
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet result = null;
		String sql = "select * from amministratore where (username=?) AND (password=?)";
		try{
			connection = data.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			result = statement.executeQuery();
			if(result.next()){
				amministratore = new Amministratore();
				amministratore.setId(result.getLong("id"));
				amministratore.setUsername(result.getString("username"));
				amministratore.setPassword(result.getString("password"));
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
		return amministratore;
	}

}
