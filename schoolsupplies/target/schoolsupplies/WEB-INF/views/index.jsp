<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>

<html lang="en">
<head>

  	<title>Landing Page....</title>
  	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  	
   	<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- 
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/js/jquery.1.10.2.min.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />

	<link href="${mainCss}" rel="stylesheet" />
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>
-->
    
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://use.fontawesome.com/9c842829ac.js"></script>
    
</head>
<body>

<!--  --------------------------------------------
<h3 align="center" style="background-color: orange " > School Supplies</h3>
<%
String contextPath = request.getContextPath();
    System.out.println("======index.jsp  =========" + contextPath );
%>
<a href = "register"> Registration  </a><br><br>
<a href = "admin"> Admin  </a><br><br>
<a href = "login" > login  </a><br><br>
<a href = "aboutus"> aboutus </a><br><br>
<a href = "contactus"> Contactus </a>
----------------------------------------------------  -->

<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">School Supplies</a>
	</div>
  </div>
  
</nav>
	<div class="jumbotron">
		<div class="container">
			<h1>${title}</h1>
			<p>
				<c:if test="${not empty msg}">
					Hello ${msg}
				</c:if>

				<c:if test="${empty msg}">
					Welcome To School Supplies!!!!
				</c:if>
			</p>
			
			<p>
				<a class="btn btn-primary btn-lg" href="register" role="button">Registration</a> 
			</p>
			<p>
				<a class="btn btn-primary btn-lg" href="admin" role="button">Admin</a>
			</p>			
			<p>
				<a class="btn btn-primary btn-lg" href="login" role="button">Login</a>
			</p>
			<p> 
				<a class="btn btn-primary btn-lg" href="aboutus" role="button">About us</a>
			</p>			
		
		</div>
	</div>

	<div class="container">

  <div class="row">
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
	<div class="col-md-4">
		<h2>Heading</h2>
		<p>ABC</p>
		<p>
			<a class="btn btn-default" href="#" role="button">View details</a>
		</p>
	</div>
  </div>


  <hr>
  <footer>
	<p>© SchoolSupplies.com 2017</p>
  </footer>
</div>

</body>
</html>


