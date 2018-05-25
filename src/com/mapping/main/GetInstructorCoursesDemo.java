package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;

public class GetInstructorCoursesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=25;
			session.beginTransaction();
			//System.out.println(inst);
			Instructor inst=session.get(Instructor.class, id);
			if(inst!=null)
			{
				System.out.println(inst);
				System.out.println("Courses:"+inst.getCourses());
			}
			else
			{
				System.out.println("No Record Found");
			}
			
			session.getTransaction().commit();
			
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			session.close();
			factory.close();
		}
	}

}
