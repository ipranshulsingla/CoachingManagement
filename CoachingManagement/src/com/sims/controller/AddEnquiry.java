package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.EnquiryDAO;
import com.sims.dto.Enquiry;
import com.sims.utils.Utility;


@WebServlet("/addenquiry")
public class AddEnquiry extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enquiry newEnquiry=new Enquiry();
		newEnquiry.setDate(Utility.StringToLocalDate(request.getParameter("date"),DateTimeFormatter.ISO_DATE));
		newEnquiry.setAge(Integer.parseInt(request.getParameter("age")));
		newEnquiry.setAddress(request.getParameter("address"));
		newEnquiry.setCourse(request.getParameter("course"));
		newEnquiry.setEmail(request.getParameter("email"));
		newEnquiry.setFirstName(request.getParameter("firstname"));
		newEnquiry.setLastName(request.getParameter("lastname"));
		newEnquiry.setMobileNo(request.getParameter("mobno"));
		newEnquiry.setStatus(request.getParameter("status"));
		try {
			EnquiryDAO obj=new EnquiryDAO();
			obj.addEnquiry(newEnquiry);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
