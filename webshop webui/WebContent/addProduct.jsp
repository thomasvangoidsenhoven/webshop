<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
<%@include file="header.jspf" %>
<h2>
Sign Up
</h2>

</header><main>
	<div class="alert-danger">
		<ul>
			<c:forEach var="error" items="${foutboodschappen}">
				<li>${error}</li>
			</c:forEach>
		</ul>
	</div>

    <form method="post" action="Controller?action=createProduct" novalidate="novalidate">
    	<!-- novalidate in order to be able to run tests correctly -->
        <p><label for="productid">Product id</label><input type="text" id="productid" name="productid"
         required value="${productid}"> </p>
        <p><label for="description">Description</label><input type="text" id="description" name="description"
         required value="${description}"> </p>
        <p><label for="price">price</label><input type="number" id="price" name="price"
         required value="${price}"> </p>
  
        <p><input type="submit" id="signUp" value="add product"></p>
        
    </form>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>


