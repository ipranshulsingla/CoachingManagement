package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.EnquiryDAO;
import com.sims.dto.Enquiry;


@WebServlet("/enquiry")
public class EnquiryController extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EnquiryDAO obj;
		try {
			obj = new EnquiryDAO();
			TreeMap<Integer,Enquiry> enquiry=obj.fetchEnquiry();
			Set<Entry<Integer, Enquiry>> set=enquiry.entrySet();
			Iterator<Entry<Integer, Enquiry>> it=set.iterator();
			request.setAttribute("enquiry",it);
			RequestDispatcher rd=request.getRequestDispatcher("enquiry.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
