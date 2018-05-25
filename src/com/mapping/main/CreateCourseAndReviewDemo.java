package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;
import com.mapping.entity.Review;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			//int id=25;
			session.beginTransaction();
			//System.out.println(inst);
			Course c=new Course("Packamn");
			c.addReview(new Review("hjdsdhghj"));
			c.addReview(new Review("sjdds"));
			c.addReview(new Review("kvfkd"));
			System.out.println("Saving Course.....");
			System.out.println(c);
			System.out.println(c.getReviews());
			session.save(c);
			session.getTransaction().commit();
			
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			session.close();
			factory.close();
		}
	}

}
