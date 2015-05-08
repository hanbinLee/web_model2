package myBatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlManager {
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getInstance(){
		String resource="myBatis/SqlConfig.xml";
		
		try{
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		}catch(IOException e){
			System.out.println("SqlManager getInstance Error");
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
