package org.java.quiz03_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx 
				= new ClassPathXmlApplicationContext("org/java/quiz03_2/appCTX.xml");
		
		SungjukBan sjb = ctx.getBean("sjb",SungjukBan.class);
		sjb.disp();
		
		ctx.close();
	}
}
