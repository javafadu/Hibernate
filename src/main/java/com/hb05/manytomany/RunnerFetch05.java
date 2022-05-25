package com.hb05.manytomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {
	
	public static void main(String[] args) {
		
		Student05 student1=new Student05();
		Book05 book1=new Book05();
		
		Configuration con=new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student05.class).addAnnotatedClass(Book05.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		// id ile bir ogrenci bilgisine eristik
//		student1=session.get(Student05.class, 1001);
//		System.out.println(student1.getName());
//		System.out.println("---------------");
//		System.out.println(student1.getBooks().get(0));
		
		// bookid ile book bilgisi getirme
//		book1 = session.get(Book05.class, 101);
//		System.out.println(book1);
		
		
		//HQL ile kitap ismine göre kayıt getirme ve kitap sahiplerini görme
//      String hqlQuery1="FROM Book05 b WHERE b.name='Math Book'";
//      book1=(Book05) session.createQuery(hqlQuery1).getSingleResult();
//      System.out.println(book1.getName()+":"+book1.getStudents().size());
//      System.out.println("-----------");
//      book1.getStudents().forEach(s->System.out.println(s));
//      System.out.println("-----------");
//      for (Student05 std : book1.getStudents()) {
//          System.out.println(std);
//      }
//      
		
		// HQL ile ogrenci adina gore bir sorgu yaptik , ogrencinin kitaplarini 
		// foreach ile print ettik
//		String hqlQuery2 ="FROM Student05 s WHERE s.name='John Coffee' ";
//		student1 = (Student05) session.createQuery(hqlQuery2).getSingleResult();
//		student1.getBooks().forEach(t->System.out.println(t));
		
		
		// HQL ile ogrenci isimlerini alalim
//		String hqlQuery3 = "SELECT s.name FROM Student05 s ";
//		List<Object []> resultList =  session.createQuery(hqlQuery3).list();
//		System.out.println(resultList);
		
		
		String hqlQuery4 = "SELECT s.name,b.name FROM Student05 s INNER JOIN FETCH Book05 b ON s.id=1001";
		List<Object []> resultList2 = session.createQuery(hqlQuery4).getResultList();
		
		for(Object[] each : resultList2) {
			System.out.println(Arrays.toString(each));
		}
		
		
		tx.commit();
		
		session.close();
		sf.close();
		
}
}