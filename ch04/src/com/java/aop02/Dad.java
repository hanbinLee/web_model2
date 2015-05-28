package com.java.aop02;

public class Dad implements Person{

	@Override
	public void work() {
		System.out.println("그냥일");
	}
	
	public void aa(){
		System.out.println("aa");
	}
	
	public void bb(){
		System.out.println("bb");
	}
	
}
