package com.java.aop01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		/* AOP (Aspect Oriented Programming) :관점지향적 프로그램
		 * 
		 * 요구사항분석 --> 프로그램,뷰 시나리오 --> 클래스 다이어그램,DB모델링 --> 개발
		 * 
		 */
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/aop01/appCTX.xml");
		
		PersonProxy p = null;
		
		for(int i=1; i<4; i++){
			p = ctx.getBean("proxy" + i , PersonProxy.class);
			p.disp();
		}
		
		ctx.close();
	}
}
