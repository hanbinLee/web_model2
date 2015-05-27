package org.java.quiz03_2;

import java.util.HashMap;
import java.util.Iterator;

public class SungjukBan {
	private HashMap<String , Sungjuk> hMap;
	private int tot;
	private int counter;
	
	public SungjukBan(HashMap<String , Sungjuk> hMap){
		this.hMap = hMap;
	}
	
	public void disp(){
		Iterator<String> iter = hMap.keySet().iterator();
		
		while(iter.hasNext()){
			String key = iter.next();
			Sungjuk sj = hMap.get(key);
			System.out.println(sj.toString());
			tot += sj.getTot();
			counter += 3;
		}
		System.out.println("반총점:" + tot + "반평균:" + (float)tot/counter);
	}
}
