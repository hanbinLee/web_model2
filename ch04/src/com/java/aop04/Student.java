package com.java.aop04;

public class Student implements Person{

	@Override
	public void work() {
		System.out.println("수업을 듣는다.");
		System.out.println(10/0);
	}
	
}
