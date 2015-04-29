package memberModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import dataBase.ConnectionProvider;
import dataBase.JdbcUtil;

public class MemberDao {
	private static MemberDao instance=new MemberDao();
	
	public static MemberDao getInstance(){
		return instance;
	}
	
	public int insert(MemberDto member){
		int check=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		try{
			String sql="insert into member values (member_num_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			conn=ConnectionProvider.getConnection();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getJumin1());
			pstmt.setString(5, member.getJumin2());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getZipcode());
			pstmt.setString(8, member.getAddress());
			pstmt.setString(9, member.getJob());
			pstmt.setString(10, member.getMailing());
			pstmt.setString(11, member.getInterest());
			pstmt.setString(12, member.getMemberLevel());
			pstmt.setTimestamp(13, new Timestamp(member.getRegisterDate().getTime()));
			
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("Insert Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}
	
	public int checkId(String id){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int check=0;
		try{
			String sql="select id from member where id=?";
			conn=ConnectionProvider.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) check=1;
		}catch(SQLException e){
			System.out.println("checkId Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}
	
	public ArrayList<ZipcodeDto> searchZipcode(String city){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<ZipcodeDto> list=null;
		try{
			String sql="select * from zipcode where dong=?";
			conn=ConnectionProvider.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, city);
			rs=pstmt.executeQuery();
			
			list=new ArrayList<ZipcodeDto>();
			
			while(rs.next()){
				ZipcodeDto zipcode=new ZipcodeDto();
				zipcode.setZipcode(rs.getString("zipcode"));
				zipcode.setSido(rs.getString("sido"));
				zipcode.setGugun(rs.getString("gugun"));
				zipcode.setDong(rs.getString("dong"));
				zipcode.setRi(rs.getString("ri"));
				zipcode.setBunji(rs.getString("bunji"));
				list.add(zipcode);
			}
		}catch(SQLException e){
			System.out.println("searchZipcode Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return list;
	}
}
