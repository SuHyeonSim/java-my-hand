<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<title>주문 완료</title>
<!-- CSS -->
<link rel="shortcut icon" href="../../images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="../../images/apple-touch-icon.png">
<link rel="stylesheet" href="../../css/bootstrap.min.css">
<link rel="stylesheet" href="../../css/style.css">
<link rel="stylesheet" href="../../css/responsive.css">
<link rel="stylesheet" href="../../css/custom.css">
<link rel="stylesheet" href="../../css/search.css">
<link rel="stylesheet" href="../../css/loginEnd.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" />

</head>

<body>
	<!-- Start Main Top -->
	<%@ include file="../include/nav.jsp"%>

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>주문서</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start orderComplete  -->
	<div class="list-box-main">
		<div class="container">
			<div class="title-list">
				<h1>결제 완료</h1>
				<div class="pay_text" style="text-align: center;">
					<b>결제를 정상적으로 완료했습니다.<br> 주문 확인 후 빠른 시일내 배송해드리겠습니다.<br> 이용해주셔서 감사합니다.
					</b>
				</div>
				<hr class="pay_hr">
			</div>
			<div class="col-12 d-flex justify-content-center shopping-box">
				<div class="list_aTag1">
					<a href="/Index" class="ml-auto btn hvr-hover">메인 홈으로 이동하기</a>
				</div>
				<div class="list_aTag2 ml-2">
					<a href="/MyPage/PointHistory" class="ml-auto btn hvr-hover">마이페이지로
						이동하기</a>
				</div>
			</div>
		</div>
	</div>
	<!-- End orderComplete -->

	<!-- Start footer  -->
	<%@ include file="../include/footer.jsp"%>

</body>

</html>