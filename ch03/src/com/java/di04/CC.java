package com.java.di04;

public class CC {
	private AA aa;
	private BB bb;
	
	public CC(){}
	
	public CC(AA aa){
		this.aa=aa;
	}

	public void setBb(BB bb) {
		this.bb = bb;
	}
	
	public void disp(){
		System.out.println(aa.toString() + "\n" + bb.toString());
	}
}
