<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.epam.simpleweb04.domain.User, java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="language" value="${language }" scope="session" />
<fmt:setLocale value="${language }" scope="session" />

<fmt:setBundle basename="com.epam.bundle.labels" var="bundle"
	scope="session" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="${language }">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
<jsp:include page="scripts.html"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="padding-top: 100px">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3>Search Results</h3>
			</div>
			<div class="panel-body">
			
			<c:if test="${error == true }">
				<div class="alert alert-danger alert-dismissable fade in">
					<a href="#" class="close" data-dismiss="alert" aria-label="close">x</a>
					<strong><span>"${error_message }"</span></strong>
				</div>
			</c:if>
				<form method="post" action="book">
					<table class="table table-hover table-bordered">
						<thead>
							<tr>
								<th>Book ID</th>
								<th>Title</th>
								<th>Author</th>
								<th>Info</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${searchResult}" var="book">
							<tr>
								<td>${book.id}</td>
								<td>${book.title}</td>
								<td>${book.author}</td>
								<td><button class="btn btn-default" type="submit" name="book" value="book:${book.id}">Get More Info.</button></td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>