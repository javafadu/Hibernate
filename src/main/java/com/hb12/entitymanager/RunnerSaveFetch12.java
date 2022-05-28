package com.hb12.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerSaveFetch12 {

	public static void main(String[] args) {
		
		Student12 student1 = new Student12();
		student1.setName("John Coffee");
		student1.setGrade(100);
		
		// Hibernate deki SessionFactory e karsilik geliyor
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentunit");
		// persistence.xml den unit bilgisi  (studentunit) ile  aldik.
		
		// Hibernate session a karsilik geliyor
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		// session.save gibi asagidaki
		// em.persist(student1);
		
		
		// session.get gibi
		Student12 student2 = em.find(Student12.class,4);
//		System.out.println(student2);
		
		
		
//		Object result = em.createQuery("FROM Student12 s where s.name='John Coffee'").getSingleResult();
//		System.out.println(result);
//		
		
		em.remove(student1);
		
		

		em.getTransaction().commit();
		em.close();
		emf.close();

	}

}
