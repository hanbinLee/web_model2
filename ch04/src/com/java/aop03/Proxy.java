package com.java.aop03;

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
}
