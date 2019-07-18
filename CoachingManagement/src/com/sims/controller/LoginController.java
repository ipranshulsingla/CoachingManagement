package com.sims.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.UserDAO;

@WebServlet("/checklogin")
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginController Execution Started");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserDAO user = null;
		try {
			user = new UserDAO();
			String name=user.checkLogin(email, password);
			if(name!=null) {
				RequestDispatcher rd=request.getRequestDispatcher("dashboard.html");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("index.html#wrong-credentials");
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
