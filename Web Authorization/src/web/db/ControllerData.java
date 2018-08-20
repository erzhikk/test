package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerData {
	
	public int verifyLogin(String login, String password) {
		int result = 0;
		AccessDatabase db = new AccessDatabase();
		String sql = "select count(*) as rows from login_password where login = ? and password = ?";
		
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

}
