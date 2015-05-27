package org.java.quiz03;

import java.util.ArrayList;

public class SungjukBan {
	private ArrayList<Sungjuk> list;
	
	public SungjukBan(ArrayList<Sungjuk> list){
		this.list = list;
	}
	
	public void disp(){
		if(list!=null){
			for(Sungjuk sj : list){
				System.out.println(sj.toString());
			}
			System.out.println("반총점 : " + Sungjuk.getAllT() + "\t 반평균 : " + (float)Sungjuk.getAllA() );
		}
	}
}
