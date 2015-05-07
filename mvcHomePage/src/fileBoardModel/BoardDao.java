package fileBoardModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

import dataBase.ConnectionProvider;
import dataBase.JdbcUtil;

public class BoardDao {
	private static BoardDao instance=new BoardDao();
	
	public static BoardDao getInstance(){
		return instance;
	}
	
	public int insert(BoardDto board){
		int check=0;
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		this.writeNumber(conn , board);
		try{
			conn=ConnectionProvider.getConnection();
			String sql="insert into board values(board_board_number_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			
			HashMap<String,String> dataMap=board.getDataMap();
			
		//	System.out.println("sequenceNumber : " + dataMap.get("sequenceNumber"));
			pstmt.setString(1	, dataMap.get("writer"));
			pstmt.setString(2, dataMap.get("subject"));
			pstmt.setString(3, dataMap.get("email"));
			pstmt.setString(4, dataMap.get("content"));
			pstmt.setString(5, dataMap.get("password"));
			pstmt.setTimestamp(6, new Timestamp(board.getWriteDate().getTime()));
			pstmt.setInt(7, board.getReadCount());
			pstmt.setString(8,board.getIp());
			pstmt.setInt(9,board.getGroupNumber());
			pstmt.setInt(10,board.getSequenceNumber());
			pstmt.setInt(11,board.getSequenceLevel());
			pstmt.setString(12, board.getFileName());
			pstmt.setString(13,board.getPath());
			pstmt.setLong(14, board.getSize());
			
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("insert Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}
	
	public void writeNumber(Connection conn , BoardDto board){
		HashMap<String,String> dataMap=board.getDataMap();
		
		int boardNumber=Integer.parseInt(dataMap.get("boardNumber"));
		int groupNumber=Integer.parseInt(dataMap.get("groupNumber"));
		int sequenceNumber=Integer.parseInt(dataMap.get("sequenceNumber"));
		int sequenceLevel=Integer.parseInt(dataMap.get("sequenceLevel"));
		//System.out.println("writeNumber method BoardNumber : " + boardNumber);
		//System.out.println("writeNumber method groupNumber : " + groupNumber);
	
		conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		// ROOT : 0 1 0 0 
		if(boardNumber==0){
			int max=0;
			try{
				String sql="select max(group_number) as mgn from board";
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					max=rs.getInt("mgn")+1;
				}else{
					max=1;
				}
			}catch(SQLException e){
				System.out.println("writeNumber error");
				e.printStackTrace();
			}finally{
				JdbcUtil.close(rs);
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
			groupNumber=max;
			sequenceNumber=0;
			sequenceLevel=0;
			
		// 답글 : 부모글 번호 가져옴 	
		}else{	
			try{
				String sql="update board set sequence_number=sequence_number + 1 where group_number=? and sequence_number > ? ";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, groupNumber);
				pstmt.setInt(2, sequenceNumber);
				pstmt.executeUpdate();
				
				sequenceNumber+=1;
				sequenceLevel+=1;
			}catch(SQLException e){
				System.out.println("writeNumber Error");
				e.printStackTrace();
			}finally{
				JdbcUtil.close(pstmt);
				JdbcUtil.close(conn);
			}
		}
		
		board.setSequenceLevel(sequenceLevel);
		board.setSequenceNumber(sequenceNumber);
		board.setGroupNumber(groupNumber);
	}
	
	public int getCount(){
		int count=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			String sql="select count(*) cnt from board";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) count=rs.getInt("cnt");
			//System.out.println("db count : " + count);
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
	
	public ArrayList<BoardDto> getBoardList(int startRow,int endRow){
		ArrayList<BoardDto> list = null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from (select rownum as rnum,temp.* from(select * from board order by group_number desc,sequence_number asc) temp) where rnum >= ? and rnum <=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs=pstmt.executeQuery();
			
			list=new ArrayList<BoardDto>();
			
			while(rs.next()){
				BoardDto board=new BoardDto();
				
				board.setBoardNumber(rs.getInt("board_number"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setPassword(rs.getString("password"));
				
				board.setWriteDate(rs.getTimestamp("write_date"));
				board.setReadCount(rs.getInt("read_count"));
				board.setGroupNumber(rs.getInt("group_number"));
				board.setSequenceNumber(rs.getInt("sequence_number"));
				board.setSequenceLevel(rs.getInt("sequence_level"));
				board.setIp(rs.getString("ip"));
				
				list.add(board);
			}
		}catch(SQLException e){
			System.out.println("getBoardList Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return list;
	}
	
	public BoardDto read(int boardNumber){
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		BoardDto board=null;
		
		try{
			conn.setAutoCommit(false);
			String sql="update board set read_count=read_count+1 where board_Number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			pstmt.executeUpdate();
			//System.out.println("check : " + check);
			
			if(pstmt!=null) pstmt.close();
			
			sql="select * from board where board_Number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				board=new BoardDto();
				
				board.setBoardNumber(rs.getInt("board_number"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setPassword(rs.getString("password"));
				
				board.setWriteDate(rs.getTimestamp("write_date"));
				board.setReadCount(rs.getInt("read_count"));
				board.setGroupNumber(rs.getInt("group_number"));
				board.setSequenceNumber(rs.getInt("sequence_number"));
				board.setSequenceLevel(rs.getInt("sequence_level"));
				board.setIp(rs.getString("ip"));
				
				board.setFileName(rs.getString("file_name"));
				board.setPath(rs.getString("path"));
				board.setSize(rs.getLong("file_size"));
			}
			
			conn.commit();
		}catch(SQLException e){
			System.out.println("read Error");
			e.printStackTrace();
			JdbcUtil.rollBack(conn);
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return board;
	}
	
	public BoardDto getInfo(int boardNumber){
		BoardDto board=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from board where board_number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				board=new BoardDto();
				
				board.setBoardNumber(rs.getInt("board_number"));
				board.setWriter(rs.getString("writer"));
				board.setSubject(rs.getString("subject"));
				board.setEmail(rs.getString("email"));
				board.setContent(rs.getString("content"));
				board.setPassword(rs.getString("password"));
				
				board.setWriteDate(rs.getTimestamp("write_date"));
				board.setReadCount(rs.getInt("read_count"));
				board.setGroupNumber(rs.getInt("group_number"));
				board.setSequenceNumber(rs.getInt("sequence_number"));
				board.setSequenceLevel(rs.getInt("sequence_level"));
				board.setIp(rs.getString("ip"));
			}
		}catch(SQLException e){
			System.out.println("getInfo Error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return board;
	}
	
	public int delete(int boardNumber,String password){
		int check=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		
		try{
			String sql="delete from board where board_Number=? and password=? ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			pstmt.setString(2, password);
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("비밀번호 오류");
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return check;
	}
	
	public int update(BoardDto board){
		int check=0;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		
		try{
			String sql="update board set subject=? , content=? where board_number=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, board.getSubject());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getBoardNumber());
			pstmt.setString(4, board.getPassword());
			check=pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("update error");
			e.printStackTrace();
		}finally{
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		
		return check;
	}
	
	public BoardDto fileRead(int boardNumber){
		BoardDto board=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String sql="select * from board where board_Number=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			rs=pstmt.executeQuery();
			
			if(rs.next()){
				board=new BoardDto();
				
				board.setFileName(rs.getString("file_name"));
				board.setPath(rs.getString("path"));
				board.setSize(rs.getLong("file_size"));
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("fileRead Error");
		}finally{
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(conn);
		}
		return board;
	}
}
