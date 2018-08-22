package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerData {
	
	public int verifyLogin(String login, String password) {
		int result = 0;
		AccessDatabase db = new AccessDatabase();
		String sql = "select count(*) as rows from login_password where email = ? and password = ?";
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		conn = db.getConnection();
		System.out.println("Connected to database successfully.");
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, login);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				result = rs.getInt("rows");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = -1;
		}
		
		return result;
	}
	
	public int signUp(String email, String name, String surname, String password) {
		int result = 0;
		String sql = "insert into login_password (email, name, surname, password) values(?, ?, ?, ?)";
		
		AccessDatabase db = new AccessDatabase();
		Connection conn = null;
		PreparedStatement ps = null;
		
		conn = db.getConnection();
		System.out.println("Connected to database successfully.");
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, surname);
			ps.setString(4, password);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
