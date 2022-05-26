package com.hb07.fetchtypes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchRunner07 {

	public static void main(String[] args) {
		
		
		/* FETCH TYPE : EAGER
		 * iliskide olan butun objeleri getirir
		 *  
		 select
        student07x0_.id as id1_1_0_,
        student07x0_.grade as grade2_1_0_,
        student07x0_.std_name as std_name3_1_0_,
        booklist1_.student_id as student_3_0_1_,
        booklist1_.id as id1_0_1_,
        booklist1_.id as id1_0_2_,
        booklist1_.name as name2_0_2_,
        booklist1_.student_id as student_3_0_2_ 
    from
        Student07 student07x0_ 
    left outer join
        Book07 booklist1_ 
            on student07x0_.id=booklist1_.student_id 
    where
        student07x0_.id=?
		 */
		
		
		
		/* FETHC TYPE : LAZY 
		 * iliskili objeler getirilmez
		 *    select
        student07x0_.id as id1_1_0_,
        student07x0_.grade as grade2_1_0_,
        student07x0_.std_name as std_name3_1_0_ 
    from
        Student07 student07x0_ 
    where
        student07x0_.id=?
		 */
		
		// Advantage of LAZY 
		/*
		 * 1: sadece ilgili objeyi getirir, ilk yukleme zamani daha kisadir.
		 * 2: Daha az memory ve CPU (kaynak) kullanir
		 */
		
		// DisAdvantage of LAZY 
		/*
		 * 1: Baglantili objeler olmadigi icin Client dan gelen Istek sayisi artabilir
		 */
		
		
		// Advantage of EAGER 
				/*
				 * 1: Istek sayisi daha az olabilir
				 */
				
		// DisAdvantage of EAGER 
				/*
				 * 1: Uzun ilk yukleme suresi
				 * 2: Fazla kaynak kullanim olur, kullanirken dikkatli olmali
				 * Gereksiz eager kullaniminda ihtiyac duyulmayan veriler de geleceginden
				 * memory problemlerine yol acabilir
				 */
		
		// ONETOONE : Hibernate default LAZY yapar
		// MANYTOONE : Hibernate default LAZY yapar
		
		// ONETOMANY : Hibernate default EAGER yapar
		// MANYTOMANY : Hibernate default EAGER yapar
		
		// FETCH TYPE LAZY ise session kapandiktan sonra iliskili objeleri get edemem 
		// getBookList gibi, session kapali, db kapali
		// hibernate.LazyInitializationException aliriz
		
		Student07 student1 = new Student07();
		
		
		Configuration con=new Configuration();
		con.configure("hibernate.cfg.xml");
		con.addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		
		student1= session.get(Student07.class, 1001);
		// System.out.println(student1);
		
		
		tx.commit();
        
        session.close();
        
        System.out.println(student1);
        
        sf.close();
		

	}

}
