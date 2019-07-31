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

@WebServlet("/resetpassword")
public class ResetPasswordController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		String password=request.getParameter("newpassword");
		String email=(String)session.getAttribute("email");
		if(((String)session.getAttribute("OTP")).equals(request.getParameter("OTP"))) {
			try {
				new UserDAO().resetPassword(password,email);
				session.invalidate();
				response.sendRedirect("reset.html#password-reset-done");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			session.invalidate();
			response.sendRedirect("reset.html#password-reset-fail");
		}
	}

}
