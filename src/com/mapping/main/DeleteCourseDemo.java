package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;

public class DeleteCourseDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=1;
			session.beginTransaction();
			//System.out.println(inst);
			Course c=session.get(Course.class, id);
			if(c!=null)
			{
				System.out.println(c);
				session.delete(c);
				System.out.println("Deleted");
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
