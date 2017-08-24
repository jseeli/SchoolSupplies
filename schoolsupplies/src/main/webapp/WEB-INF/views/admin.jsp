<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   

<!DOCTYPE html>

<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" 
    		href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" 
    		integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" 
    		crossorigin="anonymous">
    		
  </head>
  
  <body>
  
    <h3 align="center" style="background: silver">         Admin Page          </h3>
    
       <%
			String contextPath = request.getContextPath();
    		System.out.println("=== contextPath in admin.jsp  ==" + contextPath );
		%>
           
    
    <div class="dropdown">
  		<button style="color: fuchsia" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" 
  				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">		Products     </button>
    
  		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton"> 		
    		<a style="color: fuchsia" class="dropdown-item" href="product">Add Product</a>
    		<a class="dropdown-item" href="viewproducts">View Products</a>
 		 </div>	 
	</div>
	
	<br>  <br>  <br>

 	<div class="dropdown">
  		<button style="color: orange" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" 
                         data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">   Categories    </button>
    
 		 <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    		<a class="dropdown-item" href="category">Add Category</a>
    		<a class="dropdown-item" href="viewcategories">View Categories</a>
 		 </div>
	</div>

<br>  <br>  <br>

	<div class="dropdown">
		<button style="color: aqua" class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" 
						data-toggle="dropdown" aria-haspopup="true"  aria-expanded="false">   Suppliers  </button>

		<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			<a class="dropdown-item" href="supplier">Add Supplier</a> <a
				class="dropdown-item" href="viewsuppliers">View Suppliers</a>
		</div>
	</div>





	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" 
    		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" 
    		crossorigin="anonymous">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" 
   			integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
     		crossorigin="anonymous">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" 
    		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" 
    		crossorigin="anonymous">
    </script>
  
  </body>

</html>