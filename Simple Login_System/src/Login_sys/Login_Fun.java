package Login_sys;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Database.DbConnection;

public class Login_Fun {
	
	protected boolean checkLogin(String name, String pasString) {
		
		Connection conn = new DbConnection().connect();
		String sqlString = "select * from login_sys where name = ? and password = ?;";
		
		try {
			PreparedStatement pStatement = conn.prepareStatement(sqlString);
			pStatement.setString(1, name);
			pStatement.setString(2, pasString);
			
			ResultSet rSet = pStatement.executeQuery();
			if(rSet.next()) {
				JOptionPane.showMessageDialog(null, "Login Succeeded!");
				return true;
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Login Failed!");
				System.out.println(name + pasString);
				return false;
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
