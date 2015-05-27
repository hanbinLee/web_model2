package com.java.di05;

public class Student {
	private String name,age,gradeName,className;
	
	public Student(){}

	public Student(String name, String age, String gradeName, String className) {
		super();
		this.name = name;
		this.age = age;
		this.gradeName = gradeName;
		this.className = className;
	}
	
	public String toString(){
		return "Student[name" + name + ",age=" + age + 
				",gradeName=" + gradeName + ",className=" + className + "]";
	}
}
