package com.hb02.embeddable;

import javax.persistence.Embeddable;


// @Embeddable annotaion ile bu annotation in sahip oldugu instance variable lari
// ek bir tablo olusturmadan baska bir tabloya koymaya yarar


@Embeddable 
// Student02 class in icine direk alip annotation yapmis gibi olabiliyoruz.
public class Course02 {
	
	
	// 1. variables
	private String elective;
	private String mandotary;
	
	
	// 2. getter setter
	
	public String getElective() {
		return elective;
	}
	public void setElective(String elective) {
		this.elective = elective;
	}
	public String getMandotary() {
		return mandotary;
	}
	public void setMandotary(String mandotary) {
		this.mandotary = mandotary;
	}
	
	
	  @Override
	    public String toString() {
	        return "Course02 [elective=" + elective + ", mandatory=" + mandotary + "]";
	    }
	
	
	
	
	
	

}
