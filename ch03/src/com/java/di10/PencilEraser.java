package com.java.di10;

public class PencilEraser	implements Pencil{

	@Override
	public void use() {
		System.out.println("4B 굵기로 쓰이고 , 지우개가 있다.");
	}
	
}
