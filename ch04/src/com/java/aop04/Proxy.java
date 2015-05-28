package com.java.aop04;

import org.aspectj.lang.JoinPoint;

public class Proxy {
	public void classRoom(JoinPoint jp){
		System.out.println("클래스 이름 : " + jp.getTarget().getClass().getName());
		System.out.println("함수 이름 : " + jp.getSignature().getName());
		System.out.println("강의장에 들어온다");
	}
	
	public void goHome(){
		System.out.println("집에 간다.");
	}
	
	public void lunch(){
		System.out.println("점심 먹는다");
	}
	
	public void beExpelied(JoinPoint jp , Throwable ex){
//		System.out.println(ex);
		System.out.println("쫓겨난다.");
	}
}
