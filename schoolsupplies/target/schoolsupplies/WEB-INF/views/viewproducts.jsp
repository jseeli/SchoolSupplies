<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products</title>
</head>
<body>

<h3 >   List of Products  </h3>


<table class="table table-hover table-striped-rows table-bordered table-condensed">
                    <thead>
                        <tr>
                            <td> <b>PID</b> </td>
                            <td> <b>Name</b> </td>
                            <td> <b>Description</b> </td>
                            <td> <b>Qty</b> </td>
                            <td> <b>Cost</b> </td>
                            <td> <b>CID</b> </td>
                            <td ><b>SID</b></td>
                            <td ><b>Image</b></td>
                            <td ><b>Action</b></td>

                        </tr>
                    </thead>
                    
                    <!-- ${pList} coming from viewproducts1() from ProductController() -->
                    
                    <c:if test="${empty pList}" >
                        	<tr>
                        		<td colspan ="9"  align="center" >
                        		    NO RECORDS EXISTS
                        		</td>
                        	</tr>
                        </c:if>
                    
                    <c:forEach var="listValue" items="${pList}">
                    <tr>
                        <td>
                            <c:out value="${listValue.pid}" /> 
                        </td>
                        
                        <td>
                            <c:out value="${listValue.pname}" /> 
                        </td>
                        
                         <td>
                            <c:out value="${listValue.pdesc}" /> 
                        </td>
                        
       					 <td>
                            <c:out value="${listValue.pquan}" /> 
                        </td>
                        
                      	<td>
                            <c:out value="${listValue.pcost}" /> 
                    	</td>
                        
                        <td>
                            <c:out value="${listValue.category}" /> 
                        </td>
                        
                        <td>
                            <c:out value="${listValue.supplier}" /> 
                        </td>
                        
                        <td> 
                        	<!--  <img src="${pageContext.request.contextPath}/resources/${listValue.imgname}"  -->
                        	
                        	<img src="E:/Eclipse/Jaya-Dev/ScSuppWS/schoolsupplies/src/main/webapp/resources/images/${listValue.imgname}"
                        	
                            height="60px"   width="60px" >
                        </td>
                        
                        <td class ="span4">
                        	<c:set var = "contextRoot"
                        	       value = "${pageContext.request.contextPath}">  
                        	</c:set>
                        	
                        	<a class = "btn  btn-info"  role = "button"
                        	   href = "<c:url  value = "/delProduct/${listValue.pid}"  />"  > Delete </a>
                        	 <br>  
                        	<a class = "btn  btn-info"  role = "button"                        	
                        	   href = "<c:url  value = "/updateproduct/${listValue.pid}"  />"  > Update </a>
                        </td>
                        
                        
                    </tr>
                    </c:forEach>
                </table>



</body>
</html>