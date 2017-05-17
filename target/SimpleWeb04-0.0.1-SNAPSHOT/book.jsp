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
<title>Book</title>
<jsp:include page="scripts.html"></jsp:include>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container" style="padding-top: 100px">
		<%-- <p>
			<fmt:message key="welcome" bundle="${ bundle}"></fmt:message>
			${user.firstName}.
		</p> --%>
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3>${book.title}</h3>
			</div>
			<div class="panel-body">
				<table>
					<tr>
						<td>
							<img src="${book.imageUrl}">
						</td>
						<td>
							<ul>
								<li><label>Author: </label><span>${book.author}</span></li>
								<li><label>Type: </label><span>${book.type}</span></li>
								<li><label>Description: </label><span>${book.description}</span></li>
							</ul>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>