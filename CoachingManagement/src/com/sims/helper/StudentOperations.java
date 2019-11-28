package com.sims.helper;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.sims.dao.student.StudentDAO;
import com.sims.dto.payment.Dues;
import com.sims.dto.student.Student;

public interface StudentOperations {
	public static Iterator<Entry<Long,Student>> studentsIterator() throws ClassNotFoundException, SQLException{
		StudentDAO obj = new StudentDAO();
		TreeMap<Long,Student> student=obj.fetchStudents();
		Set<Entry<Long,Student>> set=student.entrySet();
		Iterator<Entry<Long,Student>> it=set.iterator();
		return it;
	}
	
	public static String getPaymentStatus(Student student) {
		String paymentStatus=null;
		ArrayList<Dues> dues=student.getPayment().getDueDates();
		if(student.getPayment().getPaymentType().startsWith("FP")){
			paymentStatus="Fully Paid";	
		}
		else if(student.getPayment().getPaymentType().startsWith("NP")){
			Dues due=student.getPayment().getDueDates().get(0);
			if(due.getStatus().startsWith("unpaid")) {
				paymentStatus="Not Paid Rs."+due.getAmount(); 
			}
			else {
				paymentStatus="Fully Paid";
			}
		}	
		else if(student.getPayment().getPaymentType().startsWith("EMI")){
			System.out.println(dues);
			Iterator<Dues> itp=dues.iterator();
			ArrayList<Dues> pendingDues=new ArrayList<>();
			while(itp.hasNext()){
				Dues due=itp.next();
				if(due.getStatus().startsWith("unpaid")) {
					pendingDues.add(due);
				}
			}
			Boolean isOverdue=false;
			int overdue=0;
			LocalDate nextPaymentDate=null;
			int min=1000,days=0;
			Period period=null;
			itp=pendingDues.iterator();
			while(itp.hasNext()) {
				Dues due=itp.next();
				if(due.getDueDate().isBefore(LocalDate.now())) {
					isOverdue=true;
					++overdue;
				}
				else if(isOverdue!=true&&(due.getDueDate().isAfter(LocalDate.now())||(due.getDueDate().isEqual(LocalDate.now())))) {
					period=Period.between(LocalDate.now(),due.getDueDate());
					days=period.getDays()+period.getMonths()*30+period.getYears()*365;
					if(days<min) {
						min=days;
						nextPaymentDate=due.getDueDate();
					}
				}
			}
			if(pendingDues.isEmpty()) {
				paymentStatus="Fully Paid";
			}
			else if(isOverdue) {
				paymentStatus="Payment Overdue ("+overdue+")";
			}
			else {
				paymentStatus="Next Payment on "+nextPaymentDate;
			}
		}
		return paymentStatus;
	}
}
