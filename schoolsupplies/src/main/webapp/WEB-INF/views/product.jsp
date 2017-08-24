<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!-- 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
-->
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
  
<h1>Adding Products Form</h1>

<!-- 		${temp}    -->


	<form:form action="saveproduct" method="post" modelAttribute="product"  
	                 enctype="multipart/form-data">


		<table style="width: 50%">
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="pname" /></td>
			</tr>

			<tr>
				<td>Description</td>
				<td><input type="text" name="pdesc" /></td>
			</tr>

			<tr>
				<td>Quantity</td>
				<td><input type="number" name="pquan" /></td>
			</tr>

			<tr>
				<td>Unit Cost</td>
				<td><input type="number" name="pcost" /></td>
			</tr>

			<tr>
				<td>Select Category</td>
				<td><select class="form-control" name="category" required>
						<option value="">----Category----</option>
						<c:forEach items="${catList}" var="cat">
							<option value="${cat.cid} ">  ${cat.cname}  </option>
						</c:forEach>

				</select>
			</tr>

			<tr>
				<td>Select Supplier</td>
				<td><select class="form-control" name="supplier" required>
						<option value="">----Supplier----</option>
						<c:forEach items="${suppList}" var="sup">
							<option value="${sup.sid} ">  ${sup.sname}  </option>
						</c:forEach>

				</select>
			</tr>
			
	<!-- 	<tr>
				<td>SMPLE EXTRA INPUT TO TEST PARAM</td>
				<td><input type="text" name="tempparam" /></td>
			</tr>	
	-->	
			
			<tr><td>  IMAGE </td>
			<td> <input class="form-control"  type="file"  name="pimage"
			
			           accept="image/*" />
			</td></tr>

		</table>

		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>
