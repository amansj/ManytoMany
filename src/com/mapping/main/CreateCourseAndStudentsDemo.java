package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;
import com.mapping.entity.Review;
import com.mapping.entity.Student;

public class CreateCourseAndStudentsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			//int id=25;
			session.beginTransaction();
			//System.out.println(inst);
			Course course=new Course("Programming in Java");
			session.save(course);
			System.out.println(course);
			Student a=new Student("A1","B1","abc1@gmail.com");
			Student b=new Student("A2","B2","abc2@gmail.com");
			Student c=new Student("A3","B3","abc3@gmail.com");
			Student d=new Student("A4","B4","abc4@gmail.com");
			course.addStudent(a);
			course.addStudent(b);
			course.addStudent(c);
			course.addStudent(d);
			session.save(a);
			session.save(b);
			session.save(c);
			session.save(d);
			System.out.println("Saved Student:"+course.getStudents());
			session.getTransaction().commit();
			
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			session.close();
			factory.close();
		}
	}

}
