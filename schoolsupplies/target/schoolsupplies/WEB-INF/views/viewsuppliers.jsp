<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers</title>
</head>
<body >

<h3 align="center" style="background-color: yellow;">   List of Suppliers  </h3>


<table  class="table table-hover table-striped-rows table-bordered table-condensed">
                    <thead>
                        <tr>
                            <td> <b>SID</b> </td>
                            <td> <b>Name</b> </td>
                        </tr>
                    </thead>
                    
                    <c:forEach var="listValue" items="${list}">
                    <tr>
                        <td>
                            <c:out value="${listValue.sid}" /> 
                        </td>
                        
                        <td>
                            <c:out value="${listValue.sname}" /> 
                        </td>                        
                    </tr>
                    </c:forEach>
                </table>
</body>
</html>