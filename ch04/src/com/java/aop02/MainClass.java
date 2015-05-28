package com.java.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/aop02/appCTX.xml");
		
		Person baby = ctx.getBean("baby" , Person.class);
		baby.work();
		
		Person mom = ctx.getBean("mom" , Person.class);
		mom.work();
		
		Person dad = ctx.getBean("dad" , Person.class);
		dad.work();
		
		Dad d = (Dad)dad;
		d.aa();
		d.bb();
		
		
		ctx.close();
	}
}
