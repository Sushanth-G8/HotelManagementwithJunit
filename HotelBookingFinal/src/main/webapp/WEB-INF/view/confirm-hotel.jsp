<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Confirm Booking</h1>
<form:form action="/hotelbooking/bookingstatus" modelAttribute="hotel">

<label>ID: </label>
<form:input path="id"/>
<br/>

<label>Name: </label>
<form:input path="name"/>
<br/>

<label>Address: </label>
<form:input path="address"/>
<br/>

<label>Price: </label>
<form:input path="price"/>
<br/>
<input type="submit" value="Confirm">

</form:form>

</div>
</body>
</html>