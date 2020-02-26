package com.demo.module;

import com.demo.controller.StudentServlet;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceimpl;
import com.google.inject.servlet.ServletModule;

public class StudentModule extends ServletModule{

	@Override
	protected void configureServlets() {
		// TODO Auto-generated method stub
		serve("/student").with(StudentServlet.class);
		bind(StudentService.class).to(StudentServiceimpl.class);
	}
}
