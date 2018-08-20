package web.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccessDatabase {
	static final String url = "jdbc:postgresql://localhost:5432/TEST";
    static final String name = "org.postgresql.Driver";  
    static final String user = "postgres";  
    static final String password = "java";  
    Connection con = null; 
     Statement statement= null;
    
	static
	{
		try
			{
			 Class.forName(name);//指定连接类型  
			}
		catch(ClassNotFoundException cE)
			{
				System.out.println("Class Not Found Exception:"+cE.toString());
			}
	}
	public Connection getConnection()
	{
		try {
			return DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void closeConnection(ResultSet rs,Statement statement,Connection con)
	{
			try {
				if(rs!=null)rs.close();
				if(statement!=null)statement.close();
				if(con!=null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public static void closeConnection(Statement statement,Connection con)
	{
		closeConnection(null,statement,con);
	}
}
