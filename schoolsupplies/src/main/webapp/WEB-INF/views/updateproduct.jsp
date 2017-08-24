<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>

<h3 >   Product to be Updated </h3>


		<div class="container">
			<div class="row main">
				 
				<div class="main-login main-center">
					<form:form action="updateproduct" method="post" commandName="EditProduct1">
											
						<div class="form-group">
							Product ID
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"></span>
									<form:input type="text" readonly="true" path="pid"/>
								</div>
							</div>
						</div>	
							
							<div class="form-group">
							Product Quantity
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i ></i></span>
									<form:input type="text" path="pquan"/>
								</div>
							</div>
						</div>						

						<div class="form-group">
							Product Price
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i ></i></span>
									<form:input type="text" path="pcost"/>
								</div>
							</div>
						</div>				 					 

						<form:button type="submit">Update</form:button>
									
					<%-- 	<div class="form-group ">
							<form:button style="background-color:#000000" width="40" height="40" type="submit" 
							 class="btn btn-primary btn-lg btn-block login-button">Update</form:button>
						
					 --%>
				</form:form>
				
				</div>
				</div>
				</div>
				</body>
				</html>
				
