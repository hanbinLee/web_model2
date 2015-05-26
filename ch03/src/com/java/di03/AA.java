package com.java.di03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

public class AA {
	private String name;
	private List<String> list;
	private HashMap<String , String> hMap;
	private Set<String> set;
	private Properties pro;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public void sethMap(HashMap<String, String> hMap) {
		this.hMap = hMap;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	public void setPro(Properties pro) {
		this.pro = pro;
	}
	
	public String getName(){
		return name;
	}
	
	public void getList(){
		for(int i = 0 ; i <list.size() ; i++){
			String str=list.get(i);
			System.out.println("list : "  + str);
		}
		System.out.println();
	}
	
	public void getMap(){
		Iterator<String> iter=hMap.keySet().iterator();
		
		while(iter.hasNext()){
			String str = hMap.get(iter.next());
			System.out.println("hMap : " + str);
		}
	}
	
	public void getSet(){
		Iterator<String> iter=set.iterator();
		
		while(iter.hasNext()){
			System.out.println("set : " + iter.next());
		}
	}
	
	public void getPro(){
		Iterator<Object> iter = pro.keySet().iterator();
		
		while(iter.hasNext()){
			String key = (String) iter.next();
			String value = pro.getProperty(key);
			System.out.println("property key : " + key + "\t value : " + value);
		}
	}
}
