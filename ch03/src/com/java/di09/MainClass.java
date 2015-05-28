package com.java.di09;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		/* 1.DI : 객체사이의 의존관계를 객체 자신이 아닌 외부의 조립기가 수행
		 *      1-1) bean : 스프링 프레임워크가 
		 *      				IOC(Inversion of Control)방식으로관리하는 객체
		 *      1-2) bean factory : bean의 생성 , 제어 기능
		 *      1-3) ApplicationContext : bean factory 확장 
		 */    
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di09/appCTX.xml");
		
		AA b = ctx.getBean("bb" , AA.class);
		b.disp();
		
		ctx.close();
	}
}
