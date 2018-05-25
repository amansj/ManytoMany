package com.mapping.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=41;
			session.beginTransaction();
			//System.out.println(inst);
			
			InstructorDetails inst=session.get(InstructorDetails.class, id);
			if(inst!=null)
			{
				System.out.println(inst);
				System.out.println("Associated Instructor:"+inst.getInstructor());
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
