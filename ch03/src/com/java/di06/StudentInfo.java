package com.java.di06;

import java.util.ArrayList;

public class StudentInfo {
	private ArrayList<Student> studentList;

	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfo(ArrayList<Student> studentList) {
		super();
		this.studentList = studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public void disp(){
		if(studentList !=null){
			for(Student student : studentList){
				System.out.println(student.toString() + "\n");
			}
		}else{
			System.out.println("studentList not exist");
		}
	}
}
