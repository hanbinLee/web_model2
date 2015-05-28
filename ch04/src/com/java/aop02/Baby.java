package com.java.aop02;

public class Baby implements Person{ //join point : 핵심클래스

	@Override
	public void work() {   //point cut : 핵심 함수
		System.out.println("유치원등교");
	}
	
}
