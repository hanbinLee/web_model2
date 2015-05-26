package org.java.quiz02;

public class Sungjuk {
	private String name;
	private int kor,eng,mat;
	
	public String getName() {
		return name;
	}
	public int getTot() {
		return kor+eng+mat;
	}
	public float getAvg() {
		return (kor+eng+mat)/3.0f;
	}
	
	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMat() {
		return mat;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}

	public void disp(){
		System.out.println("이름 : " + this.getName());
		System.out.println("총점 : " + this.getTot());
		System.out.println("평균 : " + this.getAvg());
	}
}
