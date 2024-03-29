/**
 * 
 */
package projects.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import projects.exception.DbException;

/**
 * 
 */
public class DbConnection {
	
	private static String HOST = "localhost";
	private static String PASSWORD = "projects";
	private static int PORT = 3306;
	private static String SCHEMA = "projects";
	private static String USER = "projects";
	
	public static Connection getConnection() { 
		String URI = 
				String.format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=FALSE", HOST, PORT, SCHEMA, USER, PASSWORD);
				            
				System.out.println("Connecting with url " + URI);
		Connection conn;
		
		try {
			conn = DriverManager.getConnection(URI);
			System.out.println("Successfully obtained the connection!");
			return conn;
			
		} catch (SQLException e) {
			System.out.println("Error getting the connection.");
			throw new DbException(e);  
			         
		}
	}

}
