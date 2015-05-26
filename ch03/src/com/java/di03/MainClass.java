package com.java.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di03/appCTX.xml");
		//AA a = new AA();
		AA a=ctx.getBean("aa", AA.class);
			
		System.out.println(a.getName());
		a.getList();
		a.getMap();
		a.getSet();
		a.getPro();
		
		ctx.close();
	}
}
