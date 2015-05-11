package fileBoardModel;

import java.util.HashMap;
import java.util.List;

import myBatis.SqlManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class BoardDao {
	private static BoardDao instance=new BoardDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	
	public static BoardDao getInstance(){
		return instance;
	}
	
	public int insert(BoardDto board){
		int check=0;
		
		this.writeNumber(board);
		
		try{
			HashMap<String,String> dataMap=board.getDataMap();
			board.setWriter(dataMap.get("writer"));
			board.setSubject(dataMap.get("subject"));
			board.setEmail(dataMap.get("email"));
			board.setContent(dataMap.get("content"));
			board.setPassword(dataMap.get("password"));
			
			session=sqlSessionFactory.openSession();
			check = session.update("fileBoardInsert" , board);
			session.commit();	
		}catch(Exception e){
			System.out.println("insert Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return check;
	}
	
	public void writeNumber(BoardDto board){
		HashMap<String,String> dataMap=board.getDataMap();
		
		int boardNumber=Integer.parseInt(dataMap.get("boardNumber"));
		int groupNumber=Integer.parseInt(dataMap.get("groupNumber"));
		int sequenceNumber=Integer.parseInt(dataMap.get("sequenceNumber"));
		int sequenceLevel=Integer.parseInt(dataMap.get("sequenceLevel"));
	
		// ROOT : 0 1 0 0 
		if(boardNumber==0){
			int max=0;
			try{
				session=sqlSessionFactory.openSession();
				max = session.selectOne("fileBoardWriteNumber");
				
				if(max != 1){
					max+=1;
				}else{
					max=1;
				}
			}catch(Exception e){
				System.out.println("writeNumber error");
				e.printStackTrace();
			}finally{
				session.close();
			}
			groupNumber=max;
			sequenceNumber=0;
			sequenceLevel=0;
			
		// 답글 : 부모글 번호 가져옴 	
		}else{	
			try{
				HashMap<String , Integer> hmap=new HashMap<String , Integer> ();
				hmap.put("groupNumber", groupNumber);
				hmap.put("sequenceNumber" , sequenceNumber);
					
				session=sqlSessionFactory.openSession();
				session.update("writeNumberUpdate" , hmap);
			
				sequenceNumber+=1;
				sequenceLevel+=1;
			}catch(Exception e){
				System.out.println("writeNumber Error");
				e.printStackTrace();
			}finally{
				session.close();
			}
		}
		
		board.setSequenceLevel(sequenceLevel);
		board.setSequenceNumber(sequenceNumber);
		board.setGroupNumber(groupNumber);
	}
	
	public int getCount(){
		int count=0;
	
		try{
			session=sqlSessionFactory.openSession();
			count=session.selectOne("fileBoardCount");
		}catch(Exception e){
			System.out.println("getCount Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
	}
	
	public List<BoardDto> getBoardList(int startRow,int endRow){
		List<BoardDto> list = null;
		HashMap<String , Integer> hmap = new HashMap<String , Integer>();
		hmap.put("startRow" , startRow);
		hmap.put("endRow" , endRow);
		
		try{
			session = sqlSessionFactory.openSession();
			list=session.selectList("fileBoardGetBoardList",hmap);	
		}catch(Exception e){
			System.out.println("getBoardList Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public BoardDto read(int boardNumber){
		BoardDto board=null;
		
		try{
			session = sqlSessionFactory.openSession();
			session.update("fileBoardReadCount" , boardNumber);
			board = session.selectOne("fileBoardRead" , boardNumber);
			session.commit();
		}catch(Exception e){
			System.out.println("read Error");
			e.printStackTrace();
			session.rollback();
		}finally{
			session.close();
		}
		
		return board;
	}
	
	public BoardDto getInfo(int boardNumber){
		BoardDto board=null;
		
		try{
			session = sqlSessionFactory.openSession();
			board = session.selectOne("fileBoardRead" , boardNumber);
		}catch(Exception e){
			System.out.println("getInfo Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return board;
	}
	
	public int delete(int boardNumber,String password){
		int check=0;
		HashMap<String , Object> hmap = new HashMap<String , Object> ();
		hmap.put("boardNumber" , boardNumber);
		hmap.put("password" , password);
		try{
			session = sqlSessionFactory.openSession();
			check = session.delete("fileBoardDelete",hmap);
			session.commit();
		}catch(Exception e){
			System.out.println("비밀번호 오류");
		}finally{
			session.close();
		}
		return check;
	}
	
	public int update(BoardDto board){
		int check=0;
		
		try{
			session = sqlSessionFactory.openSession();
			check = session.update("fileBoardUpdate" , board);
			session.commit();
		}catch(Exception e){
			System.out.println("update error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return check;
	}
	
	public BoardDto fileRead(int boardNumber){
		BoardDto board=null;

		try{
			session = sqlSessionFactory.openSession();
			board = session.selectOne("fileBoardRead", boardNumber);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("fileRead Error");
		}finally{
			session.close();
		}
		return board;
	}
}
