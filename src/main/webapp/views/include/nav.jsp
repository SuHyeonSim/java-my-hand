<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>꺼냉</title>
<!-- 여기에 필요한 CSS 파일들을 링크합니다 -->
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/responsive.css">
<link rel="stylesheet" href="../../css/custom.css">
<link rel="stylesheet" href="../../css/login.css">
<link rel="stylesheet" href="../../css/search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" />

</head>
<body>
<header class="main-header">
    <nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
        <div class="container">
            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                <i class="fa fa-bars"></i>
            </button>
                <a class="navbar-brand" href="/Index"><img src="../../images/logo.png" class="logo" alt=""></a>
            </div>
            <div class="collapse navbar-collapse" id="navbar-menu">
                <ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
                    <li class="nav-item active"><a class="nav-link" href="../index.jsp">메인</a></li>
                    <!-- <li class="nav-item"><a class="nav-link" href="#">이벤트</a></li> -->
                    <li class="dropdown">
                        <a href="/shop/shopProduct" class="nav-link dropdown-toggle" data-toggle="dropdown">상품</a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">게시판</a>
                        <ul class="dropdown-menu">
                            <li><a href="/notice/noticeSelectList">공지사항</a></li>
                            <li><a href="/shop_user/inquiryList">문의사항</a></li>

                        </ul>
                    </li>
                </ul>

                <div class="not_login">
                	<%@page import = "com.project.user.vo.User" %>
                
                    <% User user = (User) session.getAttribute("user");
                        if (user != null) {

                    %>
                    <a href="/Logout">로그아웃</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/MyPage/PointHistory">마이페이지</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="/Cart/cartList">장바구니</a>
                    <%
                        } else {
                    %>
                    <a href="/User/Login">로그인</a>
                    <% 
                        }
                    %>
                </div>
            </div>
        </div>
    </nav>
</header>
<!-- 여기에 필요한 JavaScript 파일들을 링크합니다 -->
<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/popper.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/jquery.superslides.min.js"></script>
<script src="../../js/bootstrap-select.js"></script>
<script src="../../js/inewsticker.js"></script>
<script src="../../js/bootsnav.js"></script>
<script src="../../js/images-loded.min.js"></script>
<script src="../../js/isotope.min.js"></script>
<script src="../../js/owl.carousel.min.js"></script>
<script src="../../js/baguetteBox.min.js"></script>
<script src="../../js/form-validator.min.js"></script>
<script src="../../js/contact-form-script.js"></script>
<script src="../../js/custom.js"></script>
</body>
</html>
