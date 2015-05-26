package com.java.di01;

public class AA {
	private int a,b;
	
	public AA(){}

	public AA(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	public void disp(){
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	}
}
