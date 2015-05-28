package com.java.di11;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		/* 스프링 컨테이너 생명주기
		 * 컨테이너 생성 -- 컨테이너 설정 -- 빈초기화 -- 컨테이너 사용
		 * 컨테이너 종료 -- 빈소멸
		 */
		
		System.out.println("컨테이너 생성");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		System.out.println("컨테이너 설정");
		ctx.load("appCTX.xml");
		ctx.refresh(); //빈 초기화 과정
		
		System.out.println("컨테이너 사용");
		AA a = ctx.getBean("aaImpl" , AAImpl.class);
		a.disp();
		
		System.out.println("컨테이너 소멸후 빈도 소멸");
		ctx.close();
	}
}
