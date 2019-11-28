package com.sims.dao.student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

import com.sims.dao.CommonDAO;
import com.sims.dto.payment.Dues;
import com.sims.dto.payment.Payment;
import com.sims.dto.student.Student;
import com.sims.utils.Cache;
import com.sims.utils.SQLConstants;

public class StudentDAO {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public StudentDAO() throws ClassNotFoundException, SQLException{
		con=CommonDAO.getConnection();
	}
	
	public Long fetchLastRegId() throws SQLException {
		ps=con.prepareStatement(SQLConstants.FETCH_LAST_REGID);
		rs=ps.executeQuery();
		rs.next();
		Long lastRegId=rs.getLong("lastRegId");
		return lastRegId;
	}

	public long fetchLastRefNo() throws SQLException {
		ps=con.prepareStatement(SQLConstants.FETCH_LAST_REFNO);
		rs=ps.executeQuery();
		rs.next();
		Long lastRefNo=rs.getLong("lastRefNo");
		return lastRefNo;
	}
	
	public int addStudent(Student sd) throws SQLException {
		int rowCount=0;
		ps=con.prepareStatement(SQLConstants.INSERT_STUDENT_PD);
		ps.setDate(1,Date.valueOf(sd.getAdmissionDate()));
		ps.setLong(2,sd.getRegId());
		ps.setString(3,sd.getName());
		ps.setString(4,sd.getFathersName());
		ps.setDate(5,Date.valueOf(sd.getDob()));
		ps.setString(6,sd.getGender().getValue());
		ps.setString(7,sd.getMobNo());
		ps.setString(8,sd.getEmail());
		ps.setString(9,sd.getAddress());
		ps.setInt(10,sd.getCourse().getCourseId());
		rowCount+=ps.executeUpdate();
		Iterator<Dues> it=sd.getPayment().getDueDates().iterator();
		while(it.hasNext()) {
			ps=con.prepareStatement(SQLConstants.INSERT_STUDENT_FEE);
			Dues due=it.next();
			ps.setInt(1,due.getInstNo());
			ps.setDate(2,Date.valueOf(due.getDueDate()));
			ps.setFloat(3,due.getAmount());
			ps.setLong(4,due.getRefNo());
			ps.setLong(5,sd.getRegId());
			ps.setString(7,due.getStatus());
			ps.setString(6,sd.getPayment().getPaymentType());
			rowCount+=ps.executeUpdate();
		}
		return rowCount;
	}
	
	public TreeMap<Long,Student> fetchStudents() throws SQLException{
		TreeMap<Long,Student> students=new TreeMap<>();
		ps=con.prepareStatement(SQLConstants.FETCH_STUDENT,ResultSet.TYPE_SCROLL_SENSITIVE, 
                ResultSet.CONCUR_UPDATABLE);
		rs=ps.executeQuery();
		Student obj=null;
		while(rs.next()) {
			obj=new Student();
			obj.setRegId(rs.getLong("reg_id"));
			obj.setAdmissionDate(rs.getDate("adm_date").toLocalDate());
			obj.setName(rs.getString("name"));
			obj.setFathersName(rs.getString("fname"));
			obj.setDob(rs.getDate("dob").toLocalDate());
			obj.setGender(Cache.getGender(rs.getString("gender")));
			obj.setMobNo(rs.getString("contact_no"));
			obj.setEmail(rs.getString("email"));
			obj.setAddress(rs.getString("address"));
			obj.setCourse(Cache.getCourse(rs.getInt("course_id")));
			Payment payment=new Payment();
			payment.setPaymentType(rs.getString("payment_type"));
			ArrayList<Dues> dues=new ArrayList<>();
			do{
				Dues due=new Dues();
				due.setAmount(rs.getFloat("amount"));
				due.setDueDate(rs.getDate("due_date").toLocalDate());
				due.setInstNo(rs.getInt("installment_no"));
				due.setStatus(rs.getString("status"));
				due.setRefNo(rs.getLong("ref_no"));
				dues.add(due);
			}while((rs.next())&&(obj.getRegId()==rs.getLong("reg_id")));
			rs.previous();
			payment.setDueDates(dues);
			obj.setPayment(payment);
			students.put(obj.getRegId(),obj);
		}
		return students;
	}
}
