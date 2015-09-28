package it.uniroma3.persistence.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class IdBroker {
	private static Logger logger = Logger.getLogger("it.uniroma3.persistence.IdBroker");
	private static boolean created = true; 
	

	public IdBroker(){
		
	}
	
	private static void createSequence(Connection connection) {
		PreparedStatement statement=null;
		final String ddlStatement = "CREATE SEQUENCE sequenza_id START WITH 1 INCREMENT BY 1 MINVALUE 0 MAXVALUE 9999999 NO CYCLE";
		try {
			statement = connection.prepareStatement(ddlStatement);
			if(statement.executeUpdate()==1)
				created = true; 
		} catch (SQLException e) {
			logger.severe("Errore SQL: " + e.getMessage());
			
		}finally {
			try {
				if(statement != null) statement.close();
				if(connection != null) connection.close();
				
	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
	}


	

	public static Long getId(Connection connection) {
		long id = 1;
		final String query = "SELECT nextval('sequenza_id') AS id";
		ResultSet result = null;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(query);
			result = statement.executeQuery();
			result.next();
			id = result.getLong("id");
		} catch (SQLException e) {
			created=false;
			if (!created) {
				createSequence(connection);
				
			}
			
			
		}finally {
			try {
				if(result != null) result.close();
				if(statement != null) statement.close();
				if(connection != null) connection.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
		}
		
		return new Long(id);
	}

}
