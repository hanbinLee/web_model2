package guestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dataBase.ConnectionProvider;
import dataBase.JdbcUtil;

public class GuestDao {
	private static GuestDao instance=new GuestDao();
	
	public static GuestDao getInstance(){
		return instance;
	}
	
	public int getCount(){
		int count=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql="select count(*) as cnt from board";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) count=rs.getInt("cnt");
		}catch(SQLException e){
			System.out.println("getCount Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return count;
	}
	
	public ArrayList<GuestDto> getGuestList(int startPage,int endPage){
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<GuestDto> list=null;
		
		try{
			String sql="select * from(select rownum rnum, a.* from (select * from guest order by num desc) a )where rnum>=? and rnum<=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startPage);
			pstmt.setInt(2, endPage);			
			rs=pstmt.executeQuery();
			
			list=new ArrayList<GuestDto>();
			while(rs.next()){
				GuestDto guest=new GuestDto();
				guest.setName(rs.getString("name"));
				guest.setPassword(rs.getString("password"));
				guest.setMessage(rs.getString("message"));
				guest.setWriteDate(rs.getTimestamp("write_date"));
				
				list.add(guest);
			}
		}catch(SQLException e){
			System.out.println("getGuestList Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return list;
	}
}
