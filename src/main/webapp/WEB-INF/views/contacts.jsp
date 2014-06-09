<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="resources/css/flat-ui.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
<title>${title}</title>
</head>
<body>
<jsp:include page="index.jsp"/>
<div class="container-fluid ">
<ul class="list-unstyled">
<c:forEach items="${lists}" var="item">
<li class="list-group list-unstyled list-inline">
	<br/>
	<ul class="list-unstyled">
	<li> Name: ${item.getFirstname()} ${item.getLastname()}</li>
	<li> Email: <a href="mailto:${item.getEmail()}">${item.getEmail()}</a></li>
	<li>Telephone: <a href="tel:${item.getTelephone()}">${item.getTelephone()}</a> </li>
	<li><a href="deleteContact?id=${item.getId()}" class="btn btn-danger">Delete Contact</a> 
	<a href="updateContact?id=${item.getId()}" class="btn btn-warning">Update</a></li>
	</ul>
	<br/>
</li>
</c:forEach>
</ul>
</div>

</body>
</html>