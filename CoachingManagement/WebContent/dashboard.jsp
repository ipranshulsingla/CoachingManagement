<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpSession"%>    
<!DOCTYPE html>
<html lang="en">
<head>
	<%
	HttpSession s=request.getSession(false);
	if(s==null || s.getAttribute("name")==null)
		response.sendRedirect("index.html#login-box");
	%>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Dashboard</title>
    <link rel="stylesheet" href="stylesheets/main.css">
    <link rel="stylesheet" href="stylesheets/dashboard.css">
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
                                <a href="dashboard.jsp">SIMS</a>
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
            </header>
            <section class="container">
                <ul>
                    <li class="header student-header">
                        <h1>STUDENTS</h1>
                        <div class="options">
                           <ul class="flex " style="justify-content:flex-start">
                               <li>
                                    <div class="icon">
                                            <a href="enquiry">
                                                    <img class="icon-1" src="images/enquiry_icon.png" alt=""> <br>
                                                    <span class="desc-1">Enquiry</span>
                                            </a>
                                    </div>
                               </li>
                               <li>
                                   <div class="icon">
                                        <a href="students">
                                                <img class="icon-2" src="images/students_icon.png" alt=""> <br>
                                                <span class="desc-2">Students</span>
                                        </a>
                                   </div>
                               </li>
                                <li>
                                   <div class="icon">
                                        <a href="#">
                                                <img class="icon-3" src="images/attendance_icon.png" alt=""> <br>
                                                <span class="desc-3">Attendance</span>
                                        </a>
                                   </div>
                                </li>
                                <li>
                                    <div class="icon">
                                            <a href="#">
                                                    <img class="icon-4" src="images/fees_icon.png" alt=""> <br>
                                                    <span class="desc-4">Fees</span>
                                            </a>
                                    </div>
                                </li>
                           </ul>
                        </div>
                    </li>
                    <li class="header course-header">
                            <h1>COURSES AND BATCHES</h1>
                            <div class="options">
                                <ul class="flex" style="justify-content: flex-start">
                                    <li>
                                         <div class="icon">
                                                 <a href="#">
                                                         <img class="icon-1" src="images/batches_icon.png" alt=""> <br>
                                                         <span class="desc-1">Batches</span>
                                                 </a>
                                         </div>
                                    </li>
                                    <li>
                                        <div class="icon">
                                             <a href="#">
                                                     <img class="icon-2" src="images/courses_icon.png" alt=""> <br>
                                                     <span class="desc-2">Courses</span>
                                             </a>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                    </li>
                    <li class="header comm-header">
                        <h1>COMMUNICATION AND TASK</h1>
                        <div class="options">
                           <ul class="flex " style="justify-content:flex-start">
                               <li>
                                    <div class="icon">
                                            <a href="#">
                                                    <img class="icon-1" src="images/email_icon.png" alt=""> <br>
                                                    <span class="desc-1">Email</span>
                                            </a>
                                    </div>
                               </li>
                               <li>
                                   <div class="icon">
                                        <a href="#">
                                                <img class="icon-2" src="images/docs-icon.png" alt=""> <br>
                                                <span class="desc-2">Documents</span>
                                        </a>
                                   </div>
                               </li>
                                <li>
                                   <div class="icon">
                                        <a href="#">
                                                <img class="icon-3" src="images/reports_icon.png" alt=""> <br>
                                                <span class="desc-3">Reports</span>
                                        </a>
                                   </div>
                                </li>
                           </ul>
                        </div>
                    </li>
                </ul>
            </section>
    </div>
    
</body>
</html>