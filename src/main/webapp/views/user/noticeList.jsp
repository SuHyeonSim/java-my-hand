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
<title>공지사항</title>
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
                                <tr>
                                    <th>번호</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성일</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%@ page import="com.project.user.vo.User" %>
                   			<%User u = (User)session.getAttribute("user"); %>
                        	<%if(u != null) {%>
                        
                        
                            <%@ page import="com.gn.notice.vo.Notice, java.util.*" %>
                            <%
                            	List<Notice> list = (List<Notice>)request.getAttribute("resultNoticeList");
                            	if(!list.isEmpty()){
                            	for(int i = 0; i < list.size(); i++){%>
                                <tr>
                                    <td class="thumbnail-img">
                                        <a href="/notice/noticeSelectInfo?notice_no=<%=list.get(i).getNotice_no() %>"><%=list.get(i).getNotice_no() %></a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="/notice/noticeSelectInfo?notice_no=<%=list.get(i).getNotice_no() %>"><%=list.get(i).getNotice_title() %></a>
                                    </td>
                                    <td class="name-pr">
                                        <a href="/notice/noticeSelectInfo?notice_no=<%=list.get(i).getNotice_no() %>">관리자</a>
                                    </td>
                                    <td class="name-pr">
                                    	<a herf="/notice/noticeSelectInfo?notice_no=<%=list.get(i).getNotice_no() %>"><%=list.get(i).getNotice_reg_date() %></a>
                                    </td>
                                    <input type="hidden" id="notice_no" name="notice_no" value="<%= list.get(i).getNotice_no() %>">
                                    
                                </tr>
                                <%}%>

                            	<%} %>
                            	<%}else{%>
                            		<tr>
										<td>공지사항은 로그인 상태에서만 조회 가능합니다.</td>                            		
                            		
                            		</tr>
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