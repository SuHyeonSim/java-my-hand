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
<title>회원가입 성공</title>
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

<style>
    #section_wrap {
        max-width: 600px;
        margin: 100px auto;
        padding: 30px;
        border: 1px solid #ddd;
        border-radius: 10px;
        background-color: #f9f9f9;
        text-align: center;
    }
    #section_wrap h3 {
        font-size: 24px;
        margin-bottom: 20px;
        color: #333;
    }
    #section_wrap a {
        display: inline-block;
        padding: 10px 20px;
        margin-top: 20px;
        color: #fff;
        background-color: #007bff;
        border-radius: 5px;
        text-decoration: none;
        font-size: 18px;
    }
    #section_wrap a:hover {
        background-color: #0056b3;
    }
</style>

</head>
<body>
<%@ include file = "../include/nav.jsp"%>
    <section >
        <div id="section_wrap">
            <div>
                <h3>회원가입 성공! 로그인해주세요.</h3>
            </div>
            <div>
                <a href="/User/Login">로그인</a>
            </div>
        </div>
    </section>
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