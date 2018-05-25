package com.mapping.main;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;

public class DeleteDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Instructor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			
			session.beginTransaction();
			//System.out.println(inst);
			//get the Instructor by Primary Key
			int id=22;
			Instructor tempInst=session.get(Instructor.class, id);
			if(tempInst!=null)
			{
				System.out.println(tempInst);
				session.remove(tempInst);
				System.out.println("Deleted");
			}
			else
			{
				System.out.println("Not Found");
			}
			//delete the instructor
			
			
			session.getTransaction().commit();
			session.close();
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			factory.close();
		}
		
	}

}
