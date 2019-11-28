<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="com.sims.dto.student.Student,com.sims.helper.StudentOperations" %>
    <%@ page import="java.util.ArrayList" %>
	<%@ page import="java.util.Map.Entry" %>
	<%@ page import="java.util.Map" %>
	<%@ page import="com.sims.dto.payment.*" %>
	<%@ page import="java.time.LocalDate,java.time.Period" %>
	<%@ page import="com.sims.utils.Cache" %>
	<!DOCTYPE html>
	<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Students</title>
		<link rel="stylesheet" href="stylesheets/main.css">
		<link rel="stylesheet" href="stylesheets/enquiry.css">
		<script src="https://kit.fontawesome.com/b06605e970.js"></script>
	</head>
	<body>
	
		<div id="container">
				<header>
						<div class="topbar">
							<div class="container flex justify-flex-end">
								<div class="logout">
									<a href="logout">Logout</a>
								</div>
							</div>
						</div>
						<div class="logo-nav">
							<div class="container flex justify-space-between">
								<div class="logo">
									<a href="#">SIMS</a>
								</div>
								<div class="nav-bar">
									<ul class="flex">
										<li><a href="dashboard">Dashboard</a></li>
										<li><a href="#">Students</a></li>
										<li><a href="#">Faculties</a></li>
										<li><a href="#">Attendance</a></li>
										<li><a href="#">Fee Collection</a></li>
										<li><a href="#">Reports</a></li>
									</ul>
								</div>
							</div>
						</div>
						<hr>
				</header>
				<section class="container">
					<div class="top-section">
							<ul class="flex justify-space-between">
							   <li>Students List</li> 
							   <li><a href="addStudent"><i class="fas fa-plus"></i> Add Student</a></li>
							</ul>
					</div>
					<div>
						<hr>
						<div class="search-box flex justify-space-between">
								<div>
										<h3>Keyword</h3>
										<input type="text" placeholder="Enter keyword">
								</div>
								<div>
										<h3>Search By</h3> 
										<select class = "categories">
										   <option value = "0">Select Category</option>
										   <option value = "1">EID</option>
										   <option value = "2">Name</option>
										   <option value = "3">Course</option>
										   <option value = "4">Date</option>
									   </select>
									   <a href="#">Submit</a>
								</div>
						</div>
							<table class="enquiry">
								<tr>
									<th>Reg.ID</th>
									<th>Name</th>
									<th>Gender</th>
									<th>Mobile No.</th>
									<th>Course</th>
									<th>Address</th>
									<th>Payment</th>
									<th>Action</th>
								</tr>
								<% 	Iterator<Entry<Long,Student>> it=(Iterator<Entry<Long,Student>>)request.getAttribute("students"); 
									while(it.hasNext()) {
									Map.Entry<Long,Student> me=(Entry<Long,Student>)it.next();
									Student student = (Student)(me.getValue());
								%>	<tr>
										<td><%=student.getRegId()%></td>
										<td><%=student.getName()%></td>
										<td><%=student.getGender().getValue()%></td>
										<td><%=student.getMobNo()%></td>
										<td><%=student.getCourse().getCourseName()%></td>
										<td><%=student.getAddress()%></td>
										<%String paymentStatus=StudentOperations.getPaymentStatus(student);%>	
										<td><%=paymentStatus%></td>
										<td><a href="delete?id=<%=student.getRegId()%>"><i class="fas fa-trash"></i></a>
											<a href="edit?id=<%=student.getRegId()%>"><i class="far fa-edit"></i></a>
										</td>
									</tr>
								<%}%>
							</table>
					</div>
				</section>
		</div>
	 </body>
	</html>