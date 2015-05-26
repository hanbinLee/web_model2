package org.java.quiz01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("org/java/quiz01/appCTX.xml");
		
		Yonsan y = ctx.getBean("yonsan" , Yonsan.class);
		//Scanner scan = ctx.getBean("scan" , java.util.Scanner.class);
		y.init();
		
		ctx.close();
	}
}
