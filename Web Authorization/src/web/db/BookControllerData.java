package web.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BookControllerData {
	public int addBook(String bookname, String bookauthor, String bookprice, String isbn_code) {
		int result = 0;
		int book_price = Integer.parseInt(bookprice);
		AccessDatabase db = new AccessDatabase();
		String sql = "insert into books_shell (book_name, book_author, book_price, ISBN_code) values (?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, bookname);
			stmt.setString(2, bookauthor);
			stmt.setInt(3, book_price);
			stmt.setString(4, isbn_code);
			result = stmt.executeUpdate();
			System.out.println("Result == " + result);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = -1;
			System.out.println("Result == " + result);
		}finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stmt = null;
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
		
		return result;
	}

}
