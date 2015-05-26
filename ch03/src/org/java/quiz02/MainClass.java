package org.java.quiz02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("org/java/quiz02/appCTX.xml");
		
		Sungjuk sj = ctx.getBean("sungjuk" , Sungjuk.class);
		sj.disp();
		
		ctx.close();
	}
}
