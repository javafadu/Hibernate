package com.hb08.first_second_levelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class RunnerSave08 {

	public static void main(String[] args) {

		Student08 student1 = new Student08();
		student1.setName("John Coffee");
		student1.setGrade(98);

		Student08 student2 = new Student08();
		student2.setName("Walter White");
		student2.setGrade(34);

		Configuration con = new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(Student08.class);

		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student1);
		session.save(student2);

		tx.commit();

		session.close();
		sf.close();

	}

}
