package web.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

			while (rs.next()) {
				result = rs.getInt("rows");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = -1;
		}

		if (result == 1) {
			userInfo(login);
		}

		return result;
	}

	public ArrayList userInfo(String login) {
		ArrayList list = new ArrayList();

		String userParams = "select surname, name, email from login_password where email = ?";

		AccessDatabase db = new AccessDatabase();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = db.getConnection();
			ps = conn.prepareStatement(userParams);
			ps.setString(1, login);
			ResultSetMetaData rsmd = rs.getMetaData();
			Object surname = null;
			Object name = null;
			Object email = null;
			int columns = rsmd.getColumnCount();

			while (rs.next()) {
				surname = rs.getObject(1);
				name = rs.getObject(2);
				email = rs.getObject(3);

				HashMap row = new HashMap();

				for (int i = 1; i <= columns; i++) {
					row.put(rsmd.getColumnName(i), rs.getObject(i));
				}
				row.put("surname", surname);
				row.put("name", name);
				row.put("email", email);
				list.add(row);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				rs = null;
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ps = null;
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		if(list.isEmpty()) {
			list.add("erzhikk");
		}
		System.out.println("LIst size = " + list.size());
		return list;
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

			result = ps.executeUpdate();
			System.out.println("Result is " + result);
		} catch (SQLException e) {
			System.out.println("Result is " + result);
			System.out.println("Exception in SQL: " + e.toString());

		}
		return result;
	}

}
