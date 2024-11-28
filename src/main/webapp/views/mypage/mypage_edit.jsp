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
<link rel="stylesheet" href="../../css/style2.css">
<link rel="stylesheet" href="../../css/responsive.css">
<link rel="stylesheet" href="../../css/custom.css">
<link rel="stylesheet" href="../../css/login.css">
<link rel="stylesheet" href="../../css/search.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" integrity="sha512-..." crossorigin="anonymous" />
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
        
        
        <div class="col-lg-9">
            <h2 class="mt-5 mb-4">회원정보 수정</h2>
            <form action="/MyPage/EditEnd" method="post">
		        <input type="hidden" name="user_no" value="<%=user.getUser_no()%>">
                <!--<div class="form-group">
                    <label for="user_pw">현재 비밀번호</label>
                    <input type="password" class="form-control" id="user_pw" name="current_user_pw" required>
                </div>-->
                <div class="form-group">
                    <label for="user_pw">수정할 비밀번호</label>
                    <input type="password" class="form-control" id="user_pw" name="new_user_pw" required>
                </div>
                <div class="form-group">
                    <label for="user_pw">수정 비밀번호 확인</label>
                    <input type="password" class="form-control" id="user_pw" name="confirm_user_pw" required>
                </div>
                <div class="form-group">
                    <label for="user_birth">생년월일</label>
                    <input type="text" class="form-control" id="user_birth" name="user_birth" value="<%=user.getUser_birth()%>" required>
                </div>
                <div class="form-group">
                    <label for="user_name">이름</label>
                    <input type="text" class="form-control" id="user_name" name="user_name" value="<%=user.getUser_name()%>" required>
                </div>
                <div class="form-group">
                    <label for="user_address">주소</label>
                    <input type="text" class="form-control" id="user_address" name="user_address" value="<%=user.getUser_address()%>" readonly required>
                </div>
                <div class="form-group">
                    <label for="user_address_detail">상세주소</label>
                    <input type="text" class="form-control" id="user_address_detail" name="user_address_detail" value="<%=user.getUser_address_detail()%>" required>
                </div>
                <div class="form-group">
                    <label for="user_email">이메일</label>
                    <input type="email" class="form-control" id="user_email" name="user_email" value="<%=user.getUser_email()%>" required>
                </div>
                <div class="form-group">
                    <label for="user_mobile">모바일 번호</label>
                    <input type="text" class="form-control" id="user_mobile" name="user_mobile" value="<%=user.getUser_mobile()%>" required>
                </div>
                <div class="form-group">
                    <label for="user_phone">전화번호</label>
                    <input type="text" class="form-control" id="user_phone" name="user_phone" value="<%=user.getUser_phone()%>">
                </div>
                <button type="submit" class="btn btn-primary"onclick="updateUserForm()">정보 수정</button>
            </form><br>
                <button style = "color : black; background-color:g; margin-left:1300px;" type="submit" class="btn btn-primary"onclick="deleteUserForm()">회원 탈퇴</button>
        </div>
    </div>
</div>
	<script>
	/* 주소인증 API */
function updateUserForm() {
    const form = document.update_user_account;
    if(!form.new_user_pw.value) {
        alert("수정할 비밀번호를 입력하세요.");
        form.new_user_pw.focus();
    } else if (!form.confirm_user_pw.value) {
        alert("수정 비밀번호 확인을 입력하세요.");
        form.confirm_user_pw.focus();
    } else if (form.new_user_pw.value !== form.confirm_user_pw.value) {
        alert("수정할 비밀번호와 확인 비밀번호가 일치하는지 확인하세요.");
        form.confirm_user_pw.focus();
    } else if (!form.user_name.value) {
        alert("이름을 입력하세요.");
        form.user_name.focus();
    } else if (!form.user_birth.value) {
        alert("생년월일을 입력하세요.");
        form.user_birth.focus();
    } else if (!form.user_email.value) {
        alert("이메일을 입력하세요.");
        form.user_email.focus();
    } else if (!form.user_address.value) {
        alert("주소를 입력하세요.");
        form.user_address.focus();
    } else if (!form.user_address_detail.value) {
        alert("상세주소를 입력하세요.");
        form.user_address_detail.focus();
    } else if (!form.user_mobile.value) {
        alert("핸드폰 번호를 입력하세요.");
        form.user_mobile.focus();
    } else {
        form.submit();
    }
}

function deleteUserForm(userNo) {
    var result = confirm("가지고 있던 적립금이 사라질 수 있습니다. 정말로 탈퇴하시겠습니까?");
    if(result){
    	let url = '/deleteEnd?user_no='+userNo;
    	open(url,'_self');
    }else{
    	alert("삭제를 취소합니다.");
    }
}    
        
        
window.onload = function(){
	document.getElementById("user_address").addEventListener("click", function(){ 
		new daum.Postcode({
			oncomplete: function(data) { 
				document.getElementById("user_address").value = data.address; 
    			document.querySelector("input[name=user_address_detail]").focus(); 
    		}
    	}).open();
    });
}
	</script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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
