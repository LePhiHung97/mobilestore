<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ quản trị</title>
<link rel="icon" type="image/png"
	href="/resources/vendor/images/icons/favicon.ico" />
<jsp:include page="header.jsp"></jsp:include>


<link href="<c:url value="/resources/assets/css/bootstrap.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/font/font-awesome.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/assets/font-awesome/4.5.0/css/font-awesome.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/colorbox.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/ace.min.css" />"
	rel="stylesheet" class="ace-main-stylesheet" id="main-ace-style">
<link href="<c:url value="/resources/assets/css/ace-skins.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/assets/css/ace-skins.min.css" />"
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
                <a href="AdminForward" class="navbar-brand">
                    <small>
                        <i class="fa fa-leaf"></i>
                       Trang chủ
                    </small>
                </a>
            </div>
            <div class="navbar-buttons navbar-header pull-right" role="navigation">
                <ul class="nav ace-nav">
                    <li class="light-blue dropdown-modal">
                        <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                            <img class="nav-user-photo" src="/resources/assets/images/avatars/user.jpg" alt="Jason's Photo" />
                            <span class="user-info">
										<small>Welcome,</small>
										Admin
									</span>

                            <i class="ace-icon fa fa-caret-down"></i>
                        </a>

                        <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                            <li>
                                <a href="#">
                                    <i class="ace-icon fa fa-cog"></i>
                                    Settings
                                </a>
                            </li>

                            <li>
                                <a href="profile.html">
                                    <i class="ace-icon fa fa-user"></i>
                                    Profile
                                </a>
                            </li>

                            <li class="divider"></li>

                            <li>
                                <a href="LogoutController">
                                    <i class="ace-icon fa fa-power-off"></i>
                                    Logout
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>

        </div>
    </div>
    <!-- End Header -->

    <div class="main-container ace-save-state" id="main-container">
        <script type="text/javascript">
            try{ace.settings.loadState('main-container')}catch(e){}
        </script>

        <!-- Begin menu -->
        <div id="sidebar" class="sidebar responsive ace-save-state" style="font:">
            <script type="text/javascript">
                try{ace.settings.loadState('sidebar')}catch(e){}
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
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div>
            <ul class="nav nav-list">
                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="fa fa-product-hunt"></i>
                        <span class="menu-text">Quản lí sản phẩm</span>
                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="/danhsachsanpham">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Danh sách sản phẩm
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>

                <li class="nav nav-list">
                    <a href="#" class="dropdown-toggle">
                        <i class="fa fa-shopping-bag" aria-hidden="true"></i>
                        <span class="menu-text">Quản lý đơn hàng</span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="HienThiDanhSachDeThi_Controller?pageid=1">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Danh sách đơn hàng
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>
                <li class="">
                    <a href="#" class="dropdown-toggle">
                        <i class="fa fa-bar-chart" aria-hidden="true"></i>
                        <span class="menu-text">Thống kê</span>

                        <b class="arrow fa fa-angle-down"></b>
                    </a>

                    <b class="arrow"></b>

                    <ul class="submenu">
                        <li class="">
                            <a href="QuanLyDanhSachBaiTapDoc_Controller?pageid=1">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Thống kê doanh thu
                            </a>

                            <b class="arrow"></b>
                        </li>

                        <li class="">
                            <a href="QuanLyDanhSachBaiTapNghe_Controller?pageid=1">
                                <i class="menu-icon fa fa-caret-right"></i>
                                Thông tin cửa hàng
                            </a>

                            <b class="arrow"></b>
                        </li>
                    </ul>
                </li>

            </ul>
            <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
                <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
            </div>
        </div>
        <!-- End menu -->


        <!-- Begin Content -->
        <div class="main-content">
            <div class="main-content-inner">
                <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                    <ul class="breadcrumb">
                        <li>
                            <i class="ace-icon fa fa-home home-icon"></i>
                            <a href="AdminForward">Trang chủ</a>
                        </li>

                    </ul><!-- /.breadcrumb -->

                </div>
                <!--
                <div class="page-content">

                        <div class="row" >
                            <div class="col-xs-12">

                                <center class="paddingtop-image">
                                    <img width="500" height="250" alt="" src="Template/Backend/assets/images/homeadmin.gif"/>
                                </center>
                            </div>
                        </div>
                </div>
                -->
            </div>
        </div><!-- /.main-content -->
        <!-- End Content -->


        <!-- Begin footer -->
        <div class="footer">
            <div class="footer-inner">
                <div class="footer-content">
						<span class="bigger-120">
							<span class="blue bolder">Ace</span>
							Application &copy; 2013-2014
						</span>

                    &nbsp; &nbsp;
                    <span class="action-buttons">
							<a href="#">
								<i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
							</a>

							<a href="#">
								<i class="ace-icon fa fa-rss-square orange bigger-150"></i>
							</a>
						</span>
                </div>
            </div>
        </div>
        <!-- end footer -->


        <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
            <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
        </a>
</div><!-- /.main-container -->



<script src="/resources/assets/js/jquery-2.1.4.min.js"></script>

<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='/resources/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/resources/assets/js/bootstrap.min.js"></script>


<script src="/resources/assets/js/jquery.colorbox.min.js"></script>


<script src="/resources/assets/js/ace-elements.min.js"></script>
<script src="/resources/assets/js/ace.min.js"></script>


<script type="text/javascript">
    jQuery(function($)
    {
        var $overflow = '';
        var colorbox_params = {
            rel: 'colorbox',
            reposition:true,
            scalePhotos:true,
            scrolling:false,
            previous:'<i class="ace-icon fa fa-arrow-left"></i>',
            next:'<i class="ace-icon fa fa-arrow-right"></i>',
            close:'&times;',
            current:'{current} of {total}',
            maxWidth:'100%',
            maxHeight:'100%',
            onOpen:function(){
                $overflow = document.body.style.overflow;
                document.body.style.overflow = 'hidden';
            },
            onClosed:function(){
                document.body.style.overflow = $overflow;
            },
            onComplete:function(){
                $.colorbox.resize();
            }
        };

        $('.ace-thumbnails [data-rel="colorbox"]').colorbox(colorbox_params);
        $("#cboxLoadingGraphic").html("<i class='ace-icon fa fa-spinner orange fa-spin'></i>");//let's add a custom loading icon


        $(document).one('ajaxloadstart.page', function(e) {
            $('#colorbox, #cboxOverlay').remove();
        });
    })
</script>

</body>
</html>