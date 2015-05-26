package com.java.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di02/appCTX.xml");
		
		AA aa = ctx.getBean("aa" , AA.class);
		aa.disp();
		
		aa.setData(aa.getX(),aa.getY());
		aa.disp();
		
		ctx.close();
	}
}
