package com.mapping.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor2;
import com.mapping.entity.InstructorDetails2;

public class DeleteInstructorDetailsDemo {
	public static void main(String args[])
	{
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetails2.class).addAnnotatedClass(Instructor2.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=44;
			session.beginTransaction();
			//System.out.println(inst);
			
			InstructorDetails2 inst=session.get(InstructorDetails2.class, id);
			if(inst!=null)
			{
				System.out.println(inst);
				System.out.println("Associated Instructor:"+inst.getInstructor());
				inst.getInstructor().setInstructorDeatils(null);
				session.delete(inst);
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
