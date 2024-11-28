<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>개인정보동의페이지</title>
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
<link rel="stylesheet" href="../../css/info_agree.css">

</head>
<body>
	<%@ include file = "../include/nav.jsp"%>


	<!-- Start Login -->
<nav class="info_agree">
        <div class="container_agree">
            <div class="login_box_agree">
                <h1 class="title_agree">개인정보 수집 및 이용 동의</h1>
                <p>꺼냉을 이용해 주셔서 감사합니다.</p>
                <p>꺼냉은 개인정보 보호법 등 관련 법령을 준수하여 이용자의 개인정보를 보호하고 있습니다.</p>
        		<p>아래의 개인정보 수집 및 이용에 대한 내용을 잘 읽고, 동의하신다면 "동의합니다" 버튼을 클릭해 주세요.</p>
        		<div class="textbox">
        		<div class="textbox_inner">
        			<h2>개인정보 수집 및 이용 동의</h2>
        			<p>회사는 이용자의 개인정보 보호를 매우 중요시하며, 관련 법령을 준수하고 있습니다. 이에 따라 회원가입 또는 서비스 이용 시 아래와 같은 개인정보를 수집하고 있습니다.</p>
        			<ul>
			            <li><strong>수집하는 개인정보의 항목 및 수집방법</strong></li>
           				<li>필수 수집 항목: 성명, 생년월일, 주소, 전화번호, 이메일 주소</li>
            			<li>선택 수집 항목: 관심사, 기타 서비스 이용 내역</li>
            			<li>위 정보는 회원가입, 서비스 제공, 문의 처리 및 고객 지원 목적으로 수집되며, 이용자의 별도 동의 없이는 목적 외 사용이나 타인에게 제공되지 않습니다.</li>
        			</ul>
				        <p><strong>개인정보의 이용 목적</strong></p>
        			<ul>
            			<li>회원 관리 및 서비스 제공</li>
            			<li>서비스 개선 및 신규 서비스 개발</li>
            			<li>이벤트 및 마케팅 활동에 참여 안내</li>
            			<li>적립금 적립 및 사용자 혜택 제공</li>
        			</ul>	
        			<p><strong>개인정보의 보유 및 이용 기간</strong></p>
        			<p>회사는 이용자의 개인정보를 수집 및 이용 목적이 달성된 후에는 지체 없이 파기합니다. 단, 관련 법령에 의거하여 일정 기간 동안 보존할 수 있습니다.</p> 
	        		<p><strong>동의 거부 권리</strong></p>
   		    		<p>이용자는 개인정보 제공에 대한 동의를 거부할 권리가 있습니다. 다만, 필수 항목에 대한 동의를 거부할 경우 회원가입 및 일부 서비스 이용이 제한될 수 있습니다.</p>
	        		<p>위 내용을 충분히 숙지하신 후 동의 여부를 결정해 주시기 바랍니다. 추가적인 문의나 도움이 필요하시면 언제든지 문의해 주세요.</p>
    				</div>
    				</div>
                <div class="group_agree">
                    <form id="agreeForm" action="#">
                        <label for="agreeCheckbox" class="label_agree">개인정보 수집 및 이용에 동의합니다.</label>
                        <input type="checkbox" id="agreeCheckbox" name="agreeCheckbox" class="input_agree" required>
                        <div class="agree_buttons">
                            <button type="button" class="button_agree" onclick="Agree()">동의합니다</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </nav>
    <script>
    function Agree() {
        var checkBox = document.getElementById("agreeCheckbox");
        if (checkBox.checked == true) {
            alert("개인정보 수집 및 이용에 동의하셨습니다.");
            location.href = "/User/Create";
        } else {
            alert("개인정보 수집 및 이용에 동의해 주세요.");
        }
    }

    </script>
	<footer>
		<div class="footer-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Business Time</h3>
							<ul class="list-time">
								<li>Monday - Friday: 08.00am to 05.00pm</li>
								<li>Saturday: 10.00am to 08.00pm</li>
								<li>Sunday: <span>Closed</span></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Newsletter</h3>
							<form class="newsletter-box">
								<div class="form-group">
									<input class="" type="email" name="Email"
										placeholder="Email Address*" /> <i class="fa fa-envelope"></i>
								</div>
								<button class="btn hvr-hover" type="submit">Submit</button>
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-top-box">
							<h3>Social Media</h3>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
							<ul>
								<li><a href="#"><i class="fab fa-facebook"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-twitter"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-linkedin"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-google-plus"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-pinterest-p"
										aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fab fa-whatsapp"
										aria-hidden="true"></i></a></li>
							</ul>
						</div>
					</div>
				</div>
				<hr>
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-widget">
							<h4>About Freshshop</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua. Ut enim ad minim veniam, quis nostrud exercitation
								ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit,
								sed do eiusmod tempor incididunt ut labore et dolore magna
								aliqua.</p>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-link">
							<h4>Information</h4>
							<ul>
								<li><a href="#">About Us</a></li>
								<li><a href="#">Customer Service</a></li>
								<li><a href="#">Our Sitemap</a></li>
								<li><a href="#">Terms &amp; Conditions</a></li>
								<li><a href="#">Privacy Policy</a></li>
								<li><a href="#">Delivery Information</a></li>
							</ul>
						</div>
					</div>
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-link-contact">
							<h4>Contact Us</h4>
							<ul>
								<li>
									<p>
										<i class="fas fa-map-marker-alt"></i>Address: Michael I. Days
										3756 <br>Preston Street Wichita,<br> KS 67213
									</p>
								</li>
								<li>
									<p>
										<i class="fas fa-phone-square"></i>Phone: <a
											href="tel:+1-888705770">+1-888 705 770</a>
									</p>
								</li>
								<li>
									<p>
										<i class="fas fa-envelope"></i>Email: <a
											href="mailto:contactinfo@gmail.com">contactinfo@gmail.com</a>
									</p>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2024 <a href="#">ThewayShop</a> Design By
			: <a href="https://jsp.design/">jsp design</a>
		</p>
	</div>
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
	<script src="../../ㄴjs/custom.js"></script>
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