package myBatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlManager {
	private static SqlSessionFactory sqlSessionFactory=null;
	
	public static SqlSessionFactory getInstance(){
		try {
			String resource = "myBatis/SqlConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (IOException e) {
			System.out.println("SqlMapper getInstance Error");
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
