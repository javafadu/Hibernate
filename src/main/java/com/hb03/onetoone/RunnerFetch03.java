package com.hb03.onetoone;

import java.util.Arrays;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch03 {

	 public static void main(String[] args) {
	        
	        Student03 student1=new Student03();
	        Diary diary1=new Diary();
	        
	        Configuration con=new Configuration().configure("hibernate.cfg.xml").
	                addAnnotatedClass(Student03.class).addAnnotatedClass(Diary.class);
	        
	        SessionFactory sf=con.buildSessionFactory();
	        Session session=sf.openSession();
	        
	        Transaction tx=session.beginTransaction();
	        
//	      student1=session.get(Student03.class, 1001);
//	      System.out.println(student1.getDiary());
	        
//	      diary1= session.get(Diary.class, 101);
//	      System.out.println(diary1.getStudent());
	        
	       
	       // Query1: 
//	        String hqlQuery1="SELECT s.name, d.name, s.grade from Student03 s INNER JOIN FETCH Diary d ON s.id=d.student";
//	        List<Object[]> resultList1= session.createQuery(hqlQuery1).getResultList();
//	        
//	        for (Object[] r : resultList1) {
//	            System.out.println(Arrays.toString(r));
//	        }
//	        
	        
	        // Query4:
//	        String hqlQuery4 = "FROM Student03 s INNER JOIN FETCH s.diary";
//	        List<Student03> resultList4 = session.createQuery(hqlQuery4).getResultList();
//	        System.out.println(resultList4);
	        
	        
	        // Query5:
//	        String hqlQuery5 = "FROM Diary d INNER JOIN FETCH d.student";
//	        List<Diary> resultList5 = session.createQuery(hqlQuery5).getResultList();
//	        System.out.println(resultList5);
	        
	        // Query6:
	        
	        Query<Result> query = session.createQuery("SELECT new com.hb03.onetoone.Result(s.name, d.name, s.grade) FROM Student03 s "
	        		+ "INNER JOIN FETCH Diary d ON s.id=d.student");
	        
	        List<Result> results = query.getResultList();
	        
	        for(Result each : results) {
	        	System.out.println(each.getStudentName()+" "+each.getDiaryName()+" "+each.getStudentGrade());
	        }
	        
	        
	        tx.commit();
	        
	        session.close();
	        sf.close();
	    }

}
