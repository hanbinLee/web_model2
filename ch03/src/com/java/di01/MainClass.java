package com.java.di01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di01/appCTX.xml");
		
		AA a = ctx.getBean("aa" , AA.class);
		a.disp();
		System.out.println();
		
		AA b = ctx.getBean("bb" , AA.class);
		b.disp();
		
		ctx.close();
	}
}
