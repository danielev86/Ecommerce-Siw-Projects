package it.uniroma3.persistence.postgres;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import com.mchange.v2.c3p0.*;

public class DataSource {
	private static Logger logger = Logger.getLogger("it.uniroma3.persistence.postgres.DataSource");
	private ComboPooledDataSource cpds;
	private static DataSource instance;

	public DataSource(){
		InputStream inputStream = null;
		Properties conf = new Properties();
		
		try {
			inputStream = this.getClass().getClassLoader().getResourceAsStream("META-INF/jdbc.properties");
			conf.load(inputStream);
		} catch (IOException e) {
			logger.severe("Error loading the Data Source property file: "+ e.getMessage());
		}			
		String uri = conf.getProperty("uri");
		String password = conf.getProperty("password");
		String username = conf.getProperty("username");
		String driver = conf.getProperty("driver");
		
		this.cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass(driver);
		} catch (PropertyVetoException e) {
			logger.severe("Error Loading Class Driver " + e.getMessage());
		} 
		this.cpds.setJdbcUrl(uri);
		this.cpds.setUser(username);                                  
		this.cpds.setPassword(password); 
		cpds.setMinPoolSize(5); 
		cpds.setAcquireIncrement(5); 
		cpds.setMaxPoolSize(20);

		

		

	}

	public static DataSource getInstance(){
		if (instance==null) 
			instance = new DataSource();
		return instance;
	}

	public Connection getConnection()  {
		Connection connection = null;
		try {
			connection = cpds.getConnection();
		} catch (SQLException e) {
			logger.severe("Connessione non creata "+ e.getMessage());
		}
		return connection;
	}
	
	public void close(){
		cpds.close();
		
	}
	

	

}

