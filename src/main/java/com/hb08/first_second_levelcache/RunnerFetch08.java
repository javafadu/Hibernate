package com.hb08.first_second_levelcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {
    
    public static void main(String[] args) {
        
        Student08 student1=new Student08();
        Student08 student2=new Student08();
        
        Configuration con=new Configuration().configure("hibernate.cfg.xml").
                addAnnotatedClass(Student08.class);
        
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx= session.beginTransaction();
        
        //FIRST LEVEL CACHE 1.SENARYO : aynı session içinde aynı id ile fetch yapıldığında
        
//      student1= session.get(Student08.class, 1L);
//      
//      System.out.println("----------------------");
//      
//      System.out.println(student1);
//      
//      //eğer first level chache temizlemek istersek session.clear ile yapılabilir.
//      //session.clear();
//      
//      System.out.println("----------------------");
//      student1= session.get(Student08.class, 1L);
//  
//      System.out.println("----------------------");
//      System.out.println(student1);
        
        
        //FIRST LEVEL CACHE 2.SENARYO : aynı session içinde farklı id ile fetch yapıldığında 
        
//      student1= session.get(Student08.class, 1L);
//      
//      System.out.println("----------------------");
//      
//      System.out.println(student1);
//      
//      
//      System.out.println("----------------------");
//      student1= session.get(Student08.class, 2L);
//  
//      System.out.println("----------------------");
//      System.out.println(student1);
//      
//  
//      
//      
//      tx.commit();
//      session.close();
        
        
        
        // SECOND LEVEL CACHE 1.SENARYO : farkli session ayni id ile fetch islemi
        
        
//        student1=session.get(Student08.class, 1L);
//        System.out.println(student1);
//        tx.commit();
//        session.close();  // ilk session kapatip ayni ogrenciyi ikinci session ile alalim
//        
// 
//       
//        //2.session
//        Session session2=sf.openSession();
//        Transaction  tx2= session2.beginTransaction(); 
//        student2=session2.get(Student08.class, 1L);
//        System.out.println(student2); 
//        tx2.commit();
//        session2.close();
//        
//        
//        sf.close();
        
        
        
        // SECOND LEVEL CACHE 2.SENARYO : farkli session farkli id ile fetch islemi
        
        
        student1=session.get(Student08.class, 1L);
        System.out.println(student1);
        tx.commit();
        session.close();  // ilk session kapatip farkli ogrenciyi ikinci session ile alalim
        
 
       
        //2.session
        Session session2=sf.openSession();
        Transaction  tx2= session2.beginTransaction(); 
        student2=session2.get(Student08.class, 2L);
        System.out.println(student2); 
        tx2.commit();
        session2.close();
        
        
        sf.close();
        
        
    }
}
