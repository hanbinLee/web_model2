package org.java.quiz03_2;

public class Sungjuk {
	private String name;
	private int kor,eng,mat,tot;
	private float avg;
	
	public Sungjuk(String name , int kor , int eng , int mat){
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.tot = kor+eng+mat;
		this.avg = tot/3.0f;
	}
	
	public int getTot() {
		return tot;
	}

	public float getAvg() {
		return avg;
	}

	public String toString(){
		return "개인별총점평균 [name="+ name + ",kor=" + kor +",eng=" + eng +",mat=" + mat + ",tot=" + tot + ",avg=" + avg +"]";
	}
}
