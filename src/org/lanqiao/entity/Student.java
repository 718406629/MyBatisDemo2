package org.lanqiao.entity;
//学生类 包含：1、学生信息  2、学生证信息
public class Student {
	
	private int stuNo ;
	private String stuName ;
	private int stuAge ;
	private String graName ;
	private boolean stuSex;
	//学生证信息
	private StudentCard card;
	public StudentCard getCard() {
		return card;
	}


	public void setCard(StudentCard card) {
		this.card = card;
	}


	public boolean isStuSex() {
		return stuSex;
	}


	public void setStuSex(boolean stuSex) {
		this.stuSex = stuSex;
	}


	public Student() {
	}
	
	
	public Student(int stuNo, String stuName, int stuAge, String graName) {
		this.stuNo = stuNo;
		this.stuName = stuName;
		this.stuAge = stuAge;
		this.graName = graName;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuAge() {
		return stuAge;
	}
	public void setStuAge(int stuAge) {
		this.stuAge = stuAge;
	}
	public String getGraName() {
		return graName;
	}
	public void setGraName(String graName) {
		this.graName = graName;
	} 
	
	@Override
	public String toString() {
		return this.stuNo+"-"+this.stuName+"-"+this.stuAge+"-"+this.graName+"-性别："+this.stuSex
				+"-"+this.card.getcardId()+"-"+this.card.getcardInfo();
	}
	
}
