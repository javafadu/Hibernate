package com.hb04.onatomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book04 {


	@Id
	private int id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	private Student04 student;

	
	// 3- getter setter
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student04 getStudent() {
		return student;
	}

	public void setStudent(Student04 student) {
		this.student = student;
	}
	
	// toString()
	
	@Override
	public String toString() {
		return "Book04 [id=" + id + ", name=" + name + "]";
	}
	

//	@Override
//	public String toString() {
//		return "Book04 [id=" + id + ", name=" + name + ", student=" + student + "]";
//	}
//	
	
	
	
	
	
	
	
}
