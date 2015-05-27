package com.java.di04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		//컴포넌트 : html , jsp , servlet 하나하나의 요소
		//컨테이너 : 컴포넌트를 담고 있다.
		
		//DI 컨테이너 : bean을 담고 있다.
		
		//DI 생성 : bean 생성 -- bean 실행 -- bean 소멸
		
		AbstractApplicationContext ctx = 
				new ClassPathXmlApplicationContext("com/java/di04/appCTX.xml");
		CC c = ctx.getBean("cc" , CC.class);
		c.disp();
		
		ctx.close();
	}
}
