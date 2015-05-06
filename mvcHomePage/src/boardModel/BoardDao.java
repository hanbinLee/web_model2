package boardModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

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
			pstmt.setString(1	, board.getWriter());
			pstmt.setString(2, board.getSubject());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getContent());
			pstmt.setString(5, board.getPassword());
			pstmt.setTimestamp(6, new Timestamp(board.getWriteDate().getTime()));
			pstmt.setInt(7, board.getReadCount());
			pstmt.setString(8,board.getIp());
			pstmt.setInt(9, board.getGroupNumber());
			pstmt.setInt(10,board.getSequenceNumber());
			pstmt.setInt(11,board.getSequenceLevel());
			pstmt.setString(12, "없음");
			pstmt.setString(13,"없음");
			pstmt.setInt(14, 0);
			
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
		int boardNumber=board.getBoardNumber();
		int groupNumber=board.getGroupNumber();
		int sequenceNumber=board.getSequenceNumber();
		int sequenceLevel=board.getSequenceLevel();
		
		//System.out.println("writeNumber method BoardNumber : " + boardNumber);
		//System.out.println("writeNumber method groupNumber : " + groupNumber);
		
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		// ROOT : 0 1 0 0 
		if(boardNumber==0){
			int max=0;
			try{
				conn=ConnectionProvider.getConnection();
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
				conn=ConnectionProvider.getConnection();
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
}
