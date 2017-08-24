<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
</head>
<body >

<h3 align="center" style="background-color: yellow;">   List of Categories  </h3>


<table  class="table table-hover table-striped-rows table-bordered table-condensed">
                    <thead>
                        <tr>
                            <td> <b>CID</b> </td>
                            <td> <b>Name</b> </td>
                        </tr>
                    </thead>
                    
                    <c:forEach var="listValue" items="${list}">
                    <tr>
                        <td>
                            <c:out value="${listValue.cid}" /> 
                        </td>
                        
                        <td>
                            <c:out value="${listValue.cname}" /> 
                        </td>                        
                    </tr>
                    </c:forEach>
                </table>
                
  <!--  -----------   JUST TRIED THIS CODE                
        <c:forEach items="${list}" var="category">
        <br>                
		<tr bgcolor="cyan">
			<td>${category.cid}</td>
			<td>${category.cname}</td>
			<td><a href="<c:url value="viewcategory"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
   
   -->            
                
</body>
</html>