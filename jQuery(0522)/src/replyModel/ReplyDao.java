package replyModel;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import myBatis.SqlManager;

public class ReplyDao {
	private static ReplyDao instance=new ReplyDao();
	private static SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
	private static SqlSession session;
	
	public static ReplyDao getInstance(){
		return instance;
	}
	
	public int insert(ReplyDto reply){
		int check=0;
		try{
			session=sqlSessionFactory.openSession();
			check=session.insert("replyWrite",reply);
			session.commit();
		}catch(Exception e){
			System.out.println("ReplyDao insert Error");
			e.printStackTrace();
		}finally{
			session.close();
		}		
		
		return check;
	}
	
	public int getBunho(){
		int bunho=0;
		
		try{
			session=sqlSessionFactory.openSession();
			bunho=session.selectOne("replyGetBunho");
		}catch(Exception e){
			System.out.println("ReplyDao getBunho Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return bunho;
	}
	
	public List<ReplyDto> getList(int boardNumber){
		List<ReplyDto> list=null;
		try{
			session=sqlSessionFactory.openSession();
			list=session.selectList("replyList",boardNumber);
			
		}catch(Exception e){
			System.out.println("ReplyDao getList Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	public int delete(int bunho){
		int check=0;
		try{
			session=sqlSessionFactory.openSession();
			check=session.delete("replyDelete",bunho);
			session.commit();
			
		}catch(Exception e){
			System.out.println("ReplyDao delete Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return check;
	}
	
	public ReplyDto select(int bunho){
		ReplyDto reply=null;
		
		try{
			session=sqlSessionFactory.openSession();
			reply=session.selectOne("replySelect", bunho);
			
		}catch(Exception e){
			System.out.println("LineReply Select Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return reply;
	}
	
	public int update(int bunho, String lineReply){
		int value=0;
		
		try{
			HashMap<String, Object> hMap=new HashMap<String, Object>();
			hMap.put("bunho", bunho);
			hMap.put("lineReply", lineReply);
			
			session=sqlSessionFactory.openSession();
			value=session.update("replyUpdate", hMap);
			session.commit();
		}catch(Exception e){
			System.out.println("LineReply Update Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return value;
	}
	
}
