package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	Connection conn;
	
	public Connection connect() {
	
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/login_system","root","root");
			System.out.println("Successfully connected!");
			
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Connection Failed!");
		}
		
	return conn;
	}
	

}
