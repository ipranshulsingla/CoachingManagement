<%@page import="com.sims.dto.generic.Generic"%>
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
                                <li><a href="#">Dashboard</a></li>
                                <li><a href="#">Students</a></li>
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
            <div class="top_search flex justify-flex-end">
                      <ul class="searchbox flex justify-flex-end">
                            <li> <label for="reg-date"><a href="#">Create New</a> </label> </li>
                            <li><label for="search"><a href="#">Search Students</a> </label>
                            <input type="text" id="search" placeholder="Enter student name"></li>
                            <li><a href="#"><i class="fas fa-search"></i></a></li>
                            </ul>
            </div>
            <div class="form">
                <fieldset>
                    <legend >Student Info </legend>
                    <form action="#" method="post">
                       <table>
                           <tr>
                               <td> <label for="reg-date">Admission Date:</label></td>
                               <td> <input name="admissionDate" id="reg-date" type="date" required max=""></td>
                           </tr>
                           <tr>
                               <td> <label for="reg-id">Registration ID:</label></td>
                               <td> <input name="regId" type="text" id="reg-id"  required></td>
                           </tr>
                           <tr>
                               <td> <label for="first">Student Name:</label></td>
                               <td> <input name="firstName" type="text" name="first" id="first" placeholder="first name" required>
                                    <input name="lastName" type="text" name="last"  placeholder="last name" required></td>
                            </tr>
                            <tr>
                               <td><label for="fathername"> Father Name:</label></td>
                               <td> <input name="fathersName" type="text" id="fathername"  required></td>
                           </tr>
                            <tr>
                                <td><label for="date">Date Of Birth:</label></td>
                                <td><input name="dob" type="date" name="date" id="bdate" max required></td>
                            </tr>
                            <tr>
                                <td><label for="gender">Gender:</label></td>
                                <td> <% Iterator<Generic> it=(Iterator<Generic>)request.getAttribute("gender");
										while(it.hasNext()){
											Generic gender=it.next();
											%><input type="radio" name="gender" value=<%=gender.getValue()%> required><%=gender.getDesc()%> 
										<%}%>     
                            </tr>
                            <tr>
                                <td><label for="contact">Contact No.:</label></td>
                                <td><input type="tel" placeholder="mobile" id="contact" pattern="[1-9]{1}[0-9]{9}" required ></td>
                            </tr>
                            <tr>
                                <td><label for="email">Email:</label></td>
                                <td><input type="email" id="email" placeholder="email" required></td>
                            </tr>
                            <tr>
                                <td><label for="address">Address:</label></td>
                                <td><textarea rows="4" cols="50" id="address" placeholder="add address" style="resize: none;" required></textarea></td>
                            </tr>
                            <tr>
                                <td><label >Course:</label></td>
                                <td><select class = "Course" style="margin: 20px 9px;">
                                    <option value = "0" selected disabled>select course</option>
                                    <option value = "1">chutiya</option></td>
                            </tr>
                            <tr>
                                <td><label>Reffered By:</label></td>
                                <td><select class = "refer" style="margin: 20px 9px;">
                                    <option value = "0" selected disabled>reffered by</option>
                                    <option value = "1">Staff</option>
                                    <option value = "2">Student</option>
                                    <option value = "3">Advertisement</option>
                                    <option value = "4">Other</option>
                                   </select></td>
                            </tr>
                            <tr>
                                <td><label>Total Course Fee:</label></td>
                                <td><input type="text" name="" id="fees"></td>
                            </tr>
                            <tr>
                                <td style="padding-bottom: 64px;"><label>Payment Type:</label></td>
                                <td id="payment">
                                    <input type="radio" name="payment">not paid</br>
                                    <input type="radio" name="payment">one time payment</br>
                                    <input id="installment" type="radio" name="payment">in installments
                                    <div id="calculator" class="">
                                        <input id="numberOfinst" type="number"  min="2" max="6">
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