<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>문의사항</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="../../images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="../../css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="../../css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="../../css/custom.css">
<link rel="stylesheet" href="../../css/login.css">
<link rel="stylesheet" href="../../css/search.css">
<link href='../../css/list.css' rel="stylesheet" type="text/css">
<link href='../../css/paging.css' rel="stylesheet" type="text/css">
      <style>
        /* 기본 버튼 스타일 */
        .custom-button {
            padding: 10px 20px;
            background-color: rgba(64, 137, 159, 0.8);
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 14px;
            font-weight: bold;
            transition: background-color 0.3s ease;
        }

        /* 버튼 호버 시 배경색 변경 */
        .custom-button:hover {
            background-color: #0056b3;
        }

        /* 버튼 클릭 시 배경색 조정 */
        .custom-button:active {
            background-color: #003e82;
        }
    </style>
    
</head>
<body>
<%@ include file = "../include/nav.jsp"%>
	
	<div class="wishlist-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                    <%@ page import="com.project.user.vo.User" %>
                    <%User u = (User)session.getAttribute("user"); %>
                        <table class="table">
                        <%if(u != null) {%>
                        <input type="hidden" id="user_no" name="user_no" value="<%=u.getUser_no()%>">
                        <input type="button" value="글쓰기" onclick="writeInquiry(<%= u.getUser_no()%>)" class="custom-button">
                        <%} %>
                        
                        
                       <script>
                       		function writeInquiry(user_no){
                       			let url = '/shop_user/inquiryCreate?user_no=' +user_no;
                       			open(url, '_self');
                       		}
                       </script>
                            <thead>
                                <tr>
                                    <th>번호</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성일</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%@ page import="com.gn.shop_user.vo.Inquiry, java.util.*" %>
                            <%
                            	List<Inquiry> list = (List<Inquiry>)request.getAttribute("resultInquiryList");
                            	if(!list.isEmpty()){
                            	for(int i = 0; i < list.size(); i++){%>
                                <tr>
                                    <td class="thumbnail-img">
                                        <a href="/shop_user/inquiry?inquiry_no=<%=list.get(i).getInquiry_no() %>"><%=list.get(i).getInquiry_no() %></a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="/shop_user/inquiry?inquiry_no=<%=list.get(i).getInquiry_no() %>"><%=list.get(i).getInquiry_title() %></a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="/shop_user/inquiry?inquiry_no=<%=list.get(i).getInquiry_no() %>"><%=list.get(i).getWriter_name() %></a>
                                    </td>
                                    <td class="name-pr">
                                    	<a herf="/shop_user/inquiry?inquiry_no=<%=list.get(i).getInquiry_no() %>"><%=list.get(i).getInquiry_reg_date() %></a>
                                    </td>
                                    <input type="hidden" id="inquiry_no" name="inquiry_no" value="<%= list.get(i).getInquiry_no() %>">
                                    
                                </tr>
                                <%}%>
                                <%} else{%>
                                <td>등록된 문의사항이 없습니다.</td>
                                <%} %>
                            </tbody>
                                
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
<%@ include file = "../include/footer.jsp"%>

	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="../../js/jquery-3.2.1.min.js"></script>
	<script src="../../js/popper.min.js"></script>
	<script src="../../js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script src="../../js/jquery.superslides.min.js"></script>
	<script src="../../js/bootstrap-select.js"></script>
	<script src="../../js/inewsticker.js"></script>
	<script src="../../js/bootsnav.js."></script>
	<script src="../../js/images-loded.min.js"></script>
	<script src="../../js/isotope.min.js"></script>
	<script src="../../js/owl.carousel.min.js"></script>
	<script src="../../js/baguetteBox.min.js"></script>
	<script src="../../js/form-validator.min.js"></script>
	<script src="../../js/contact-form-script.js"></script>
	<script src="../../js/custom.js"></script>

</body>

</html>