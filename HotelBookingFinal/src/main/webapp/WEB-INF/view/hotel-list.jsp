<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align ="center" style="color: red">Book a Hotel</h1>

<div align="center">
<table border="1">
<thead>
<tr>
<td>id</td>
<td>name</td>
<td>address</td>
<td>price</td>
</tr>
</thead>
<c:forEach var="hotel"   items="${hotels}">
<tr>
<td>${hotel.id}</td>
<td>${hotel.name}</td>
<td>${hotel.address}</td>
<td>${hotel.price}</td>
<td><a href="/hotelbooking/confirmbooking?hotelid=${hotel.id}" >Book</a></td>
</tr>

</c:forEach>
</table>
</div>
</body>
</html>