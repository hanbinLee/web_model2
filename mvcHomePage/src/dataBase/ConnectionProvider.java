package dataBase;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionProvider {
	
	public static Connection getConnection(){
		Connection conn=null;
		
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/mvcDB");
			conn = ds.getConnection();
		} catch (Exception e) {
			System.out.println("Connection Provider Error");
			e.printStackTrace();
		}
			return conn;
	}
}
