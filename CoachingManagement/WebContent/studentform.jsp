<%@page import="com.sims.dto.generic.Generic"%>
<%@page import="com.sims.dto.generic.Course"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Student</title>
    <link rel="stylesheet" href="stylesheets/main.css">
    <link rel="stylesheet" href="stylesheets/student.css">
    <script src="https://kit.fontawesome.com/b06605e970.js"></script>
    <script src="javascripts/student.js"></script>
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
                                <li><a href="dashboard">Dashboard</a></li>
                                <li><a href="student">Students</a></li>
                                <li><a href="#">Faculties</a></li>
                                <li><a href="#">Attendance</a></li>
                                <li><a href="#">Fee Collection</a></li>
                                <li><a href="#">Reports</a></li>
                            </ul>
                    </div>
                </div>
                <hr>
        </header>
        <section class="container">
            <div class="form">
                <fieldset>
                    <legend >Student Info </legend>
                    <form action="submitStudent" method="post">
                       <table cellspacing=10px>
                           <tr>
                               <td> <label for="reg-date">Admission Date:</label></td>
                               <td> <input name="admissionDate" id="reg-date" type="date" required max=""></td>
                           </tr>
                           <tr>
                           		<%long regId=(long)request.getAttribute("regid");%>
                               <td> <label for="reg-id">Registration ID:</label></td>
                               <td> <input name="regId" type="text" value=<%=regId%> id="reg-id"  readonly></td>
                           </tr>
                           <tr>
                               <td> <label for="first">Student Name:</label></td>
                               <td> <input type="text" id="first" name="firstname" placeholder="First Name" required>
                                    <input type="text" name="lastname" placeholder="Last Name" required></td>
                            </tr>
                            <tr>
                               <td><label for="fathername"> Father's Name:</label></td>
                               <td> <input name="fathersName" type="text" id="fathername"  required></td>
                           </tr>
                            <tr>
                                <td><label for="date">Date Of Birth:</label></td>
                                <td><input name="dob" type="date" id="bdate" max required></td>
                            </tr>
                            <tr>
                                <td><label for="gender">Gender:</label></td>
                                <td><% Iterator<Generic> it=(Iterator<Generic>)request.getAttribute("gender");
										while(it.hasNext()){
											Generic gender=it.next();
											%><input type="radio" name="gender" value=<%=gender.getValue()%> required><%=" "+gender.getDesc()%> 
										<%}%>     
                            </tr>
                            <tr>
                                <td><label for="contact">Contact No.:</label></td>
                                <td><input type="tel" name="mobno" placeholder="Contact No" id="contact" pattern="[1-9]{1}[0-9]{9}" required ></td>
                            </tr>
                            <tr>
                                <td><label for="email">Email:</label></td>
                                <td><input type="email" name="email" id="email" placeholder="E-mail" required></td>
                            </tr>
                            <tr>
                                <td><label for="address">Address:</label></td>
                                <td><textarea rows="4" name="address" cols="50" id="address" placeholder="Add Address" style="resize: none;" required></textarea></td>
                            </tr>
                            <tr>
                                <td><label >Course:</label></td>
                                <td><select class = "Course" name="course" style="margin: 20px 9px;">
                                    <option value = "0" selected disabled>Select Course</option>
                                    <% Iterator<Course> itc=(Iterator<Course>)request.getAttribute("course");
										while(itc.hasNext()){
											Course course=itc.next();
											%><option required data-fee=<%=course.getFee()%> value=<%=course.getCourseId()%> required><%=course.getCourseName()+" | Rs. "+course.getFee()%> 
										<%}%>
									</select>
                                </td>
                            </tr>
                            <tr>
                                <td><label>Referred By:</label></td>
                                <td><select name="referral" class = "refer" style="margin: 20px 9px;">
                                    <% Iterator<Generic> itr=(Iterator<Generic>)request.getAttribute("referral");
										while(itr.hasNext()){
											Generic referral=itr.next();
											%><option value=<%=referral.getValue()%> required><%=referral.getDesc()%> 
									<%}%>
                                   </select></td>
                            </tr>
                            <tr>
                                <td><label>Total Course Fee:</label></td>
                                <td><input required type="text" name="" id="fees"></td>
                            </tr>
                            <tr>
                                <td style="padding-bottom: 64px;"><label>Payment Type:</label></td>
                                <td id="payment">
                                	<% Iterator<Generic> itp=(Iterator<Generic>)request.getAttribute("paymentType");
										while(itp.hasNext()){
											Generic paymentType=itp.next();
										%>	<input type="radio" class="paymentType" required name="payment" value=<%=paymentType.getValue()%> required><%=" "+paymentType.getDesc()%> 
										<%}%> 
                                    <div id="calculator" class="">
                                        <input id="numberOfinst" name="numberOfinst" type="number" min="2" max="6">
                                        <button type="button" onClick="calculate()" id="calcButton">Calculate</button>
                                        <span id="result"></span>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td><button type="submit">Submit</button></td>
                                <td><button type="reset" onClick="resetForm()">Reset</button></td>
                            </tr>
                        </table>
                   </form>
                </fieldset>
            </div>
         </section>
    </div>
   </body>
</html>