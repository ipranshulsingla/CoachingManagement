package com.sims.controller.enquiry;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.CommonDAO;
import com.sims.dao.EnquiryDAO;
import com.sims.dto.enquiry.Status;
import com.sims.dto.generic.Course;
import com.sims.utils.Cache;

@WebServlet("/actionadd")
public class AddEnquiryAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Iterator<Course> itc=Cache.course.iterator();
		Iterator<Status> its=Cache.status.iterator();
		request.setAttribute("courses",itc);
		request.setAttribute("status",its);
		RequestDispatcher rd=request.getRequestDispatcher("enquiryform.jsp");
		rd.forward(request,response);
	}

}
