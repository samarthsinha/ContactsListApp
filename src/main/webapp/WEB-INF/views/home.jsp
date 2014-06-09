<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>${title }</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css"> -->
<link rel="stylesheet" href="resources/css/flat-ui.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
</head>
<body>
<jsp:include page="index.jsp"/>
<div class="container-fluid">
<form:form action="addContact.html" method="post" class="form-signin" role="form">
	<form:input path="firstname" class="form-control" placeholder="First Name"/>
	<form:input path="lastname" class="form-control" placeholder="Last Name"/>
	<form:input path="email" class="form-control" placeholder="Email"/>
	<form:input path="telephone" class="form-control" placeholder="Telephone"/>
	<input type="submit" value="Add Contact" class="btn btn-lg btn-primary btn-block"/>
</form:form>
</div>
</body>
</html>
