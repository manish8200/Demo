package com.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.property.Getter;

import com.demo.domain.Student;

public class StudentServiceimpl implements StudentService{

	public EntityManager getConnection() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence");
		EntityManager em = emf.createEntityManager();
		
		return em;
	}
	
	@Override
	public void addStudent(int id,String name, String add, String city, int zip, String email, String dob){
		// TODO Auto-generated method stub
		
		EntityManager entityManager = getConnection();
		entityManager.getTransaction().begin();
		
		Student stu = new Student();
		//stu.setStdId(id);
		stu.setName(name);
		stu.setAddress(add);
		stu.setEmail(email);
		stu.setCity(city);
		stu.setZip(zip);
		stu.setDob(dob);
		entityManager.persist(stu);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public void updateStudent(int id,String name, String add, String city,  int zip, String email, String dob) {
		// TODO Auto-generated method stub

		EntityManager entityManager = getConnection();
		Query query = entityManager.createQuery("udate Student setName=: ");
		
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		EntityManager entityManager = getConnection();
		Query query = entityManager.createQuery("from Student");
		 List studentList = query.getResultList();
		return studentList;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getConnection();
		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("delete from Student where id =:id");
		query.setParameter("id", id);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		EntityManager entityManager = getConnection();
		Query query = entityManager.createQuery("from Student where id =:id ");
		query.setParameter("id", id);
		Student student = (Student)query.getSingleResult();
				
		return student;
	}

	
}
