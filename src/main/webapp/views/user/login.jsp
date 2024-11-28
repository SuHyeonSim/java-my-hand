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
	


<nav class="login_page">
    <div class="container_login">
        <div class="login-box_login">
            <h1 class="title_login">로그인</h1>
            <div class="group_login">
                <form id="loginForm" action="/user/loginEnd" method = "post">
                    <label for="user_id" class="label_login_id">아이디</label>
                    <input type="text" id="user_id" name="user_id" class="input_login" placeholder="아이디를 입력해주세요.">
                    <label for="user_pw" class="label_login_pw">비밀번호</label>
                    <input type="password" id="user_pw" name="user_pw" class="input_login" placeholder="비밀번호를 입력해주세요.">
                    <div class="login_buttons">
                        <input type="button" class="button_login" onclick="EnterUser()" value="로그인">
                        <button type="button" class="button_create_user" onclick="CreateUser()">회원가입</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</nav>

<script>
    function EnterUser() {
        const form = document.getElementById('loginForm');
        if (form.user_id.value === '') {
            alert('아이디를 입력하세요.');
            form.user_id.focus();
        } else if (form.user_pw.value === '') {
            alert('비밀번호를 입력하세요.');
            form.user_pw.focus();
        } else {
            form.submit(); 
        }
        
    }
    function CreateUser() {
        location.href = "/User/Agree"; 
    }
</script>
<%@ include file = "../include/footer.jsp"%>


</body>

</html>