package com.java.di06;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di06/appCTX.xml");
		
		StudentInfo si = ctx.getBean("studentInfo" , StudentInfo.class);
		
		si.disp();
		
		ctx.close();
	}
}
