<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<html>
<head>

<!-- 
	TEST
 -->

<link href="<c:url value="/resources/assets/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />"
	rel="stylesheet">



<!-- 
 END TeST
  -->



<link rel="icon" type="image/png"
	href="<c:url value="/resources/images/icon_detail.png"/>" />
<title>Giỏ hàng</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="header.jsp"></jsp:include>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="<c:url value="/resources/custom.js"/>"></script>

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
					<a class="navbar-brand" href="/mobilestore/" style="color: deepskyblue">Yame
						Shop</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li><a href="#">Trang chủ</a></li>
						<%--<li class="dropdown open">--%>
						<%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
						<%--<ul class="dropdown-menu ">--%>
						<%--<li><a href="#">Action</a></li>--%>
						<%--<li><a href="#">Another action</a></li>--%>
						<%--<li><a href="#">Something else here</a></li>--%>
						<%--</ul>--%>
						<%--</li>--%>
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
								class="glyphicon glyphicon-shopping-cart"></span> 
								 <c:choose>
									<c:when test="${soluongsanphammua >0}">
										<div class="product-number"
											style="height: 20px; text-align: center; position: absolute; width: 28px; font-size: 11px; border-radius: 40px; background: red; line-height: 22px; margin-top: -25px; margin-left: 10px; color: white;">
											<span>${soluongsanphammua}</span>
										</div>
									</c:when>
								
									<c:otherwise>
										<div id="product-number-temp">
											
										</div>
									</c:otherwise>
								</c:choose>  
						</a></li>
						<li><a href="#">${username}</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>

	<%-- 	<div class="container">
		<div class="row">
			<div class="col-md-8" style="border: 1px solid grey; height: 300px;">
				<h3 style="color: lightgreen">
					<ins>Giỏ hàng </ins>
				</h3>
				<table class="table">
					<thead>
						<tr>
							<td><strong>Tên sản phẩm</strong></td>
							<td><strong>Màu sản phẩm</strong></td>
							<td><strong>Size</strong></td>
							<td><strong>Số lượng</strong></td>
							<td><strong>Thành tiền</strong></td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="giohang" items="${gioHangs}">
							<tr data-chitietsanpham="${giohang.machitietsanpham}">
								<td class="sp" data-masp="${giohang.masp}">${giohang.tensp}</td>
								<td class="mau" data-mau="${giohang.mamau}">${giohang.tenmau}</td>
								<td class="size" data-size="${giohang.masize}">${giohang.tensize}</td>
								<td class="soluong" data-value="${giohang.soluong}"><input
									class="soluonggiohang" type="number" min="1"
									value="${giohang.soluong}"></td>
								<td class="giatien" data-value="${giohang.giatien}">${giohang.giatien}</td>
								<td><button type="button"
										class="btn btn-danger btn-delete-cart">Xóa</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<h4>
					Thành tiền : <span style="color: red" id="tongtien"></span><span
						style="color: red">VND</span>
				</h4>
			</div>

			<div class="col-md-4"
				style="border: 1px solid grey; border-left: none; height: 300px;">
				<h3 style="color: lightgreen">
					<ins>Thông tin / địa chỉ </ins>
				</h3>
				<div class="form-group">
					<form action="" method="post">

						<label for="tenkhachhang">Tên của bạn </label> <input
							id="tenkhachhang" type="text" class="form-control"
							name="tenkhachhang"> <label for="sodienthoai">Số
							điện thoại</label> <input id="sodienthoai" type="text"
							class="form-control" name="sodienthoai"> <label
							for="diachi">Địa chỉ</label> <input type="text" id="diachi"
							class="form-control" name="diachigiaohang"> <label
							for="ghichu">Ghi chú</label> <input type="text" id="ghichu"
							class="form-control" name="ghichu"> <br> <input
							type="submit" class="btn btn-success" value="Đặt hàng">
					</form>

				</div>
			</div>
		</div>
	</div> --%>
	<div class="container mb-4">
		<div class="row">
			<div class="col-12">
				<div class="table-responsive">
					<table class="table table-striped">
						<thead>
							<tr>
								<th scope="col"></th>
								<th scope="col">Tên sản phẩm</th>
								<th scope="col">Màu sản phẩm</th>
								<th scope="col">Size</th>
								<th scope="col">Số lượng</th>
								<th scope="col">Giá tiền</th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="giohang" items="${gioHangs}">
								<tr data-chitietsanpham="${giohang.machitietsanpham}">
									<td><img style="width: 50px; height: 50px"
										src="<c:url value="/resources/images/product/${giohang.hinhsanpham}" />" /></td>
									<td class="sp" data-masp="${giohang.masp}">${giohang.tensp}</td>
									<td class="mau" data-mau="${giohang.mamau}">${giohang.tenmau }</td>
									<td class="size" data-size="${giohang.masize}">${giohang.tensize }</td>
									<td class="soluong" data-value="${giohang.soluong}"><input class="soluonggiohang" type="number" min="1" value="${giohang.soluong}"></td>
									<td class="giatien" data-value="${giohang.giatien}">${giohang.giatien}</td>
									<td class="text-right"><button
											class="btn btn-md btn-danger btn-delete-cart">
											<i class="ace-icon fa fa-trash-o bigger-120"></i>
										</button></td>
								</tr>
							</c:forEach>
							<tr>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><strong>Tổng tiền</strong></td>
								<td class="text-right" id="tongtien"><strong></strong></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col mb-2">
				<div class="row">
					<div class="col-sm-12  col-md-6">
						
					</div>
					<div class="col-sm-12 col-md-6 text-right">
						<form action="http://localhost:8080/mobilestore/pay">
							<input type="submit" value="Thanh toán"
								class="btn btn-lg btn-block btn-success text-uppercase" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-md-4 wow flash">
				<span class="title-footer">Thông Tin Shop</span><br> <br>
				<span class="info-title-footer">Yame là một thương hiệu thời
					trang đầy uy tín đảm bảo chất lượng sản phẩm tốt nhất cho khách
					hàng</span><br> <span class="info-title-footer">Nhiều sản phẩm
					với mẫu mã đa dạng</span><br> <span class="info-title-footer">Giá
					thành hợp lí</span><br> <span class="info-title-footer">Tận
					tình giúp đỡ , chăm sóc khách hàng</span><br>
			</div>

			<div class="col-md-4 wow flash">
				<span class="title-footer">Liên hệ</span><br> <br> <span
					class="info-title-footer">Tel : 097786672</span><br> <span
					class="info-title-footer">Email : yameshop@gmail.com</span><br>
				<span class="info-title-footer">Address : Cự Lộc,Nhân
					Chính,Thanh Xuân,Hà Nội</span><br>
			</div>

			<div class="col-md-4 wow flash">
				<span class="title-footer">Góp ý của bạn</span><br> <br>
				<form action="" method="post">
					<input name="hoten" type="text" placeholder="Email">
					<textarea name="diachi" placeholder="Nội dung "></textarea>
					<button>Gửi</button>
				</form>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
