package com.sims.controller.student;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.utils.Cache;


@WebServlet("/student")
public class StudentController extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("gender",Cache.gender.iterator());
		RequestDispatcher rd=request.getRequestDispatcher("student.jsp");
		rd.forward(request, response);
	}

}
