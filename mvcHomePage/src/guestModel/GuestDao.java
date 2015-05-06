package guestModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
			String sql="select count(*) as cnt from guest";
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
				guest.setNum(rs.getInt("num"));
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
	
	public int insert(GuestDto guest){
		int check=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		
		try{
			String sql="insert into guest values(guest_num_seq.nextval,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, guest.getName());
			pstmt.setString(2, guest.getPassword());
			pstmt.setString(3, guest.getMessage());
			pstmt.setTimestamp(4, new Timestamp(guest.getWriteDate().getTime()));
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
	
	public int delete(int num){
		int check=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		
		try{
			String sql="delete from guest where num = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
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
	
	public GuestDto select(int num){
		GuestDto guest=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from guest where num = ? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				guest=new GuestDto();
				guest.setNum(rs.getInt("num"));
				guest.setName(rs.getString("name"));
				guest.setPassword(rs.getString("password"));
				guest.setMessage(rs.getString("message"));
			}
		}catch(SQLException e){
			System.out.println("select error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return guest;
	}
	
	public int update(GuestDto guest){
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		int check=0;
		
		try{
			String sql="update guest set message = ? , password = ? where num = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, guest.getMessage());
			pstmt.setString(2,guest.getPassword());
			pstmt.setInt(3, guest.getNum());
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("update Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	} 
}
