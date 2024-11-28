<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.project.user.dao.UserDao" %>
<%@ page import="com.project.util.SHA256" %>
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
<title>꺼냉 회원가입</title>
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
                <form name="create_user_account" action="/user/CreateEnd" method="post">
                    <div class="create_form_group">
                        <h1 class="create_title">회원가입</h1>
                        <label for="create_id">아이디(필수)</label>
                        <div id="idCheckMessage"></div>
                        <input type="text" name="create_id" class="form-control" placeholder="아이디를 입력하세요">
                        <input type="button" class="form-control" onclick="checkDuplicateId()" value="아이디 중복확인">
                    </div>
                    <div class="create_form_group">
                        <label for="create_pw">비밀번호(필수)</label>
                        <input type="password" name="create_pw" class="form-control" placeholder="비밀번호를 입력하세요">
                    </div>
                    <div class="create_form_group">
                        <label for="create_pw">비밀번호 확인(필수)</label>
                        <input type="password" name="create_pw_check" class="form-control" placeholder="비밀번호를 확인해주세요">
                    </div>
                    <div class="create_form_group">
                        <label for="create_name">이름(필수)</label>
                        <input type="text" name="create_name" class="form-control" placeholder="이름을 입력해주세요">
                    </div>
                    <div class="create_form_group">
                        <label for="create_birth">생년월일을 입력해주세요(필수)</label>
                        <input type="text" name="create_birth" class="form-control" placeholder="생년월일 8자리">
                    </div>
                    <div class="create_form_group">
                        <label for="create_email">이메일을 입력해주세요(필수)</label>
                        <input type="email" name="create_email" class="form-control" placeholder="꺼냉@kernang.com">
                    </div>
                    <div class="create_form_group">
                        <label for="create_address">주소를 입력해주세요(필수)</label>
                        <input type="text" id="create_address" name="create_address" class="form-control" readonly>
                        <input type="text" name="address_detail" class="form-control" placeholder="상세주소를 입력하세요">
                    </div>
                    <div class="create_form_group">
                        <label for="create_mobile">연락처를 입력해주세요</label>
                        <input type="text" name="create_mobile" class="form-control" placeholder="전화번호를 입력하세요(필수)">
                        <input type="text" name="create_phone" class="form-control" placeholder="전화번호를 입력하세요(선택)">
                    </div>
                    <input type="button" class="create_user_btn" onclick="createUserForm();" value="회원가입">
                    <p class="already_user">이미 회원이신가요? <a class="re_login" href="login.jsp">로그인</a></p>
                </form>
            </div>
        </div>
    </div>

 	<script type="text/javascript">
		 
    	let check_flag = 'N';
        function createUserForm() {
            const form = document.create_user_account;
            if (!form.create_id.value) {
                alert("아이디를 입력하세요.");
                form.create_id.focus();
            } else if (check_flag !== 'Y') {
                alert("아이디 중복확인을 해주세요.");
            } else if (!form.create_pw.value) {
                alert("비밀번호를 입력하세요.");
                form.create_pw.focus();
            } else if (!form.create_pw_check.value) {
                alert("비밀번호 확인을 입력하세요.");
                form.create_pw_check.focus();
            } else if (form.create_pw.value !== form.create_pw_check.value) {
                alert("비밀번호가 일치하는지 확인하세요.");
                form.create_pw_check.focus();
            } else if (!form.create_name.value) {
                alert("이름을 입력하세요.");
                form.create_name.focus();
            } else if (!form.create_birth.value) {
                alert("생년월일을 입력하세요.");
                form.create_birth.focus();
            } else if (!form.create_email.value) {
                alert("이메일을 입력하세요.");
                form.create_email.focus();
            } else if (!form.create_address.value) {
                alert("주소를 입력하세요.");
                form.create_address.focus();
            } else if (!form.address_detail.value) {
                alert("상세주소를 입력하세요.");
                form.address_detail.focus();
            } else if (!form.create_mobile.value) {
                alert("핸드폰 번호를 입력하세요.");
                form.create_mobile.focus();
            } else {
                form.submit();
            }
        }
        /*중복확인 Ajax*/
        function checkDuplicateId() {
            const id = document.querySelector('input[name="create_id"]').value.trim();
            if (!id) {
                alert("아이디를 입력하세요.");
                return;
            }
           
            const formData = new FormData();
            console.log(id);
            formData.append('create_id', id);
            const xhr = new XMLHttpRequest();
            xhr.open("POST", "/user/CheckDuplicateId");
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        const response = xhr.responseText;
                        if (response === "duplicate") {
                            document.getElementById("idCheckMessage").innerHTML = "<span style='color:red;'>이미 사용 중인 아이디입니다.</span>";
                            check_flag='N';
                        } else {
                            document.getElementById("idCheckMessage").innerHTML = "<span style='color:green;'>사용 가능한 아이디입니다.</span>";
                            check_flag='Y';
                        }
                    } else {
                        alert("오류가 발생했습니다. 상태 코드: " + xhr.status);
                    }
                } 
                console.log(xhr.responseText);
            };
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
            xhr.send("create_id="+id);
        }  
        </script>

    
    
    
	<script>
	/* 주소인증 API */
		window.onload = function(){
    		document.getElementById("create_address").addEventListener("click", function(){ 
        		new daum.Postcode({
            		oncomplete: function(data) { 
                		document.getElementById("create_address").value = data.address; 
                		document.querySelector("input[name=address_detail]").focus(); 
            		}
        		}).open();
    		});
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