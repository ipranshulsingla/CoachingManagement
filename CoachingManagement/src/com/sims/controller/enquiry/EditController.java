package com.sims.controller.enquiry;

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

import com.sims.dao.CommonDAO;
import com.sims.dto.enquiry.Enquiry;
import com.sims.dto.enquiry.Status;
import com.sims.dto.generic.Course;
import com.sims.helper.EnquiryOperations;
import com.sims.utils.Cache;

@WebServlet("/edit")
public class EditController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer eid=Integer.parseInt(request.getParameter("id"));
		try {
			Iterator<Course> itc=Cache.course.iterator();
			Iterator<Status> its=Cache.status.iterator();
			Enquiry enquiry=EnquiryOperations.searchEnquiry(eid);
			request.setAttribute("courses",itc);
			request.setAttribute("status",its);
			request.setAttribute("enquiry",enquiry);
			RequestDispatcher rd= request.getRequestDispatcher("enquiryform.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
