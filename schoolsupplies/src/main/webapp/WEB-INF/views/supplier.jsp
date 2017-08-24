<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>



<html lang="en">

<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://use.fontawesome.com/9c842829ac.js"></script>
</head>

<body>
  
<h3 align="center">Adding Suppliers Form</h3>

<form:form action="savesupplier" method="post" modelAttribute="supplier"  >

			<table style="width: 50%">
				<tr>
					<td>Supplier ID</td>
					<td><input type="number" name="sid" />   </td>
				</tr>
				
				<tr>
					<td>Supplier Name</td>
					<td><input type="text" name="sname" />    </td>
				</tr>
				
			</table>
			
			<input type="submit" value="Submit" />
</form:form>

</body>
</html>
