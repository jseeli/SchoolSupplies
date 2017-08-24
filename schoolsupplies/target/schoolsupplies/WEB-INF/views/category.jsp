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
  
<h3 style="background: yellow" align="center">Add Categories Form</h3>

<form:form action="savecategory" method="post" modelAttribute="category"  >

			<table style="width: 50%">
				<tr>
					<td>Category ID</td>
					<td><input type="number" name="cid" />   </td>
				</tr>
				
				<tr>
					<td> <h4 class="input-title"> Category Name </h4> </td>
					<td><input type="text" name="cname" />    </td>
				</tr>
				
<!--  -------	<tr>
					<td>TEMP INPUT</td>
					<td><input type="text" name="temp" />    </td>
				</tr>
--------- -->
					
				
			</table>
			
 			<br><br><br>
 	
 			<button class="btn btn-lg btn-primary" type="submit">  Save </button>
 			
 			<button class="btn btn-lg btn-primary" type="reset">  Cancel </button>
 					
</form:form>

</body>
</html>
