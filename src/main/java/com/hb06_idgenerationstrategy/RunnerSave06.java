package com.hb06_idgenerationstrategy;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {

	public static void main(String[] args) {
		
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student06.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student06 student1 = new Student06();
		student1.setName("John Coffee");
		student1.setGrade(100);
		
		Student06 student2 = new Student06();
		student2.setName("Walter White");
		student2.setGrade(85);
		
		Student06 student3 = new Student06();
		student3.setName("Maximus Decimus");
		student3.setGrade(65);
		
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
