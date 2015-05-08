package guestModel;

import java.util.HashMap;
import java.util.List;

import myBatis.SqlManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class GuestDao {
	private static GuestDao instance=new GuestDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static GuestDao getInstance(){
		return instance;
	}
	
	public int getCount(){
		int count=0;
		
		try{
			session=sqlSessionFactory.openSession();
			count=session.selectOne("guestGetCount");
		}catch(Exception e){
			System.out.println("getCount Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return count;
	}
	
	public List<GuestDto> getGuestList(int startPage,int endPage){
		List<GuestDto> list=null;
		HashMap<String,Integer> pageMap=new HashMap<String,Integer>();
		pageMap.put("startPage", startPage);
		pageMap.put("endPage", endPage);
		
		try{
			session = sqlSessionFactory.openSession();
			list=session.selectList("guestGetGuestList",pageMap);
		}catch(Exception e){
			System.out.println("getGuestList Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return list;
	}
	
	public int insert(GuestDto guest){
		int check=0;
		
		try{
			session=sqlSessionFactory.openSession();
			check=session.insert("guestInsert",guest);
			session.commit();
		}catch(Exception e){
			System.out.println("insert error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return check;
	}
	
	public int delete(int num){
		int check=0;
	
		try{
			session=sqlSessionFactory.openSession();
			check=session.delete("guestDelete",num);
			session.commit();
		}catch(Exception e){
			System.out.println("delete Error");
			e.printStackTrace();
		}finally{
			session.close();
		}	
		return check;
	}
	
	public GuestDto select(int num){
		GuestDto guest=null;
	
		try{
			session=sqlSessionFactory.openSession();
			guest=session.selectOne("guestSelect", num);
		}catch(Exception e){
			System.out.println("select error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return guest;
	}
	
	public int update(GuestDto guest){
		int check=0;
		
		try{
			session=sqlSessionFactory.openSession();
			check=session.update("guestUpdate", guest);
			session.commit();
		}catch(Exception e){
			System.out.println("update Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return check;
	} 
}
