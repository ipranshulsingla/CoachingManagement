package com.sims.controller.student;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sims.dao.student.StudentDAO;
import com.sims.dto.payment.Dues;
import com.sims.dto.payment.Payment;
import com.sims.dto.student.Student;
import com.sims.utils.Cache;
import com.sims.utils.Utility;


@WebServlet("/submitStudent")
public class AddStudent extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student obj=new Student();
		obj.setRegId((long)request.getSession(false).getAttribute("regid"));
		request.getSession(false).removeAttribute("regid");
		obj.setAdmissionDate(Utility.StringToLocalDate(request.getParameter("admissionDate"),DateTimeFormatter.ISO_DATE));
		obj.setDob(Utility.StringToLocalDate(request.getParameter("dob"),DateTimeFormatter.ISO_DATE));
		obj.setEmail(request.getParameter("email"));
		obj.setMobNo(request.getParameter("mobno"));
		obj.setAddress(request.getParameter("address"));
		obj.setName(request.getParameter("firstname")+" "+request.getParameter("lastname"));
		obj.setFathersName(request.getParameter("fathersName"));
		obj.setGender(Cache.getGender(request.getParameter("gender")));
		obj.setCourse(Cache.getCourse(Integer.parseInt(request.getParameter("course"))));
		obj.setReferralBy(Cache.getReferral(request.getParameter("referral")));
		String payCode=Cache.getPaymentType(request.getParameter("payment")).getValue();
		int noOfInst=0;
		String pStatus=null;
		if(payCode.equals("FP")) {
			noOfInst=1;
			pStatus="paid";
		}
		else if(payCode.equals("NP")) {
			noOfInst=1;
			pStatus="unpaid";
		}
		else if(payCode.equals("EMI")) {
			noOfInst=Integer.parseInt(request.getParameter("numberOfinst"));
			pStatus="unpaid";
		}
		Payment payment=new Payment();
		try {
			payment.setDueDates(Utility.emiCalc(noOfInst,obj.getCourse().getFee(),pStatus));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		payment.setPaymentType(payCode);
		obj.setPayment(payment);
		try {
			int rowCount=new StudentDAO().addStudent(obj);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("students").forward(request,response);;
	}
}
