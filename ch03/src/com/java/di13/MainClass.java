package com.java.di13;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di13/appCTX.xml");
		
		Admin ai = ctx.getBean("adminImpl" , Admin.class);
		System.out.println(ai.toDisp());
		
		ctx.close();
	}
}
