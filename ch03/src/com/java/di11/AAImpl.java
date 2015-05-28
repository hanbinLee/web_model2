package com.java.di11;

public class AAImpl implements AA{
	private int su,value;
	
	public AAImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public AAImpl(int su, int value) {
		super();
		this.su = su;
		this.value = value;
	}
	
	public void setSu(int su) {
		this.su = su;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public void disp() {
		System.out.println("AAImpl su=" + su + "\t value=" + value);
	}
	
}
