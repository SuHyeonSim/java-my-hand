<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지</title>
<!-- 여기에 필요한 CSS 파일들을 링크합니다 -->
<link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="../../images/apple-touch-icon.png">
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/responsive.css">
<link rel="stylesheet" href="../../css/custom.css">
<link rel="stylesheet" href="../../css/login.css">
<link rel="stylesheet" href="../../css/search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" />
</head>
<body>
<%@ page import="java.util.List" %>
<%@ page import="com.project.user.vo.Review" %>

<%@ include file = "../include/nav.jsp"%>
<div class="container-fluid mb-5">
    <div class="row border-top px-xl-5">
        <div class="col-lg-3 d-none d-lg-block" style="max-width:280px">
            <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" href="/MyPage/PointHistory" style="height: 65px; margin-top: 1px; padding: 0 30px;">
                <h2 style="color: white;">마이페이지</h2>
            </a>
            <nav class="collapse show navbar navbar-vertical navbar-light align-items-start p-0 border border-left-0 border-top-0 border-bottom-" id="navbar-vertical">
                <div class="navbar-nav w-100" style="height: 410px;">
                    <a href="/MyPage/PointHistory" class="nav-item nav-link margin-left-5px">적립금</a>
                    <a href="/MyPage/OrderList" class="nav-item nav-link">주문내역</a>
                    <a href="/MyPage/Edit" class="nav-item nav-link">회원정보수정</a>
                    <a href="/MyPage/ReviewList" class="nav-item nav-link">리뷰내역</a>
                </div>
            </nav>
        </div>
<div class="container mt-5">

        <%@page import = "com.project.user.vo.User" %>
        <input type="hidden" name="user_no" value="<%=user.getUser_no()%>">
    <h1 class="mb-4">리뷰 리스트</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>리뷰 번호</th>
                <th>상품 번호</th>
                <th>리뷰 내용</th>
                <th>리뷰 이미지</th>
                <th>작성 날짜</th>
                <th>별점</th>
                
            </tr>
        </thead>
        <tbody>
        <%@page import = "com.project.user.vo.Review" %>
        <%@page import ="java.util.*" %>
           
            <%
                List<Review> reviewList = (List<Review>) request.getAttribute("reviewList");
                if (reviewList != null) {
                    for (Review review : reviewList) {
            %>
            <tr>
                <td><%= review.getReviewNo() %></td>
                <td><%= review.getProdNo() %></td>
                <td><%= review.getReviewContent() %></td>
                <td>
                    <%
                        if (review.getReviewImgEnroll() != null) {
                    %>
                    <img src="<%= request.getContextPath() %>../../upload/<%= review.getReviewImgEnroll() %>" alt="Review Image" width="100">
                    <%
                        } else {
                    %>
                    없음
                    <%
                        }
                    %>
                </td>
                <td><%= review.getReviewDate() %></td>
                <td><%= review.getReviewStar() %></td>
            </tr>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</div>
</div>
</div>
<%@ include file = "../include/footer.jsp"%>



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
        