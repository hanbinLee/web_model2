package com.java.aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/aop03/appCTX.xml");
		
		Person student = ctx.getBean("student" , Person.class);
		student.work();
		
		Person teacher = ctx.getBean("teacher" , Person.class);
		teacher.work();
		
		ctx.close();
	}
}
