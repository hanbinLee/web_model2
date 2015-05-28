package com.java.aop04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/aop04/appCTX.xml");
		
		try{
			Person teacher = ctx.getBean("teacher" , Person.class);
			teacher.work();
		}catch(Throwable e){
		
		}
		
		System.out.println();
		
		try{
		Person student = ctx.getBean("student" , Person.class);
		student.work();
		}catch(Throwable e){
			
		}
		
		ctx.close();
	}
}
