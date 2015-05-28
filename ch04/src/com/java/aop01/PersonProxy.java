package com.java.aop01;

public class PersonProxy {
	private Person person;

	public PersonProxy(Person person) {
		super();
		this.person = person;
	}
	
	public void disp(){
		this.awake();
		person.work();
	}
	
	public void awake(){
		if(person instanceof Mom){
			System.out.println("엄마");
		}else if(person instanceof Dad){
			System.out.println("아빠");
		}else if(person instanceof Baby){
			System.out.println("아기");
		}
	}
}
