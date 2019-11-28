package com.sims.controller.student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims.dto.student.Student;
import com.sims.utils.Cache;


@WebServlet("/addStudent")
public class AddStudentActionController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("gender",Cache.gender.iterator());
		request.setAttribute("course",Cache.course.iterator());
		request.setAttribute("referral",Cache.referralBy.iterator());
		request.setAttribute("paymentType",Cache.paymentType.iterator());
		HttpSession session=request.getSession(false);
		try {
			long regId=Student.generateRegId();
			session.setAttribute("regid",regId);
			request.setAttribute("regid",regId);
			RequestDispatcher rd=request.getRequestDispatcher("studentform.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
