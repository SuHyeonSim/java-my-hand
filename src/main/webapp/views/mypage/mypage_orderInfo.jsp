<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>주문 내역</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="../../images/apple-touch-icon.png">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <link rel="stylesheet" href="../../css/style.css">
    <link rel="stylesheet" href="../../css/responsive.css">
    <link rel="stylesheet" href="../../css/custom.css">
    <link rel="stylesheet" href="../../css/login.css">
    <link rel="stylesheet" href="../../css/search.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" crossorigin="anonymous" />
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
    
		<%@page import = "com.project.user.vo.User" %>
		<input type="hidden" name="user_no" value="<%=user.getUser_no()%>">

        <div class="container mt-5">
            <h1 class="mb-4">주문 내역</h1>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>상품명</th>
                        <th>상품가격</th>
                        <th>구매수량</th>
                        <th>배송지 주소</th>
                        <th>공동현관 비밀번호</th>
						<th>요청사항</th>
                    </tr>
                </thead>
                <tbody>
                <%@ page import="com.gn.product_admin.vo.Product_admin,
                        com.gn.order_admin.vo.Buy, com.gn.order_admin.vo.Shiplist,java.util.*" %>
                            <%
                            	List<Map<String, Object>> list = (List<Map<String, Object>>)request.getAttribute("OrderUserInfo");
                            	for(int i = 0; i < list.size(); i++){%>
                    
                        <tr>
                            <td><p><%= list.get(i).get("상품명") %></p></td>
                            <td><p><%= list.get(i).get("상품가격") %></p></td>
                            <td><p><%= list.get(i).get("구매수량") %></p></td>
                            <td><p><%= list.get(i).get("배송지 주소") %></p></td>
                            <%if(list.get(i).get("공동현관 비밀번호") != null){ %>
                            <td><p><%= list.get(i).get("공동현관 비밀번호") %></p></td>
                            <%} else{%>
                            <td><p>공동현관 비밀번호를 입력하지 않았습니다.</p></td>
                            <%} %>
                            <td><p><%= list.get(i).get("요청사항") %></p></td>
                        </tr>
                        
                    <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
<%@ include file = "../include/footer.jsp"%>

<script src="../../js/jquery-3.5.1.min.js"></script>
<script src="../../js/bootstrap.bundle.min.js"></script>
</body>
</html>
