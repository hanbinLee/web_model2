package com.java.di;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * DI : 객체간 의존성을 낮춰주기위해 외부 XML 파일을 사용하여 의존성을 낮춰주는 방법
 */

public class MainClass {
	public static void main(String[] args) {
//		Su s = new Su();
//		s.disp();
		
		//ROOT에 위치한 XML 파일 읽어온다.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("appCTX.xml");
		
		Su su = ctx.getBean("su" , Su.class);
		su.disp();
		
		ctx.close();
	}
}
