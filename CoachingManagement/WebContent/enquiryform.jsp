<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sims.dto.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Enquiry</title>
    <link rel="stylesheet" href="stylesheets/main.css">
    <link rel="stylesheet" href="stylesheets/addenquiry.css">
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
                <section class="container flex justify-center">
                    <div class="enq-form">
                             <fieldset>
                                <legend>Enquiry Form</legend>
                                <form action="addenquiry" method="post">
                                    <div class="flex justify-center">
                                        <div>
                                            <table>
                                                <tr>
                                                    <td><label for="date">Enquiry Date:</label></td>
                                                    <td><input type="date" id="date" name="date" required></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="first-name">First Name:</label></td>
                                                    <td><input type="text" id="first-name" name="firstname" required></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="last-name">Last Name:</label></td>
                                                    <td><input type="text" id="last-name" name="lastname" required></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="age">Age:</label></td>
                                                    <td><input type="text" id="age" name="age"></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="contactno">Mobile No:</label> </td>
                                                    <td><input type="text" id="contactno" name="mobileno" required><br></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="email">Email:</label></td>
                                                    <td><input type="email" id="email" name="email"></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="gender">Gender:</label></td>
                                                    <td><input type="radio" name="gender" value="male" required>
                                                        <label>Male</label> 
                                                        <input type="radio" name="gender" value="female" required>
                                                        <label>Female</label> 
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><label for="address">Address:</label></td>
                                                    <td><input type="text" id="address" name="address"></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="course">Course:</label> </td>
                                                    <td><select id="course" name="course" required>
                                                    	<option disabled selected value="">Select Course</option>
                                                    <%	Iterator<Courses> itc=(Iterator<Courses>)request.getAttribute("courses");
                                                    	while(itc.hasNext()) {
                                        				Courses course=itc.next();%>
                                                        <option value = "<%out.print(course.getCourseId());%>"><%out.print(course.getCourseName());%></option>
                                        			<%}%> 
                                                       </select> </td>
                                                </tr>
                                                <tr>
                                                    <td> <label for="message">Message:</label></td>
                                                    <td><input type="text" id="message"></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="status">Status:</label></td>
                                                    <td>
                                                        <select name="status" id="status">
														<option disabled selected value="">Select Status</option>
                                                    <%	Iterator<Status> its=(Iterator<Status>)request.getAttribute("status");
                                                    	while(its.hasNext()) {
                                        				Status status=its.next();%>
                                                        <option value = "<%out.print(status.getStatusId());%>"><%out.print(status.getStatusName());%></option>
                                        			<%}%> 	
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                    <div class="flex justify-center">
                                        <input type="submit">
                                        <input type="reset">
                                    </div>        
                                </form>
                            </fieldset>
                    </div>
                </section>
        </div>
</body>
</html>