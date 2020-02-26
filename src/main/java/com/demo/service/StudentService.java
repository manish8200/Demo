package com.demo.service;

import java.util.List;

import com.demo.domain.Student;

public interface StudentService {

	void addStudent(int id,String name, String add, String city,  int zip, String email, String dob);
	
	void updateStudent(int id,String name, String add, String city,  int zip, String email, String dob);
	
	List<Student> getAllStudent();
	
	void delete(int id);
	
	Student getStudentById(int id);
	
}
