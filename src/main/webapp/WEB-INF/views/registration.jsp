<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Đăng kí</title>
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/common.css" />"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<form:form method="POST" modelAttribute="nguoidung" action="/mobilestore/registration" class="form-signin" >
			<h2 class="form-signin-heading">Đăng kí tài khoản</h2>

			<div class="form-group">
				<form:input type="text" path="hoten" class="form-control"
					placeholder="Họ tên"></form:input>
				<form:errors path="hoten"></form:errors>
			</div>

			<div class="form-group">
				<form:input type="text" path="diachi" class="form-control"
					placeholder="Địa chỉ"></form:input>
				<form:errors path="diachi"></form:errors>
			</div>
			
			<div class="form-group">
				<form:input type="number" path="sodienthoai" class="form-control"
					placeholder="Số điện thoại"/>
				<form:errors path="sodienthoai"></form:errors>
			</div>

			<div class="form-group">
				<form:input type="text" path="tendangnhap" class="form-control"
					placeholder="Tên tài khoản"></form:input>
				<form:errors path="tendangnhap"></form:errors>
			</div>

			<div class="form-group">
				<form:input type="text" path="email" class="form-control"
					placeholder="Email" autofocus="true"></form:input>
				<form:errors path="email"></form:errors>
			</div>

			<div class="form-group">
				<form:input type="password" path="matkhau" class="form-control"
					placeholder="Mật khẩu"></form:input>
				<form:errors path="matkhau"></form:errors>
			</div>
			<c:if test="${email_exists != null}">
				<p>${email_exists}</p>
			</c:if>

			<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng
				kí</button>
		</form:form>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>