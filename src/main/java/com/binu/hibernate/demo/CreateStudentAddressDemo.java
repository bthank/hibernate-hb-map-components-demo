package com.binu.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.binu.hibernate.demo.entity.Student;

public class CreateStudentAddressDemo {

	
	public static void main(String[] args) {
		
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			
		
		// create the object
			Student tempStudent = new Student("Jill","Fournier","jill_fournier@msn.com");
			List<String> theImages = tempStudent.getImages();
			
			theImages.add("photo1.jpg");
			theImages.add("photo2.jpg");
			theImages.add("photo3.jpg");
			theImages.add("photo4.jpg");
			theImages.add("photo4.jpg");  // List allows duplicates
		
		// start a transaction
			session.beginTransaction();
		
		// save the object
			System.out.println("Saving the student and images ...");
			session.persist(tempStudent);
		
		// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done saving!!");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		// do code cleanup
		finally {
			session.close();
			factory.close();
		}
		
		
	}
	
	
	
}
