package com.java.aop02;

import org.aspectj.lang.JoinPoint;

public class PersonProxy {     //aspect : 공통 클래스
	
	public void awake(JoinPoint joinPoint){        //advice : 공통 함수
		System.out.println(joinPoint.getTarget().getClass());
		System.out.println("일어난다.");
	}
	
}
