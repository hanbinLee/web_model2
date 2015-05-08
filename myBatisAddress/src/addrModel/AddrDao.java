package addrModel;

import myBatis.SqlManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class AddrDao {
	private static AddrDao instance=new AddrDao();
	private static SqlSessionFactory sqlSessionFactory=SqlManager.getInstance();
	private SqlSession session;
	
	public static AddrDao getInstance(){
		return instance;
	}
	
	public int insert(AddrDto addr){
		int check=0;
		
		try{
			session=sqlSessionFactory.openSession();
			check=session.insert("insertUser",addr);
			session.commit(); //myBatis는 autoCommit이 안됨
		}catch(Exception e){
			System.out.println("insert Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return check;
	}
	
	public AddrDto select(String name){
		AddrDto addr=null;
		try{
			session=sqlSessionFactory.openSession();
			addr=session.selectOne("findUser",name);
		}catch(Exception e){
			System.out.println("select error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return addr;
	}
	
	public int delete(String name){
		int check=0;
		
		try{
			session=sqlSessionFactory.openSession();
			check=session.delete("deleteUser",name);
			session.commit();
		}catch(Exception e){
			System.out.println("delete Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return check;
	}
	
	public int update(AddrDto addr){
		int check=0;
		
		try{
			session=sqlSessionFactory.openSession();
			check=session.update("updateUser", addr);
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
