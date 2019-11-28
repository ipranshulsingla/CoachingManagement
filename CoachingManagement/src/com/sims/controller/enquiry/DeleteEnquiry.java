package com.sims.controller.enquiry;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.EnquiryDAO;

@WebServlet("/deleteEnquiry")
public class DeleteEnquiry extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer enquiryId=Integer.parseInt(request.getParameter("id"));
		try {
			EnquiryDAO obj=new EnquiryDAO();
			obj.deleteEnquiry(enquiryId);
			response.sendRedirect("enquiry");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
