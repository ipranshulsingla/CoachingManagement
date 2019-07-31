<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="com.sims.dto.enquiry.*" %>
<%@ page import="com.sims.dto.generic.Course" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Enquiry</title>
    <link rel="stylesheet" href="stylesheets/main.css">
    <link rel="stylesheet" href="stylesheets/addenquiry.css">
    <%
    boolean flag=false;
    Enquiry enq=null;
    if(request.getAttribute("enquiry")!=null){
     	enq=(Enquiry)request.getAttribute("enquiry");
        flag=true;
    }%>
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
                                <form action="addenquiry<%if(flag){out.print("?id="+enq.getEnquiryId());} %>" method="post">
                                    <div class="flex justify-center">
                                        <div>
                                            <table>
                                                <tr>
                                                    <td><label for="date">Enquiry Date:</label></td>
                                                    <td><input type="date" id="date" name="date" required <% if(flag){out.print("disabled value="+enq.getDate());}%>></td>
                                                </tr>
                                                <%
                                                if(flag){%>
                                                	<tr>
                                           			<td><label for="eid">EID:</label></td>
                                                    <td><input type="text" id="eid" name="eid" required <% if(flag){out.print("disabled value="+enq.getEnquiryId());}%>></td>
                                                	</tr>
                                               <%}
                                                %>
                                                <tr>
                                                    <td><label for="first-name">First Name:</label></td>
                                                    <td><input type="text" id="first-name" name="firstname" <% if(flag){out.print("disabled value="+enq.getFirstName());}%> ></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="last-name">Last Name:</label></td>
                                                    <td><input type="text" id="last-name" name="lastname" required <% if(flag){out.print("disabled value="+enq.getLastName());}%>></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="age">Age:</label></td>
                                                    <td><input type="number" size="3" name="age" min="18" max="99" <% if(flag){out.print("disabled value="+enq.getAge());}%>></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="contactno">Mobile No:</label> </td>
                                                    <td><input type="text" id="contactno" name="mobileno" required <% if(flag){out.print("value="+enq.getMobileNo());}%>><br></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="email">Email:</label></td>
                                                    <td><input type="email" id="email" name="email" required <% if(flag){out.print("value="+enq.getEmail());}%>></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="gender">Gender:</label></td>
                                                    <td><input type="radio" name="gender" value="M" required <% if(flag==true&&enq.getGender()=='M'){out.print("disabled checked");}%>>
                                                        <label>Male</label> 
                                                        <input type="radio" name="gender" value="F" required <% if(flag==true&&enq.getGender()=='F'){out.print("disabled checked");}%>>
                                                        <label>Female</label> 
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><label for="address">Address:</label></td>
                                                    <td><input type="text" id="address" name="address" <% if(flag){out.print("value="+enq.getAddress());}%>></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="course">Course:</label> </td>
                                                    <td><select id="course" name="course" required>
                                                    	<option disabled selected value="">Select Course</option>
                                                    <%
                                                    	Iterator<Course> itc=(Iterator<Course>)request.getAttribute("courses");
                                                                                                        	while(itc.hasNext()) {
                                                                                            				Course course=itc.next();
                                                    %>
                                                        <option <%if(flag&&course.getCourseName().equals(enq.getCourse())){%>selected<%}%> value = "<%out.print(course.getCourseId());%>"><%out.print(course.getCourseName());%></option>
                                        			<%}%> 
                                                       </select> </td>
                                                </tr>
                                                <tr>
                                                    <td> <label for="message">Message:</label></td>
                                                    <td><input type="text" id="message" name="message" <%if(flag){out.print("value="+enq.getMessage());}%>></td>
                                                </tr>
                                                <tr>
                                                    <td><label for="status">Status:</label></td>
                                                    <td>
                                                        <select name="status" id="status">
														<option disabled <%if(!flag){out.print("selected");}%> value="">Select Status</option>
                                                    <%	Iterator<Status> its=(Iterator<Status>)request.getAttribute("status");
                                                    	while(its.hasNext()) {
                                        				Status status=its.next();%>
                                                        <option <%if(flag&&status.getStatusName().equals(enq.getStatus())){%>selected<%}%> value = "<%out.print(status.getStatusId());%>"><%out.print(status.getStatusName());%></option>
                                        			<%}%> 	
                                                        </select>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </div>
                                   <%
                                   	if(flag){%>
                                   	 <div class="flex justify-center">
                                     <button type="submit" name="submit" value="update">Submit</button>
                                     <button type="reset">Reset</button>
                                 	 </div>
                                   	<%}
                                   	else{%>
                                   	 <div class="flex justify-center">
                                     <button type="submit" name="submit" value="insert">Submit</button>
                                     <button type="reset">Reset</button>
                                 	 </div>	
                                   	<%}%>
                                   	       
                                </form>
                            </fieldset>
                    </div>
                </section>
        </div>
</body>
</html>