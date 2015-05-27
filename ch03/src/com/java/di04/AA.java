package com.java.di04;

public class AA {
	private int x,y;
	
	public AA(){}
	
	public AA(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public String toString(){
		return "[AA x=" + x + "y=" + y + "]";
	}
}
