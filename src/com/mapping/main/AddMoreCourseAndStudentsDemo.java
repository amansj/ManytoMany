package com.mapping.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mapping.entity.Course;
import com.mapping.entity.Instructor;
import com.mapping.entity.InstructorDetails;
import com.mapping.entity.Review;
import com.mapping.entity.Student;

public class AddMoreCourseAndStudentsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		
		try {
			
			int id=36;
			session.beginTransaction();
			//System.out.println(inst);
			Student s1=session.get(Student.class, id);
			Student s2=session.get(Student.class, 41);
			Course course=new Course("Programming in C");
			session.save(course);
			System.out.println(course);
			course.addStudent(s1);
			course.addStudent(s2);
			
			System.out.println("Saved Student:"+course.getStudents());
			session.getTransaction().commit();
			
			//System.out.println(inst);
		}catch(Exception e){System.out.println(e.getMessage());}finally {
			session.close();
			factory.close();
		}
	}

}
