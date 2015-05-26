package org.java.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
//		AA a = new AA();
//		a.disp();
//		
//		BB b = new BB();
//		b.output();
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		
		AA a = ctx.getBean("aa" , AA.class);
		BB b = ctx.getBean("bb" , BB.class);
		
		a.disp();
		b.output();
		
		ctx.close();
	}
}
