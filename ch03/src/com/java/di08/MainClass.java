package com.java.di08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		String config1 = "com/java/di08/appCTX1.xml";
		String config2 = "com/java/di08/appCTX2.xml";
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(config1 , config2);
		
		AA aa = ctx.getBean("aa" , AA.class);
		BB bb = ctx.getBean("bb" , BB.class);
		
		System.out.println(aa.toString());
		System.out.println(bb.toString());
		
		ctx.close();
	}
}
