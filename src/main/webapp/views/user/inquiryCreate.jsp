<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<meta charset="utf-8">
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
<link rel="stylesheet" href="../../css/create_user.css">

</head>
<body>
	<%@ include file = "../include/nav.jsp"%>
	
    <div class="create_user_page">
        <div class="container_create">
            <div class="create_box">
            <%@ page import="com.project.user.vo.User" %>
                    <%User u = (User)session.getAttribute("user"); %>
                <form name="create_inquiry_form" action="/shop_user/inquiryCreateEnd" method="post"
                enctype="multipart/form-data">
                    <div class="create_form_group">
                        <h1 class="create_title">문의사항 작성</h1>
                        <label for="inquiry_title">제목</label>
                        <input type="text" id="inquiry_title" name="inquiry_title" class="form-control"
                        placeholder="제목을 입력하세요.">
                        <label for="inquiry_img">이미지</label><br>
                        <input type="file" id="inquiry_img" name="inquiry_img"
                        accept=".png,.jpg,.jpeg"
                        >
                        <input type="hidden" id="user_no" name="user_no" value="<%=u.getUser_no()%>">
                        <input type="hidden" id="user_name" name="user_name" value="<%=u.getUser_name()%>">
                    </div>
                    	
                        <label for="inquiry_content">내용</label><br>
                    	<textarea rows="5" cols="100" style="resize: none"
                    	id="inquiry_content" name="inquiry_content" placeholder="내용을 입력하세요."></textarea>
                    <div class="create_form_group">
                    <br>
                    	<input type="button" value="확인" onclick="create_inquiryBtn();">
                    </div>
                </form>
            </div>
        </div>
    </div>

 	<script>
		 function create_inquiryBtn(){
			var form = document.create_inquiry_form;
			 var result = confirm("작성하시겠습니까?");
			 if(result){
				 if(!form.inquiry_title.value){
					 alert("제목을 입력하세요.");
					 form.inquiry_title.focus();
				 }else if(!form.inquiry_img.value){
					 alert("이미지를 선택하세요.");
					 form.inquiry_img.focus();
				 }else if(!form.inquiry_content.value){
					 alert("내용을 입력하세요.");
					 form.inquiry_content.focus();
				 }else{
				 	form.submit(); 
				 }
			 }
		 }
    	
    </script>

    
    
    
	

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	
	<%@ include file="../include/footer.jsp" %>
	

	<!-- ALL JS FILES -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	<script>
    	let container_login = document.getElementById('container_login')

   			toggle = () => {
      			container_login.classList.toggle('sign-in')
      			container_login.classList.toggle('sign-up')
    		}

    		setTimeout(() => {
      			container_login.classList.add('sign-in')
    		}, 200)
    </script>
</body>

</html>