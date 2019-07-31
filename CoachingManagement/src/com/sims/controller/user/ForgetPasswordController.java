package com.sims.controller.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims.dao.UserDAO;
import com.sims.helper.MailHelper;
import com.sims.helper.OTPGenerator;

@WebServlet("/forgetpassword")
public class ForgetPasswordController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		UserDAO user = null;
		String OTP=null;
		RequestDispatcher rd=null;
		try {
			user = new UserDAO();
			String name=user.checkEmail(email);
			if(name!=null) {
				OTP=OTPGenerator.generateOTP();
				MailHelper.sendOTP(email,OTP);
				HttpSession session=request.getSession(true);
				session.setAttribute("OTP",OTP);
				session.setAttribute("email",email);
				session.setAttribute("name",name);
				rd=request.getRequestDispatcher("reset.html");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("index.html#wrong-email");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

}
