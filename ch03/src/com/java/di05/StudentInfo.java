package com.java.di05;

public class StudentInfo {
	private Student student;
	private int x;
	
	public StudentInfo() {}

	public StudentInfo(Student student, int x) {
		super();
		this.student = student;
		this.x = x;
	}
	
	public void disp(){
		if(student !=null){
			System.out.println(student.toString() + "\t" + x);
		}else{
			System.out.println("student not exist");
		}
	}
}
