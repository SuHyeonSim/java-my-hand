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
<title>배송 목록 등록 페이지</title>
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
	<!-- Start Main Top -->

	<%@ include file="../include/nav.jsp"%>

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>배송지 등록</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start shipListCreate  -->
	<%@ page import="com.project.user.vo.User"%>
	<%
	User userLogin = (User) session.getAttribute("user");
	if (userLogin == null) {
		response.sendRedirect("/login.jsp");
		return;
	}
	%>

	<input type="hidden" name="user_no" id="user_no"
		value="<%=user.getUser_no()%>">


	<div class="cart-box-main">
		<div class="container">
			<div class="row">
				<div class="col-sm-6 col-lg-6 mb-3">
					<div class="checkout-address">
						<div class="title-left">
							<h3>배송지 정보 입력란</h3>
						</div>
						<form action="/ship/shipListCreateEnd" method="post"
							name="createList_form">

							<div class="mb-3">
								<label for="ship_alias">배송지 별칭</label>
								<div class="input-group">
									<input type="text" class="form-control" name="ship_alias"
										id="ship_alias" placeholder="">
									<div class="invalid-feedback" style="width: 100%;">Your
										ship alias is required.</div>
								</div>
							</div>
							<div class="mb-3">
								<label for="ship_name">배송 받는 분 성함</label>
								<div class="input-group">
									<input type="text" class="form-control" name="ship_name"
										id="ship_name" placeholder="">
									<div class="invalid-feedback" style="width: 100%;">name
										is required.</div>
								</div>
							</div>
							<div class="mb-3">
								<label for="phone_number">배송 받는 분 연락처</label> <input type="text"
									class="form-control" name="phone_number" id="phone_number"
									placeholder="' - ' 를 함께 입력해주세요">
								<div class="invalid-feedback">Please enter your phone_number.</div>
							</div>

							<div class="mb-3">
								<label for="address_kakao">배송 받는 분 주소</label> <input type="text"
									onclick="address_click()" class="form-control"
									name="address_kakao" id="address_kakao" placeholder="" readonly>
								<div class="invalid-feedback">Please enter a valid email
									address for shipping updates.</div>
								<label for="address_detail">상세 주소</label> <input type="text"
									class="form-control" name="address_detail" id="address_detail">
								<div class="invalid-feedback">Please enter a valid email
									address for shipping updates.</div>
							</div>

							<script
								src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
							<script>
								function address_click() {
									new daum.Postcode(
											{
												oncomplete : function(data) {
													// 선택시 입력값 세팅
													document
															.getElementById("address_kakao").value = data.address; // 주소 넣기
													// 상세입력 포커싱, 만약 input[name=address_detail] 존재 시
													var addressDetail = document
															.querySelector("input[name=address_detail]");
													if (addressDetail) {
														addressDetail.focus();
													}
												}
											}).open();
								}
							</script>

							<div class="mb-3">
								<label for="front_pw">공동 현관 비밀번호</label><input type="checkbox"
									id="front_pw_checkbox"> <input type="text"
									class="form-control" name="front_pw" id="front_pw_input"
									placeholder="" disabled>
								<div class="invalid-feedback">Please enter your shipping
									front pw.</div>
							</div>
							<script>
								document.addEventListener("DOMContentLoaded", function() {
									var checkbox = document.getElementById("front_pw_checkbox");
									var inputField = document.getElementById("front_pw_input");
									checkbox.addEventListener("change", function() {
										if (this.checked) {
											inputField.disabled = false;
										} else {
											inputField.disabled = true;
											inputField.value = '';
										}
									});
								});
							</script>
							<div class="shipList-box">
								<input type="button" value="등록" onclick="createList();"
									class="custom-button">
							</div>
							<br>
						</form>
						<script>
							function createList() {
								const form = document.createList_form;
								if (!form.ship_alias.value) {
									alert("별칭을 입력하세요.");
									form.ship_alias.focus();
								} else if (!form.ship_name.value) {
									alert("이름을 입력하세요.");
									form.ship_name.focus();
								} else if (!form.phone_number.value) {
									alert("연락처를 입력하세요.");
									form.phone_number.focus();
								} else if (!form.address_kakao.value) {
									alert("주소를 입력하세요.");
									form.address_kakao.focus();
								} else if (!form.address_detail.value) {
									alert("상세주소를 입력하세요.");
									form.address_detail.focus();
								} else {
									form.submit();
								}
							}
						</script>
						<br>
						<div class="col-12 d-flex shopping-box">
							<a href="/ship/shipList" class="ml-auto btn hvr-hover">목록 이동</a>
						</div>
						<hr class="my-1">
						<br>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End shipListCreate -->

	<!-- Start footer  -->
	<%@ include file="../include/footer.jsp"%>

</body>

</html>