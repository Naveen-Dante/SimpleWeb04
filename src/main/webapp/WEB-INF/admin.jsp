<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${language }" scope="session" />

<fmt:setLocale value="${language }" scope="session" />

<fmt:setBundle basename="com.epam.bundle.labels" var="bundle"
	scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
	<p>
		<fmt:message key="welcome" bundle="${bundle }"></fmt:message>
		Admin.
	</p>
	<form action="logout" method="post">
		<button class="btn-lg btn-primary" type="submit" name="button"
			value="logout">LogOut</button>
	</form>
</body>
</html>