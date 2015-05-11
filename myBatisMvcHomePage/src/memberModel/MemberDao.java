package memberModel;

import java.util.HashMap;
import java.util.List;

import myBatis.SqlManager;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class MemberDao {
	private static SqlSessionFactory sessionFactory=SqlManager.getInstance();
	private SqlSession session;
	private static MemberDao instance=new MemberDao();
	
	public static MemberDao getInstance(){
		return instance;
	}
	
	public int insert(MemberDto member){
		int check=0;
	
		try{
			session=sessionFactory.openSession();
			check=session.insert("memberInsert",member);
			session.commit();
		}catch(Exception e){
			System.out.println("Insert Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		
		return check;
	}
	
	public int checkId(String id){
		int check=0;
		try{
			session=sessionFactory.openSession();
			String checkId = session.selectOne("memberIdCheck" , id);
			
			if(checkId != null) check=1;
		}catch(Exception e){
			System.out.println("checkId Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return check;
	}
	
	public List<ZipcodeDto> searchZipcode(String city){
		List<ZipcodeDto> list=null;
		
		try{
			session=sessionFactory.openSession();
			list=session.selectList("memberSearchZipcode" , city);
		}catch(Exception e){
			System.out.println("searchZipcode Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return list;
	}
	
	public String login(String id,String password){
		String memberLevel=null;
		HashMap<String,String> hashMap=new HashMap<String,String>();
		
		try{
			hashMap.put("id" , id);
			hashMap.put("password" , password);
			
			session=sessionFactory.openSession();
			memberLevel=session.selectOne("memberLogin" , hashMap);
		}catch(Exception e){
			System.out.println("login Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return memberLevel;
	}
	
	public int delete(String id,String password){
		int check=0;
		HashMap<String ,String> hashMap = new HashMap<String,String>();
		try{
			hashMap.put("id" , id);
			hashMap.put("password" , password);
			session=sessionFactory.openSession();
			session.delete("memberDelete" , hashMap);
			session.commit();
		}catch(Exception e){
			System.out.println("delete Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		return check;
	}
	
	public MemberDto findMemberInfo(String id){
		MemberDto member = null;
		
		try{
			session=sessionFactory.openSession();
			member = session.selectOne("memberFindId",id);
		}catch(Exception e){
			System.out.println("findMemberInfo Error");
			e.printStackTrace();
		}finally{
			session.close();
		}
		System.out.println("fMI test : " + member.getEmail());
		return member;
	}
	
	public int update(MemberDto member){
		int check=0;
		//System.out.println(member.getId());
		try{
			session=sessionFactory.openSession();
			check = session.update("memberUpdate" , member);
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
