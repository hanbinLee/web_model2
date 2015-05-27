package org.java.quiz03;

public class Sungjuk {
	private String name;
	private int kor,eng,mat,tot;
	private float avg;
	private static int allTot,counter; //반총점 , 반총인원
	private static float allAvg; //반평균
	
	public Sungjuk(String name , int kor , int eng , int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = tot/3.0f;
		allTot += tot;
		counter ++;
		allAvg = (float)allTot/(counter*3);
	}
	
	public int getTot() {
		return tot;
	}

	public float getAvg() {
		return avg;
	}
	
	public static int getAllT() {
		return allTot;
	}

	public static float getAllA() {
		return allAvg;
	}

	public String toString(){
		return "개인별총점평균 [name="+ name + ",kor=" + kor +",eng=" + eng +",mat=" + mat + ",tot=" + tot + ",avg=" + avg +"]";
	}
}
