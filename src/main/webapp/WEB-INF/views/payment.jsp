<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="icon" type="image/png"
	href="/resources/images/icon_detail.png" />
<title>Thanh toán</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/form-validation.css"/>">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/custom.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/jquery/alert.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/form-validation.js"/>"></script>
<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/checkout/">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
</head>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-default none-nav">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
						aria-expanded="false">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/mobilestore/"
						style="color: deepskyblue">Yame Shop</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">Trang chủ</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Sản phẩm <span class="caret"></span></a>
							<ul class="dropdown-menu ">
								<c:forEach var="value" items="${danhmucsanpham}">
									<li><a
										href="/mobilestore/product/${value.madanhmuc}/${value.tendanhmuc}">${value.tendanhmuc}</a></li>
								</c:forEach>
							</ul></li>
						<li><a href="#">Dịch vụ</a></li>
						<li><a href="#">Liên hệ</a></li>
					</ul>

					<ul class="nav navbar-nav navbar-right">
						<c:choose>
							<c:when test="${user != null}">
								<li><a href="#"><span style="color: blue">
											${user.tendangnhap}</span></a></li>
								<li><a href="/mobilestore/logout">Đăng xuất</a></li>
							</c:when>

							<c:otherwise>
								<li><a href="registration/">Đăng kí</a>
								<li><a href="login/">Đăng nhập </a></li>
							</c:otherwise>
						</c:choose>

						<li><a href="/mobilestore/mycart/"><span
								class="glyphicon glyphicon-shopping-cart"></span> <c:choose>
									<c:when test="${soluongsanphammua >0}">
										<div class="product-number"
											style="height: 20px; text-align: center; position: absolute; width: 28px; font-size: 11px; border-radius: 40px; background: red; line-height: 22px; margin-top: -25px; margin-left: 10px; color: white;">
											<span>${soluongsanphammua}</span>
										</div>
									</c:when>

									<c:otherwise>
										<div id="product-number-temp"></div>
									</c:otherwise>
								</c:choose> </a></li>
						<li><a href="#">${username}</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>
	<div class="container">


		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					Giỏ hàng của bạn <span
						class="badge badge-secondary badge-pill">3</span>
				</h4>
				<ul class="list-group mb-3">
					<c:forEach var="gioHang" items="${gioHangs}">
						<li
							class="list-group-item d-flex justify-content-between lh-condensed">
							<div>
								<h6 class="my-0">gioHang.tensanpham</h6>
								<small class="text-muted">gioHang.tensize</small>
							</div> <span class="text-muted">gioHang.giatien</span>
						</li>
					</c:forEach>
					

					<li class="list-group-item d-flex justify-content-between"><span>Total
							(USD)</span> <strong>$20</strong></li>
				</ul>


			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">Thông tin hóa đơn</h4>
				<form class="needs-validation" novalidate>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="firstName">Họ và tên</label> <input type="text"
								class="form-control" id="firstName" placeholder="" value=""
								required>
							<div class="invalid-feedback"></div>
						</div>
					</div>
					<br>

					<div class="mb-3">
						<label for="sodienthoai">Số điện thoại </label> <input type="text"
							class="form-control" id="sodienthoai">
					</div>
					<br>

					<div class="mb-3">
						<label for="email">Email <span class="text-muted">(Bắt
								buộc)</span></label> <input type="email" class="form-control" id="email"
							placeholder="you@example.com">
					</div>
					<br>

					<div class="mb-3">
						<label for="address">Địa chỉ 1</label> <input type="text"
							class="form-control" id="address" placeholder="1234 Main St"
							required>
						<div class="invalid-feedback"></div>
					</div>
					<br>

					<div class="mb-3">
						<label for="address2">Địa chỉ 2 <span class="text-muted">(Nếu
								có)</span></label> <input type="text" class="form-control" id="address2"
							placeholder="Apartment or suite">
					</div>
					


					<hr class="mb-4">
					<button class="btn btn-primary btn-lg btn-block" type="submit">Xác
						nhận</button>
				</form>
			</div>
		</div>


	</div>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

	<script src="<c:url value="/resources/jquery/alert.js"/>"></script>
	<jsp:include page="footer.jsp"></jsp:include>



</body>
</html>