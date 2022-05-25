package com.hb03.onetoone;

public class Result {
	
	// 1 variables
	private String studentName;
	private String diaryName;
	private int studentGrade;
	
	
	// 2- Constructor

	
	public Result(String studentName, String diaryName, int studentGrade) {
		super();
		this.studentName = studentName;
		this.diaryName = diaryName;
		this.studentGrade = studentGrade;
	}
	
	
	public Result() {
		
	}


	
	
	// 3- Getter Setter
	
	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getDiaryName() {
		return diaryName;
	}


	public void setDiaryName(String diaryName) {
		this.diaryName = diaryName;
	}


	public int getStudentGrade() {
		return studentGrade;
	}


	public void setStudentGrade(int studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	
	

}
