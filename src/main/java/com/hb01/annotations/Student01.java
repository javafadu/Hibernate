package com.hb01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// DB de bir tablo karsiligi oldugunu gosterir
// @Entity(name="ogrenciler") yaparsak her yerde ogrenciler kullanmamiz gerekiyor
@Entity
// Table annotation icinde name property si oluscak tablonun ismini belirler
// @Table(name="tbl_student1")
public class Student01 {
	
	// @Id annotation altindaki degiskeni primary key yapar
	@Id
	private int id;
	
	// @Column(name="student_name")
	// Eger tablodaki kolon ismini degisken isminden farkli bir isim
	// yapmak istersek yukardaki gibi yazmamiz gerekiyor
	@Column
	private String name;
	
	@Column
	private int grade;

	
	// getter setter leri yapalim
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


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	

	
	// toString() de yapalim
	
	@Override
	public String toString() {
		return "Student01 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}


	

	
	
	
	
	
	
	
}
