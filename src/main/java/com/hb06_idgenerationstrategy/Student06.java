package com.hb06_idgenerationstrategy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Student06 {
	
	@Id
	// @GeneratedValue tek basina olursa AUTO secilir
	
	// @GeneratedValue(strategy = GenerationType.IDENTITY) en basit ID olusturma yontemidir. 
	// ama performans olarak en iyisi degildir.
	// veritabanindaki Auto Increment olayina karsilik gelir
	
	
	// GenerationType.SEQUENCE performansi daha yuksek, toplu islemlerde daha performansli
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="STD_SEC")
	// @SequenceGenerator(name="STD_SEC", initialValue=1000, allocationSize=50)
	
	// @GeneratedValue(generator = "UUID")
	// @GenericGenerator(name="UUID", strategy="uuid2")
	// 8-4-4-4-128 bit 32 karakter kod uretiyor
	// private String id;
	
	// Performansi dusuk, bir tablo olusturup son id yi orda tutuyor
	// @GeneratedValue(strategy = GenerationType.TABLE)
	
	// Hibernate strateji olarak AUTO secince strateji olarak SEQUENCE uygulandi,
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private int grade;
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
	

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
	
	
	
	
	
	

}
