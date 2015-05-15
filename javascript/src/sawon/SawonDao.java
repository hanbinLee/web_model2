package sawon;

import java.util.List;

import myBatis.SqlManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SawonDao {
	private static SawonDao instance =new SawonDao();
	private static SqlSessionFactory sqlSessionFactory = SqlManager.getInstance();
	private SqlSession session;
	
	public static SawonDao getInstance(){
		return instance;
	}
	
	public List<Sawon> getList(String department){
		List<Sawon> list=null;
		
		try{
			session = sqlSessionFactory.openSession();
			list=session.selectList("sawonList" , department);
		}catch(Exception e){
			System.out.println("getList error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
}
