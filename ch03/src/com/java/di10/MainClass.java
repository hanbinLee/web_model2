package com.java.di10;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("com/java/di10/appCTX.xml");
		
		Pencil p4b = ctx.getBean("pencil4B" , Pencil.class);
		Pencil p6b = ctx.getBean("pencil6B" , Pencil.class);
		Pencil pe = ctx.getBean("pencilEraser" , Pencil.class); 
		
		ArrayList<Pencil> list=new ArrayList<Pencil>();
		
		list.add(p4b);
		list.add(p6b);
		list.add(pe);
		
		for(Pencil p : list){
			if(p instanceof Pencil4B){
				p.use();
			}else if(p instanceof Pencil6B){
				p.use();
			}else if(p instanceof PencilEraser){
				p.use();
			}
		}
		
		ctx.close();
	}
}
