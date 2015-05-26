package com.java.di02;

public class AA {
	private int x,y,count;

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void setData(int x , int y){
		this.x=x;
		this.y=y;
	}
	
	public void disp(){
		System.out.println("호출갯수: " + ++count);
		System.out.println("x : "  + x);
		System.out.println("y : " + y);
		System.out.println();
	}
}
