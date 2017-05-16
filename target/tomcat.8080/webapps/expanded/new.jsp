<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language"
	value="${language }" />
<fmt:setLocale value="${language }" scope="session" />

<fmt:setBundle basename="com.epam.bundle.labels" var="bundle"
	scope="session" />
<!DOCTYPE html >
<html lang="${language }">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New User</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<c:out value="${language }"></c:out>
	<div class="container" style="padding-top: 70px">
		<c:if test="${error == true }">
			<div class="alert alert-danger alert-dismissable fade in">
				<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
				<strong>ERROR!</strong> <span>"${error_message }"</span>
			</div>
		</c:if>
		<div class="panel panel-info">
			<div class="panel panel-heading">
				<div style="font-size: 25px" class="panel-title">
					<b><fmt:message key="form" bundle="${bundle }"></fmt:message></b>
				</div>
			</div>
			<div class="panel panel-body">
				<form class="form-horizontal" id="user" method="post">
					<div class="form-group">
						<label class="control-label col-sm-2" for="First Name"><fmt:message
								key="first" bundle="${bundle }"></fmt:message>: </label>
						<div class="col-sm-10" data-toggle="tooltip"
							title="Enter your First Name.">
							<input type="text" class="form-control" name="first-name"
								placeholder="Enter Name" required pattern="[a-zA-Z]{4,}"
								oninput="setCustomValidity('')"
								oninvalid="this.setCustomValidity('Enter Valid First Name Here(minimum 4 alphabets)')">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Last Name"><fmt:message
								key="last" bundle="${bundle }"></fmt:message>: </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="last-name"
								placeholder="Enter Surname" required pattern="[a-zA-Z]{4,}"
								oninput="setCustomValidity('')"
								oninvalid="this.setCustomValidity('Enter Valid Last Name Here(minimum 4 alphabets)')">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="User Name"><fmt:message
								key="user" bundle="${bundle }"></fmt:message>: </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="user-name"
								placeholder="Enter User Name" required pattern="[a-zA-Z]{4,}"
								oninput="setCustomValidity('')"
								oninvalid="this.setCustomValidity('Enter Valid User Name Here(minimum 4 alphabets)')">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="Phone"><fmt:message
								key="phone" bundle="${bundle }"></fmt:message>: </label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="phone"
								pattern="[789][0-9]{9}" placeholder="Enter Phone Number"
								required oninput="setCustomValidity('')"
								oninvalid="this.setCustomValidity('Enter Valid Phone Number.[at least 10 digits]')">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="email"><fmt:message
								key="email" bundle="${bundle }"></fmt:message>: </label>
						<div class="col-sm-10">
							<input type="email" class="form-control" name="email"
								placeholder="Enter Email" required
								oninput="setCustomValidity('')"
								oninvalid="this.setCustomValidity('Enter Email Here')">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="password"><fmt:message
								key="pass" bundle="${bundle }"></fmt:message>: </label>
						<div class="col-sm-10">
							<input type="password" class="form-control" name="password"
								placeholder="Enter password" required>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" name="button" value="new"
								class="btn btn-default">
								<fmt:message key="signup" bundle="${bundle }"></fmt:message>
							</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>