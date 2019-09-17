<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="icon" type="image/png" href="/resources/images/icon_detail.png"/>
    <title>Chi tiết sản phẩm</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <jsp:include page="header.jsp"></jsp:include>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="<c:url value="/resources/custom.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/resources/jquery/alert.js"/>"></script>
</head>
<body>
    <div  class="container-fluid">
        <nav class="navbar navbar-default none-nav">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand"  href="/mobilestore/" style="color:deepskyblue">Yame Shop</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" >
                    <ul class="nav navbar-nav">
                        <li><a href="/mobilestore/">Trang chủ</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sản phẩm <span class="caret"></span></a>
                            <ul class="dropdown-menu ">
                               <c:forEach var="value" items="${danhmucsanpham}">
                                   <li><a href="/mobilestore/product/${value.madanhmuc}/${value.tendanhmuc}">${value.tendanhmuc}</a></li>
                               </c:forEach>
                            </ul>
                        </li>
                        <li><a href="#">Dịch vụ</a></li>
                        <li><a href="#">Liên hệ</a></li>

                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/mobilestore/login/"">Đăng nhập </a></li>
                        <%--<li><a href="#"><span class="glyphicon glyphicon-shopping-cart">--%>
                                   <%--<div class="product-number" style="  height: 20px;--%>
    <%--text-align: center;--%>
    <%--position: absolute;--%>
    <%--width: 28px;--%>
    <%--font-size: 11px;--%>
    <%--border-radius: 40px;--%>
    <%--background: red;--%>
    <%--line-height: 22px;--%>
    <%--margin-top: -25px;--%>
    <%--margin-left: 10px;--%>
   <%--color: white;"><span>${soluongsanphammua}</span></div></span>--%>
                        <%--</a></li>--%>
                        <li><a  href="/cart/"><span class="glyphicon glyphicon-shopping-cart"></span>
                            <c:choose>
                                <c:when test="${soluongsanphammua >0}">
                                     <div class="product-number" style="  height: 20px;
    text-align: center;
    position: absolute;
    width: 28px;
    font-size: 11px;
    border-radius: 40px;
    background: red;
    line-height: 22px;
    margin-top: -25px;
    margin-left: 10px;
   color: white;"><span>${soluongsanphammua}</span></div>
                                </c:when>

                                <c:otherwise>
                                    <%--<div id="giohang"><span>${soluongsanphammua}</span></div>--%>
                                    <div id="giohang"></div>
                                </c:otherwise>
                            </c:choose>
                        </a></li>
                        <li><a href="#">${username}</a></li>

                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>
    </div>

    <div class="container">
    	<div class="row">
    		<p></p>
    	</div>
    	<div class="row">
    		<p></p>
    	</div>
    	<div class="row" style="margin-top:3px;">
    		<p></p>
    	</div>
        <div class="row">
            <div class="col-sm-2 col-md-2">
                <h4 style="margin-top: -1px"><strong>Danh mục </strong></h4>

                <ul style="list-style-type: none;margin-left: -38px;" id="menu_danhmuc">
                    <c:forEach var="danhmuc" items="${danhmucsanpham}">
                        <li><a href="#">${danhmuc.tendanhmuc }</a></li>
                    </c:forEach>
                </ul>
            </div>

            <div class="col-sm-8 col-md-8">
                <div class="row">

                    <div class="col-sm-5 col-md-5">
                        <img src="<c:url value="/resources/images/product/${sanpham.hinhsanpham}" />" alt=""  height="300px">
                    </div>

                    <div class="col-sm-7 col-md-7">
                        <h4 id="tensp" data-value="${sanpham.masanpham}"  style="margin-top: -1px" ><strong>${sanpham.tensanpham}</strong></h4>
                        <h4 id="giatien" data-value="${sanpham.giatien}" style="color:red">${sanpham.giatien}<span>&nbspVND</span></h4>

                        <table class="table">
                            <thead>
                            <td><strong>Màu</strong></td>
                            <td><strong>Size</strong></td>
                            <td><strong>Số lượng</strong></td>
                            </thead>
                            <tbody>
                                <c:forEach var="chitietsanpham" items="${sanpham.chitietsanpham}">
                                    <tr>
                                        <td class="mau" data-mau="${chitietsanpham.mau.mamau}">${chitietsanpham.mau.tenmau}</td>
                                        <td class="size" data-size="${chitietsanpham.size.masize}">${chitietsanpham.size.size}</td>
                                        <td class="soluong" data-soluong="${chitietsanpham.soluong}">${chitietsanpham.soluong}</td>
                                        <td><button  data-chitietsanpham ="${chitietsanpham.machitietsanpham}" type="button" class="btn btn-success btn-giohang">Thêm vào giỏ</button></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                       
                    </div>

                </div>
            </div>

            <div class="col-sm-2 col-md-2" style="text-align: justify">
                <span>${sanpham.mota}</span>
            </div>

         </div>
    </div>



    <div id="footer" class="container-fluid">
        <div class="row">
            <div class="col-md-4 wow flash">
                <span class="title-footer">Giới thiệu</span><br><br>
                <span class="info-title-footer">Yame là một thương hiệu thời trang đầy uy tín đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng</span><br>
                <span class="info-title-footer">Nhiều sản phẩm với mẫu mã đa dạng</span><br>
                <span class="info-title-footer">Giá thành hợp lí</span><br>
                <span class="info-title-footer">Tận tình giúp đỡ , chăm sóc khách hàng</span><br>
            </div>

            <div class="col-md-4 wow flash">
                <span class="title-footer">Liên hệ</span><br><br>
                <span class="info-title-footer">Tel     : 097786672</span><br>
                <span class="info-title-footer">Email   : yameshop@gmail.com</span><br>
                <span class="info-title-footer">Address : Cự Lộc,Nhân Chính,Thanh Xuân,Hà Nội</span><br>
            </div>

            <div class="col-md-4 wow flash">
                <span class="title-footer">Góp ý của bạn</span><br><br>
                <form action="" method="post">
                    <input name="hoten" type="text" placeholder="Email">
                    <textarea name="diachi" placeholder="Nội dung "></textarea>
                    <button>Gửi</button>
                </form>
            </div>
        </div>
    </div>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <script src="<c:url value="/resources/jquery/alert.js"/>"></script>

    <jsp:include page="footer.jsp"></jsp:include>


</body>
</html>
