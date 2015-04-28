package addrModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataBase.ConnectionProvider;
import dataBase.JdbcUtil;

public class AddrDao {
	private static AddrDao instance=new AddrDao();
	
	public static AddrDao getInstance(){
		return instance;
	}
	
	public int insert(AddrDto addr){
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		int check=0;
		
		try{
			String sql="insert into addr values(addr_num_weq.nextval,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, addr.getName());
			pstmt.setString(2, addr.getPhone());
			pstmt.setString(3, addr.getEmail());
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("insert error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}
	
	public ArrayList<AddrDto> select(String name){
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<AddrDto> list=null;
		AddrDto addr=null;
		try{
			String sql="select * from addr where name=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs=pstmt.executeQuery();
			
			list=new ArrayList<AddrDto>();
			while(rs.next()){
				addr=new AddrDto();
				addr.setName(rs.getString("name"));
				addr.setPhone(rs.getString("phone"));
				addr.setEmail(rs.getString("email"));
				list.add(addr);
			}
		}catch(SQLException e){
			System.out.println("select error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return list;
	}
	
	public int delete(String name){
		int check=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		
		try{
			String sql="delete from addr where name = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("delete Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}
}
