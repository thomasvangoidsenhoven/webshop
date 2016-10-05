<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="UTF-8">
<title>Overview</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<div id="container">
<header>
<h1><span>Web shop</span></h1>
<%@include file="header.jspf" %>
<h2>
User Overview
</h2>

</header><main>
<table>
<tr>
<th>id</th>
<th>description</th>
<th>price</th>
</tr>

<c:forEach var="product" items="${productlist}">
<tr>
<td>${product.id}</td>
<td>${product.description}</td>
<td>${product.price}</td>
</tr>
</c:forEach>


<caption>Users Overview</caption>
</table>
</main>
<footer>
&copy; Webontwikkeling 3, UC Leuven-Limburg
</footer>
</div>
</body>
</html>