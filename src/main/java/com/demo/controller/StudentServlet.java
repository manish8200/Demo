package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.Student;
import com.demo.service.StudentService;
import com.demo.service.StudentServiceimpl;
import com.google.inject.Inject;


@WebServlet("/student")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	StudentServiceimpl service = new StudentServiceimpl();
  
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String action = request.getParameter("action");
		String frwd = "";
		
		
		if (action.equalsIgnoreCase("list")) {
			request.setAttribute("list", service.getAllStudent());
			frwd = "/studentlist.jsp";
		} else if(action.equalsIgnoreCase("delete")){
			int id = Integer.parseInt(request.getParameter("id"));
			service.delete(id);
			request.setAttribute("list", service.getAllStudent());
			frwd = "/studentlist.jsp";
		}else if(action.equalsIgnoreCase("edit")) {
			frwd = "/index.jsp";
			String id  = request.getParameter("id");
			int StudentId = Integer.parseInt(id);
			Student studentObj = service.getStudentById(StudentId);
			request.setAttribute("Obj", studentObj);
		}
		else {
			frwd = "/index.jsp";
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher(frwd);
		view.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = request.getParameter("action");
		
		int stuid = Integer.parseInt(request.getParameter("id"));
		String fullName = request.getParameter("name");
		String Address = request.getParameter("address");
		String city = request.getParameter("city");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String emails = request.getParameter("email");
		String dob = request.getParameter("date");
		
	     service.addStudent(stuid,fullName, Address, city, zip, emails, dob);
		
		
	     request.setAttribute("list", service.getAllStudent());
		RequestDispatcher view = request.getRequestDispatcher("/studentlist.jsp");
		
		view.forward(request, response);
	
	}

}
