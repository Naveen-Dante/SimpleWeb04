<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language"
	value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" />
<fmt:setLocale value="${language }" scope="session" />
<fmt:setBundle basename="com.epam.bundle.labels" var="bundle"
	scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Login</title>

</head>
<body>
	<div class="panel panel-body">
		<form class="form-horizontal" id="user" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="User Name"><fmt:message
						key="user" bundle="${bundle }"></fmt:message>: </label>
				<div class="col-sm-10" data-toggle="tooltip"
					title="Enter User Name.">
					<input type="text" class="form-control" name="username"
						placeholder="Enter User Name" required pattern="[a-zA-Z]{4,}"
						oninput="setCustomValidity('')"
						oninvalid="this.setCustomValidity('Enter Valid Name Here(minimum 4 alphabets)')">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="Last Name"><fmt:message
						key="pass" bundle="${bundle }"></fmt:message>: </label>
				<div class="col-sm-10">
					<input type="password" class="form-control" name="password"
						placeholder="Enter Password" required pattern="[a-zA-Z]{4,}"
						oninput="setCustomValidity('')"
						oninvalid="this.setCustomValidity('Enter Valid password Here(minimum 4 alphabets)')">
				</div>
			</div>
			<c:if test="${error == true }">
				<div class="alert alert-danger alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
					<strong>ERROR!</strong> <span>"${error_message }"</span>
				</div>
			</c:if>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" name="button" value="login"
						class="btn btn-default">
						<fmt:message key="login" bundle="${bundle }"></fmt:message>
					</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>