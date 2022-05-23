package com.hb01.annotations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
		
		Student01 student1 = new Student01();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		//
		Transaction tx = session.beginTransaction();
		
		// 1. YOL : fetch icin
		
		// student1=session.get(Student01.class,1001);
		// System.out.println(student1.getName()); // obje nin ismini
		// System.out.println(student1); // toString()
		

		// 2. YOL  : native query ile select islemi
		
		String sqlQuery="Select * from student01"; // native query
		// listenin her bir elemani bir kayittir.
		// her kayit kolonlardan olustugu icin Object Array icindeki her bir element 
		// bir kolon bilgisi tutar
		List<Object []> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
		
		for (Object [] each : resultList1) {
			System.out.println(Arrays.toString(each));
		}
		
		
		// 3. YOL : HQL (Hibernate Query Language)
		// HQL sorgularinda from dan sonra Entity ismini kullaniyoruz
		// Bu ornekte entity ismi Student01 oldugu icin asagida sorguda onu yazdik
		
		/*
		 * String hqlQuery="FROM Student01"; List<Student01> resultList2 =
		 * session.createQuery(hqlQuery).getResultList();
		 * 
		 * for (Student01 each : resultList2) { System.out.println(each); }
		 */
		
		
		// ismi John Coffee olan ogrenciyi fetch edelim (SQL Query ile)
		String sqlQuery2 = "select * from student01 where name='John Coffee' ";
		/*
		 * List<Object []> resultList3 =
		 * session.createSQLQuery(sqlQuery2).getResultList(); for (Object [] each :
		 * resultList3) { System.out.println(Arrays.toString(each)); }
		 */
		
		
		// Eger sorgu sonucu tek bir kayit unique (satir) doneceginden eminsek --> SQL ile	
		/*
		 * Object [] result1 = (Object[])
		 * session.createSQLQuery(sqlQuery2).uniqueResult();
		 * System.out.println(Arrays.toString(result1));
		 */
		
		// HQL ile unique result fetch etme, alias ile sorgu yazdır (alias = as s)
		/*
		 * String hqlQuery2 = "FROM Student01 s where s.name='John Coffee'"; Object
		 * result2 = session.createQuery(hqlQuery2).uniqueResult();
		 * System.out.println(result2);
		 */
		
		// HQL ile notu 100 olan ogrencileri getirelim
		/*
		 * String hqlQuery3 = "From Student01 s Where s.grade=100 "; List<Object>
		 * resultList4 = session.createQuery(hqlQuery3).getResultList(); for(Object each
		 * : resultList4) { System.out.println(each); }
		 */
		
		// HQL ile notu 100 olan ogrencilerin isimlerini getirelim
		String hqlQuery4 = "Select s.name From Student01 s Where s.grade=100 ";
		List<Object> resultList5 = session.createQuery(hqlQuery4).getResultList();
		for(Object each : resultList5) {
			System.out.println(each);
		}
		
		
		tx.commit();
		
		
		// session close onemli unutma
		session.close();
		sf.close();
		
	}

}
