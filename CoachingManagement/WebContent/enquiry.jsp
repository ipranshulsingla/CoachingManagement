<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Iterator"%>
    <%@ page import="com.sims.dto.Enquiry" %>
	<%@ page import="java.util.Map.Entry" %>
	<%@ page import="java.util.Map" %>
	<!DOCTYPE html>
	<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<title>Enquiry</title>
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
									<a href="index.html">Logout</a>
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
										<li><a href="#">Dashboard</a></li>
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
							   <li>Enquiry List</li> 
							   <li><a href="actionadd"><i class="fas fa-plus"></i> Add Enquiry</a></li>
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
										   <option value = "1">BCA</option>
										   <option value = "2">BTECH</option>
										   <option value = "3">BBA</option>
										   <option value = "4">BCOM</option>
									   </select>
									   <a href="#">Submit</a>
								</div>
						</div>
							<table class="">
								<tr>
									<th>Date</th>
									<th>Enquiry ID</th>
									<th>Name</th>
									<th>Email</th>
									<th>Mobile No.</th>
									<th>Course</th>
									<th>Address</th>
									<th>Status</th>
								</tr>
								<% 	Iterator<Entry<Integer, Enquiry>> it=(Iterator<Entry<Integer, Enquiry>>)request.getAttribute("enquiry"); 
									while(it.hasNext()) {
									Map.Entry<Integer, Enquiry> me=(Entry<Integer, Enquiry>)it.next();
									Enquiry enquiry = (Enquiry)(me.getValue());
								%>	<tr>
										<td><%out.print(enquiry.getDate());%></td>
										<td><%out.print(enquiry.getEnquiryId());%></td>
										<td><%String name=enquiry.getFirstName()+" "+enquiry.getLastName();out.print(name);%></td>
										<td><%out.print(enquiry.getEmail());%></td>
										<td><%out.print(enquiry.getMobileNo());%></td>
										<td><%out.print(enquiry.getCourse());%></td>
										<td><%out.print(enquiry.getAddress());%></td>
										<td style="background-color:<%out.print(enquiry.getColor());%>"><%out.print(enquiry.getStatus());%></td>
									</tr>
								<%}%>
							</table>
					</div>
				</section>
		</div>
	 </body>
	</html>