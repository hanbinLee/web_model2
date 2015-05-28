package com.java.di12;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		System.out.println("컨테이너 생성");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		System.out.println("컨테이너 설정");
		ctx.load("appCTX.xml");
		
		System.out.println("빈초기화");
		ctx.refresh();
		
		System.out.println("컨테이너 사용");
		Person p = ctx.getBean("personImpl" , Person.class);
		p.toDisp();
		System.out.println("컨테이너 종료");
		ctx.close();
	}
}
