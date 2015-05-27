package com.java.di07;

import java.util.HashMap;
import java.util.Iterator;

public class StudentInfo {
	private HashMap<String,Student> studentList;

	public StudentInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentInfo(HashMap<String , Student> studentList) {
		super();
		this.studentList = studentList;
	}

	public void setStudentList(HashMap<String , Student> studentList) {
		this.studentList = studentList;
	}
	
	public void disp(){
		if(studentList !=null){
			Iterator<String> iterator = studentList.keySet().iterator();
			
			while(iterator.hasNext()){
				String key = iterator.next();
				Student student = studentList.get(key);
				System.out.println(student.toString());
			}
		}else{
			System.out.println("studentList not exist");
		}
	}
}
