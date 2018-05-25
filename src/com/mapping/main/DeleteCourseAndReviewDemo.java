package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;
import com.mapping.entity.Review;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=3;
			session.beginTransaction();
			//System.out.println(inst);
			Course tCourse=session.get(Course.class, id);
			System.out.println("Deleting Course");
			session.delete(tCourse);
			System.out.println("Deleted");
			session.getTransaction().commit();
			
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			session.close();
			factory.close();
		}
	}

}
