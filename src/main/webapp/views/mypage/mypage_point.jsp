<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>적립금 내역</title>
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
<style>
    .point-table {
        border-collapse: collapse;
        width: 100%;
        margin-top: 20px;
        border-radius: 10px;
        overflow: hidden;
    }
    .point-table th, .point-table td {
        padding: 15px;
        text-align: center;
    }
    .point-table thead th {
        background-color: rgba(64, 137, 159, 0.8)
;
        color: white;
    }
    .point-table tbody tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    .point-table tbody tr:hover {
        background-color: #ddd;
    }
    .point-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }
    .point-header h1 {
        font-size: 24px;
        font-weight: bold;
    }
    .point-balance {
        font-size: 18px;
        color: #4CAF50;
    }
</style>

</head>
<body>
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
         <% int userPoint = (int)request.getAttribute("userPoint"); %>



    <div class="point-header">
        <h1>적립금 내역</h1><h1 class="mb-4"><%=user.getUser_id()%>님의 적립금 :<%=userPoint%></h1>
        <%@ page import="com.project.user.vo.Point" %>
        
    </div>
    <table class="table table-striped point-table">
        <thead>
            <tr>
                <th>포인트 번호</th>
                <th>사용자 번호</th>
                <th>포인트 변동사유</th>
                <th>포인트 변화</th>
                <th>포인트 날짜</th>
            </tr>
        </thead>
        <tbody>
            <%@page import = "com.project.user.vo.Point" %>
            <%@page import ="java.util.*" %>
            <%
                List<Point> pointHistory = (List<Point>) request.getAttribute("pointHistory");
                if (pointHistory != null) {
                    for (Point point : pointHistory) {
            %>
            <tr>
                <td><%= point.getPointNo() %></td>
                <td><%= point.getUserNo() %></td>
                <td><%= point.getPointReason() %></td>
                <td><%= point.getPointChange() %></td>
                <td><%= point.getPointDate() %></td>
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
