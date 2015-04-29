package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	
	public static void close(Connection conn){
		try{
			if(conn!=null) conn.close();
		}catch(SQLException e){
			System.out.println("Connection Close Error");
			e.printStackTrace();
		}
	}
	
	public static void close(PreparedStatement pstmt){
		try{
			if(pstmt!=null) pstmt.close();
		}catch(SQLException e){
			System.out.println("PreparedStatement Close Error");
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try{
			if(rs!=null) rs.close();
		}catch(SQLException e){
			System.out.println("ResultSet Close Error");
			e.printStackTrace();
		}
	}
	
	public static void rollBack(Connection conn){
		try{
			if(conn!=null) conn.rollback();
		}catch(SQLException e){
			System.out.println("rollback Error");
			e.printStackTrace();
		}
	}
}
