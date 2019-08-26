<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirm account fail</title>
</head>
<body>
	<p>
		Xác thực email thất bại ! 
		<c:if test="${user-confirm-invalid != null}">
			<span><c:out value="${user-confirm-invalid}" /></span>
		</c:if>
		<c:if test="${token-invalid != null}">
			<span><c:out value="${token-invalid}" /></span>
		</c:if>
	</p>
</body>
</html>