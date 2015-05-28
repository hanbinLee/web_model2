package com.java.aop02;

public class Mom implements Person{  //join point

	@Override
	public void work() {  //point cut
		System.out.println("집안일");
	}
	
}
