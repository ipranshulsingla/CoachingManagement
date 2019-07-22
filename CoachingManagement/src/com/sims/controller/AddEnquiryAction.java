package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.EnquiryDAO;
import com.sims.dto.Courses;
import com.sims.dto.Status;

@WebServlet("/actionadd")
public class AddEnquiryAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			EnquiryDAO obj=new EnquiryDAO();
			TreeSet<Courses> courses=obj.fetchCourses();
			Iterator<Courses> itc=courses.iterator();
			TreeSet<Status> status=obj.fetchStatus();
			Iterator<Status> its=status.iterator();
			request.setAttribute("courses",itc);
			request.setAttribute("status",its);
			RequestDispatcher rd=request.getRequestDispatcher("enquiryform.jsp");
			rd.forward(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
