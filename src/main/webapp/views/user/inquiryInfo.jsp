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
<title>꺼냉 LOGIN</title>
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

</head>
<body>
<%@ include file = "../include/nav.jsp"%>

	<div class="wishlist-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                            <%@page import="com.gn.shop_user.vo.Inquiry, java.util.*" %>
                            <%Inquiry iq = (Inquiry)request.getAttribute("inquiryInfo");%>
                            <tr style="text-align: center">
       							<th style="width: 80%; "><%= iq.getInquiry_title() %></th>
        						<th><%= iq.getInquiry_reg_date() %></th>
    						</tr>
    						<tr>
        						<th colspan="2" style="width: 5px;"><%= iq.getWriter_name() %></th>
    						</tr>
                            </thead>
                        </table>
                        <%@page import="com.gn.inquiry_admin.vo.Inquiry_comment" %>
                		<%List<Inquiry_comment> ic = (List<Inquiry_comment>)request.getAttribute("adminInquiryCommentInfo");%>
        					<img src="../../upload/<%= iq.getInquiry_img_mod() %>" alt="Image" width="200px" height="200px">
        					<p><%= iq.getInquiry_content() %></p>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <div class="wishlist-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="table-main table-responsive">
                        <table class="table">
                            <thead>
                            
                            <tr style="text-align: center">
       							<th>댓글 목록</th>
        						
    						</tr>
                            </thead>
                        </table>
    							<%if(!ic.isEmpty()) {
                        for(int i = 0; i < ic.size(); i++){%>
                        
                        	<p>관리자 : <%=ic.get(i).getComment_content() %></p>
                        	<p>작성일 : <%=ic.get(i).getComment_reg_date() %></p>
                        	
                        <%}}else{%>
                        <p>댓글이 없습니다.</p>
                        <%} %>
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