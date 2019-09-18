<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Danh sách sản phẩm</title>
<link rel="icon" type="image/png"
	href="<c:url value="/resources/vendor/images/icons/favicon.ico"/>" />
<link href="<c:url value="/resources/assets/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />"
	rel="stylesheet">

<link href="<c:url value="/resources/assets/css/colorbox.min.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="<c:url value="/resources/assets/css/ace.min.css"/>"
	class="ace-main-stylesheet" id="main-ace-style" />
<link href="<c:url value="/resources/assets/css/ace-skins.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/ace-rtl.min.css" />"
	rel="stylesheet">
<script type="text/javascript"
	src="<c:url value='/resources/assets/js/ace-extra.min.js'/>"></script>

<style type="text/css">
.paddingtop-image {
	padding-top: 75px;
}
</style>
</head>
<body class="no-skin">
	<!-- Header -->
	<div id="navbar" class="navbar navbar-default ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="AdminForward" class="navbar-brand"> <small> <i
						class="fa fa-leaf"></i> Trang chủ
				</small>
				</a>
			</div>
			<div class="navbar-buttons navbar-header pull-right"
				role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue dropdown-modal"><a
						data-toggle="dropdown" href="#" class="dropdown-toggle"> <img
							class="nav-user-photo"
							src="<c:url value="/resources/assets/images/avatars/user.jpg"/>"
							alt="Jason's Photo" /> <span class="user-info"> <small>Welcome,</small>
								Admin
						</span> <i class="ace-icon fa fa-caret-down"></i>
					</a>

						<ul
							class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="ace-icon fa fa-cog"></i>
									Settings
							</a></li>

							<li><a href="profile.html"> <i
									class="ace-icon fa fa-user"></i> Profile
							</a></li>

							<li class="divider"></li>

							<li><a href="LogoutController"> <i
									class="ace-icon fa fa-power-off"></i> Logout
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<!-- End Header -->


	<!-- Content-->
	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>

		<!-- Begin menu -->
		<div id="sidebar" class="sidebar responsive ace-save-state"
			style="font:">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>
			<div class="sidebar-shortcuts" id="sidebar-shortcuts">
				<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
					<button class="btn btn-success">
						<i class="ace-icon fa fa-signal"></i>
					</button>

					<button class="btn btn-info">
						<i class="ace-icon fa fa-pencil"></i>
					</button>

					<button class="btn btn-warning">
						<i class="ace-icon fa fa-users"></i>
					</button>

					<button class="btn btn-danger">
						<i class="ace-icon fa fa-cogs"></i>
					</button>
				</div>
				<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
					<span class="btn btn-success"></span> <span class="btn btn-info"></span>

					<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
				</div>
			</div>
			<ul class="nav nav-list">
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="fa fa-product-hunt"></i> <span class="menu-text">Quản
							lí sản phẩm</span> <b class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a href="/mobilestore/list-product"> <i
								class="menu-icon fa fa-caret-right"></i> Danh sách sản phẩm
						</a> <b class="arrow"></b></li>
					</ul></li>

				<li class="nav nav-list"><a href="#" class="dropdown-toggle">
						<i class="fa fa-shopping-bag" aria-hidden="true"></i> <span
						class="menu-text">Quản lý đơn hàng</span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a
							href="HienThiDanhSachDeThi_Controller?pageid=1"> <i
								class="menu-icon fa fa-caret-right"></i> Danh sách đơn hàng
						</a> <b class="arrow"></b></li>



					</ul></li>
				<li class=""><a href="#" class="dropdown-toggle"> <i
						class="fa fa-bar-chart" aria-hidden="true"></i> <span
						class="menu-text">Thống kê</span> <b
						class="arrow fa fa-angle-down"></b>
				</a> <b class="arrow"></b>

					<ul class="submenu">
						<li class=""><a
							href="QuanLyDanhSachBaiTapDoc_Controller?pageid=1"> <i
								class="menu-icon fa fa-caret-right"></i> Thống kê doanh thu
						</a> <b class="arrow"></b></li>

						<li class=""><a
							href="QuanLyDanhSachBaiTapNghe_Controller?pageid=1"> <i
								class="menu-icon fa fa-caret-right"></i> Thông tin cửa hàng
						</a> <b class="arrow"></b></li>
					</ul></li>

			</ul>
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon"
					class="ace-icon fa fa-angle-double-left ace-save-state"
					data-icon1="ace-icon fa fa-angle-double-left"
					data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>
		<!-- End menu -->


		<!-- Begin Content -->
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a
							href="/mobilestore/manage">Trang chủ</a></li>
						<li><a href="#">Quản lí sản phẩm </a></li>
						<li class="active">Danh sách sản phẩm</li>
					</ul>
					<!-- /.breadcrumb -->

				</div>
				<div class="page-content">
					<c:if test="${danhsachsanpham != null}">
						<h4 class="pink">
							<a href="#modal-table" role="button" class="green"
								data-toggle="modal"> Danh sách sản phẩm </a>
						</h4>
					</c:if>
					<div class="row">
						<div class="col-xs-12">
							<div class="row">
								<div class="col-xs-12">
									<table id="simple-table"
										class="table  table-bordered table-hover">
										<thead>
											<tr>
												<th class="center">Mã sản phẩm</th>
												<th class="center">Tên sản phẩm</th>
												<th class="center">Giá tiền</th>
												<th class="center">Mô tả</th>
												<th class="center">Hình ảnh</th>

												<th class="center">Sửa</th>
												<th class="center">Xóa</th>

											</tr>
										</thead>
										<tbody>
											<c:forEach var="value" items="${sanphams}">
												<tr>
													<td class="masanpham" data-masanpham="${value.masanpham}">
														${value.masanpham}</td>
													<td class="center">${value.tensanpham}</td>

													<td class="center">${value.giatien}</td>

													<td class="center">${value.mota}</td>

													<td>
														<div>
															<ul class="ace-thumbnails clearfix">
																<li><img width="50" height="50" alt="50x50"
																	src="<c:url value="/resources/images/product/${value.hinhsanpham}"/>"
																	alt=""></li>
															</ul>
														</div>
													</td>

													<td class="center">
														<button class="btn btn-xs btn-info btn-sua">
															<i class="ace-icon fa fa-pencil bigger-120"></i>
														</button>
													</td>
													<td class="center">
														<button class="btn btn-xs btn-danger btn-xoa">
															<i class="ace-icon fa fa-trash-o bigger-120"></i>
														</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<%--Pagination --%>
							<ul class="pagination pagination-sm">
								<c:forEach var="i" begin="1" end="${tongsopage}">
									<c:choose>
										<c:when test="${i == 1}">
											<li class="page-item active"><a href="#">${i}</a></li>
										</c:when>
										<c:otherwise>
											<li class="page-item"><a href="#">${i}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>

							<div class="row">
								<div class="col-xs-12">
									<button type="button"
										class="btn btn-white btn-info btn-bold btn-modal-themsanpham">
										Thêm sản phẩm</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>


		<!-- Begin footer -->
		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">Ace</span>
						Application &copy; 2013-2014
					</span> &nbsp; &nbsp; <span class="action-buttons"> <a href="#">
							<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
					</a> <a href="#"> <i
							class="ace-icon fa fa-rss-square orange bigger-150"></i>
					</a>
					</span>
				</div>
			</div>
		</div>
		<!-- end footer -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"><i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i></a>
	</div>
	<!-- End main-container -->

	<div class="modal" tabindex="-1" role="dialog" id="myModal">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h5 class="modal-title" id="exampleModalLabel">
						<strong>Thêm mới sản phẩm</strong>
					</h5>
				</div>
				<div class="modal-body">
					<form id="form-sanpham">
						<div class="form-group">
							<label for="tensanpham" class="col-form-label">Tên sản
								phẩm</label> <input type="text" class="form-control" id="tensanpham"
								name="tensanpham">
						</div>
						<div class="form-group">
							<label for="danhmucsanpham" class="col-form-label">Danh
								mục sản phẩm</label><br> <select name="danhmucsanpham"
								id="danhmucsanpham">
								<c:forEach var="danhmuc" items="${danhMucSanPhams}">
									<option value="${danhmuc.madanhmuc}">${danhmuc.tendanhmuc}</option>
								</c:forEach>
							</select> <br>
						</div>
						<div class="form-group">
							<label for="giatien" class="col-form-label">Giá tiền</label> <input
								type="text" class="form-control" name="giatien" id="giatien">
						</div>
						<div class="form-group">
							<label for="mota" class="col-form-label">Mô tả:</label>
							<textarea class="form-control" id="mota" name="mota" value="mota"></textarea>
						</div>
						<div class="form-group">
							<label for="hinhanh" class="col-form-label">Hình ảnh</label> <input
								type="file" name="hinhanh" class="form-control" id="hinhanh">
						</div>
						<hr>
						<div id="container-chitietsanpham">
							<div class="chitietsanpham">
								<div class="row">
									<div class="col-md-4">
										<label class="col-form-label">Màu </label><br> <select
											name="mau" class="option-chitietsanpham">
											<c:forEach var="mau" items="${mauSanPhams}">
												<option value="${mau.mamau}">${mau.tenmau}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-md-4">
										<label class="col-form-label">Size</label><br> <select
											name="size" class="option-chitietsanpham">
											<c:forEach var="size" items="${sizes}">
												<option value="${size.masize}">${size.size}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-md-2">
										<label class="col-form-label">Số lượng</label> <input
											type="text" name="soluong" min="1" class="form-control"
											class="option-chitietsanpham">
									</div>
									<div class="col-md-2">
										<label class="col-form-label">Thao tác</label>
										<button class="btn btn-success btn-themchitiet"
											style="height: 34px; width: 60px">Thêm</button>
									</div>
								</div>
								<hr>
							</div>
						</div>
						<div id="chitietsanpham_clone" class="chitietsanpham" hidden>
							<div class="row">
								<div class="col-md-4">
									<label class="col-form-label">Màu </label><br> <select
										name="mau" class="option-chitietsanpham" id="mau">
										<c:forEach var="mau" items="${mauSanPhams}">
											<option value="${mau.mamau}">${mau.tenmau}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-4">
									<label class="col-form-label">Size</label><br> <select
										name="size" id="size" class="option-chitietsanpham">
										<c:forEach var="size" items="${sizes}">
											<option value="${size.masize}">${size.size}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-2">
									<label class="col-form-label">Số lượng</label> <input
										id="soluong" name="soluong" type="text" min="1"
										class="form-control" class="option-chitietsanpham">
								</div>
								<div class="col-md-2">
									<label class="col-form-label">Thao tác</label>
									<button class="btn btn-success btn-themchitiet"
										style="height: 34px; width: 60px">Thêm</button>
								</div>
							</div>
							<hr>
						</div>
					</form>
				</div>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng</button>
				<button type="button" class="btn btn-primary btn-luu">Lưu</button>
			</div>
		</div>
	</div>




	<script type="text/javascript"
		src="<c:url value="/resources/jquery/jquery-3.3.1.min.js" />">
		
	</script>
	<script src="<c:url value="/resources/custom.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>

	<script
		src="<c:url value="/resources/assets/js/jquery.colorbox.min.js"/>"></script>
	<script src="<:url value="/resources/assets/js/ace-elements.min.js"/>"></script>
	<script src="<c:url value="/resources/assets/js/ace.min.js"/>"></script>

	<script type="text/javascript">
		jQuery(function($) {
			var $overflow = '';
			var colorbox_params = {
				rel : 'colorbox',
				reposition : true,
				scalePhotos : true,
				scrolling : false,
				/* 	previous : '<i class="ace-icon fa fa-arrow-left"></i>',
					next : '<i class="ace-icon fa fa-arrow-right"></i>', */
				close : '&times;',
				current : '{current} of {total}',
				maxWidth : '100%',
				maxHeight : '100%',
				onOpen : function() {
					$overflow = document.body.style.overflow;
					document.body.style.overflow = 'hidden';
				},
				onClosed : function() {
					document.body.style.overflow = $overflow;
				},
				onComplete : function() {
					$.colorbox.resize();
				}
			};
			$('.ace-thumbnails [data="colorbox"]').colorbox(colorbox_params);
			$("#cboxLoadingGraphic").html(
					"<i class='ace-icon fa fa-spinner orange fa-spin'></i>");
			$(document).one('ajaxloadstart.page', function(e) {
				$('#colorbox, #cboxOverlay').remove();
			});
		})
	</script>

</body>
</html>