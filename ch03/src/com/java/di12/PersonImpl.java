package com.java.di12;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonImpl implements Person , InitializingBean , DisposableBean{
	private String name;
	private int age;
	
	public PersonImpl() {
		// TODO Auto-generated constructor stub
	}
		
	public PersonImpl(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String toDisp() {
		return "PersonImpl[name : "+ name + "\t age : " + age + "]";
	}

	@Override //refresh() 호출
	public void afterPropertiesSet() throws Exception {
		System.out.println("빈초기화 과정에서 호출");
	}
 
	@Override //close() 호출
	public void destroy() throws Exception {
		System.out.println("빈 소멸과정에서 호출");
	}
}
