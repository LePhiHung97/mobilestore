<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<form:form method="POST" modelAttribute="nguoidung" action="/mobilestore/login" class="form-signin">		

			<div class="form-group">
				<form:input type="text" path="email" class="form-control"
					placeholder="Email"></form:input>
				<form:errors path="email"></form:errors>
			</div>

			<div class="form-group">
				<form:input type="password" path="matkhau" class="form-control"
					placeholder="Mật khẩu"></form:input>
				<form:errors path="matkhau"></form:errors>
			</div>
			<c:if test="${incorrect_account != null}">
				<p>${incorrect_account}</p>
			</c:if>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng
				nhập</button>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>