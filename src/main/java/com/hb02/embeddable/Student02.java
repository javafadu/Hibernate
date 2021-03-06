package com.hb02.embeddable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class Student02 {
	// @Id annotation altindaki degiskeni primary key yapar
		@Id
		private int id;
		
		
		@Column(name="student_name")
		private String name;
		
		@Column
		private int grade;
		
		
		private Course02 courses;

		
	

		// getter setter leri yapalim
		
		public Course02 getCourses() {
			return courses;
		}


		public void setCourses(Course02 courses) {
			this.courses = courses;
		}

		
		
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
	            return "Student02 [id=" + id + ", name=" + name + ", grade=" + grade + ",courses="+courses+"]";
	        }
		


}
