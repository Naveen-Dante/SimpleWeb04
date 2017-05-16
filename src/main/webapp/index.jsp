<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" 
	scope="session"
	/>

<fmt:setLocale value="${language }" scope="session" />

<fmt:setBundle basename="com.epam.bundle.labels" var="bundle"
	scope="session" />
<!DOCTYPE html>
<html lang="${language }">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container" align="center" style="padding-top: 70px">
		<h1>
			<fmt:message key="msg" bundle="${ bundle}"></fmt:message>
		</h1>
	</div>
	<div class="align-middle" style="padding-top: 70px;" align="center">
		<a href="new" class="btn btn-lg btn-primary"> <fmt:message
				key="signup" bundle="${ bundle}"></fmt:message> <span
			class="glyphicon glyphicon-plus"></span>
		</a> <a href="user" class="btn btn-lg btn-info"> <fmt:message
				key="signin" bundle="${ bundle}"></fmt:message> <span
			class="glyphicon glyphicon-user"></span>
		</a>
	</div>
	<footer>
		<form>
			<select id="language" name="language" onchange="submit()">
				<option value="en_US" ${language == 'en_US' ? 'selected' : ''}>English</option>
				<option value="es_ES" ${language == 'es_ES' ? 'selected' : ''}>Español</option>
			</select>
		</form>
	</footer>
</body>
</html>