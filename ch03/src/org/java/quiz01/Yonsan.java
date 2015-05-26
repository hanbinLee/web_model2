package org.java.quiz01;

import java.util.Scanner;


public class Yonsan {
	private int firstNum,secondNum;
	private String buho;
	private Scanner scan;
	
	public Yonsan(){
		scan = new Scanner(System.in);
	}
	
	public void init(){
		System.out.print("첫번째 수 입력 : ");
		setFirstNum(scan.nextInt());
		System.out.print("부호 입력 :");
		setBuho(scan.next());
		System.out.print("두번째 수 입력 :");
		setSecondNum(scan.nextInt());
		
		checkBuho();
		scan.close();
	}
	
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	
	public void setSecondNum(int secondNum) {
		this.secondNum = secondNum;
	}
	
	public void setBuho(String buho) {
		this.buho = buho;
	}
	
	public void checkBuho(){
		if(buho.equals("+")){
			System.out.println(firstNum + buho + secondNum + "=" + (firstNum+secondNum));
		}else if(buho.equals("-")){
			System.out.println(firstNum + buho + secondNum + "=" + (firstNum-secondNum));
		}else if(buho.equals("*")){
			System.out.println(firstNum + buho + secondNum + "=" + (firstNum*secondNum));
		}else if(buho.equals("/")){
			System.out.println(firstNum + buho + secondNum + "=" + ((float)firstNum/secondNum));
		}else{
			System.out.println("부호 에러");
		}		
	}
}
