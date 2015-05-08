package dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTesting {
	
	public void getDB(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			conn=ConnectionProvider.getConnection();
			pstmt=conn.prepareStatement("select * from addr");
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println(rs.getString("name"));
			}
			
		}catch(SQLException e){
			System.out.println("getDB error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
	}
}
