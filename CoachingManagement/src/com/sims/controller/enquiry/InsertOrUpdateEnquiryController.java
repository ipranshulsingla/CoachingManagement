package com.sims.controller.enquiry;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.postgresql.util.PSQLException;

import com.sims.dao.EnquiryDAO;
import com.sims.dto.enquiry.Enquiry;
import com.sims.utils.Utility;


@WebServlet("/addenquiry")
public class InsertOrUpdateEnquiryController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opr=request.getParameter("submit");
		if(opr.equals("update")) {
			Enquiry enquiry=new Enquiry();
			enquiry.setEmail(request.getParameter("email"));
			enquiry.setAddress(request.getParameter("address"));
			enquiry.setMobileNo(request.getParameter("mobileno"));
			enquiry.setMessage(request.getParameter("message"));
			enquiry.setCourse(request.getParameter("course"));
			enquiry.setEnquiryId(Integer.parseInt(request.getParameter("id")));
			enquiry.setStatus(request.getParameter("status"));
			EnquiryDAO obj;
			try {
				obj = new EnquiryDAO();
				obj.updateEnquiry(enquiry);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("enquiry");
		}
		else if(opr.equals("insert")){
			Enquiry newEnquiry=new Enquiry();
			newEnquiry.setDate(Utility.StringToLocalDate(request.getParameter("date"),DateTimeFormatter.ISO_DATE));
			newEnquiry.setAge(Integer.parseInt(request.getParameter("age")));
			newEnquiry.setAddress(request.getParameter("address"));
			newEnquiry.setCourse(request.getParameter("course"));
			newEnquiry.setEmail(request.getParameter("email"));
			newEnquiry.setFirstName(request.getParameter("firstname"));
			newEnquiry.setLastName(request.getParameter("lastname"));
			newEnquiry.setMobileNo(request.getParameter("mobileno"));
			newEnquiry.setStatus(request.getParameter("status"));
			newEnquiry.setMessage(request.getParameter("message"));
			newEnquiry.setGender(request.getParameter("gender").charAt(0));
			try {
				EnquiryDAO obj=new EnquiryDAO();
				obj.addEnquiry(newEnquiry);
				response.sendRedirect("enquiry");
			} 
			catch(PSQLException e){
				response.sendRedirect("enquiry");
			}
			catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
	
