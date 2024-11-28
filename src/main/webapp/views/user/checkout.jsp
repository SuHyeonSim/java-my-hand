<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">
<title>주문서</title>
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

	<%@ include file="../include/nav.jsp" %>

    <!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>주문서 작성</h2>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Order sheet  -->
    
<%@ page import="com.project.user.vo.User, com.project.user.vo.Cart, com.project.user.vo.ShipList, java.util.*"%>

<% 
    User userLogin = (User) session.getAttribute("user"); 
    int totalPrice = (Integer) request.getAttribute("totalPrice");
    List<ShipList> shipList = (List<ShipList>) request.getAttribute("shipList");
    String[] prodNos = (String[]) request.getAttribute("prodNos");
    String[] prodQuantity = (String[]) request.getAttribute("prodQuantity");
%>

<form id="checkoutForm" method="post">
<% for (String item : prodNos) { %>
    <input type="hidden" name="prodNos" value="<%= item %>">
<% } %>
<% for (String quantity : prodQuantity) { %>
    <input type="hidden" name="prodQuantity" value="<%= quantity %>">
<% } %>

<input type="hidden" id="user_no" name="user_no" value="<%= user.getUser_no() %>">
<input type="hidden" id="total_price" name="total_price" value="<%= totalPrice %>">

    <div class="cart-box-main">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="checkout-address">
                        <div class="title-left">
                            <h3>주문 정보 입력란</h3>
                        </div>
                        <div class="mb-3">
                            <label for="username">주문자 성함</label>
                            <div class="input-group">
                                <input type="text" class="form-control" id="username" value="<%= user.getUser_name() %>" readonly>
                                <div class="invalid-feedback" style="width: 100%;">Your username is required.</div>
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="phone_number">주문자 핸드폰 번호</label>
                            <input type="text" class="form-control" id="phone_number" value="<%= user.getUser_mobile() %>" readonly>
                            <div class="invalid-feedback">Please enter your phone number.</div>
                        </div>
                        <div class="mb-3">
                            <label for="email">주문자 이메일</label>
                            <input type="email" class="form-control" id="email" value="<%= user.getUser_email() %>" readonly>
                            <div class="invalid-feedback">Please enter a valid email address for shipping updates.</div>
                        </div>
                        <hr class="my-1">
                        <br>
                        <div class="mb-3">
                            <label for="ship_no">배송지 별칭</label><a href="/ship/shipList" id="shipLink" class="a_href btn btn-primary btn-sm">배송지 관리</a>
                            <select class="wide w-100" id="ship_no" name="ship_no">
                                <option value="option0" data-display="Select">선택</option>
                                <% for (ShipList ship : shipList) { %>
                                    <option value="<%= ship.getShip_no() %>"><%= ship.getShip_alias() %></option>
                                <% } %>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="ship_comment">배송시 요청 사항</label>
                            <select class="wide w-100" id="ship_comment" name="order_comment" onchange="toggleCustomComment()">
                                <option value="option0">없음</option>
                                <option value="문 앞에 두고 가주세요.">문 앞에 두고 가주세요.</option>
                                <option value="경비실에 맡겨 주세요.">경비실에 맡겨 주세요.</option>
                                <option value="배송 전 연락 주세요.">배송 전 연락 주세요.</option>
                                <option value="직접 작성">직접 작성</option>
                            </select>
                            <input type="text" class="form-control" id="custom_comment" name="custom_comment" placeholder="직접 입력" style="display: none;">
                        </div>
                        <hr class="mb-1">
                    </div>
                </div>
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="order-box">
								<div class="title-left">
								    <h3>결제 금액</h3>
								</div>
								<div class="d-flex">
								    <h4>상품 금액</h4>
								    <div class="ml-auto font-weight-bold" id="totalPrice" name="totalPrice"><%= totalPrice %></div>
								</div>
								<div class="d-flex">
								    <h4>배송비</h4>
								    <div class="ml-auto font-weight-bold" id="deliveryFee">2500</div>
								</div>
								<div class="d-flex">
								    <div class="ml-auto font-weight-bold">
								        <label for="myPoint">보유 포인트</label>
								        <input type="number" id="myPoint" name="myPoint" value="<%= user.getUser_point() %>" readonly>
								    </div>
								    <div class="ml-auto font-weight-bold">
								        <label for="usePoint">사용 포인트</label>
								        <input type="number" id="usePoint" name="usePoint" oninput="validateAndCalculate()">
								    </div>
								</div>
								<hr>
								<div class="d-flex gr-total">
								    <h5>최종 결제 금액</h5>
								    <div class="ml-auto h5" id="finalAmount" name="finalAmount"><%= totalPrice + 2500 %></div>   <!-- 포인트 사용 전 처음에 보여줄 최종 결제 금액 -->
								</div>
							</div>
                                <hr>
                            </div>
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="order_check1" required>
                                <label class="custom-control-label" for="order_check1">[결제완료] 상태일 경우에만 주문 취소가 가능하며, 이에 동의합니다.</label>
                            </div>
                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="order_check2" required>
                                <label class="custom-control-label" for="order_check2">결제 전 주문정보를 확인하였으며 결제에 동의합니다.</label>
                            </div>
                            <div class="col-12 d-flex shopping-box">
                      			<button id="check_module" type="button">결제하기</button>
    	        			</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>

<!-- ajax js -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- iamport js -->
<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script>
	document.addEventListener('DOMContentLoaded', function() {
	    var shipLink = document.getElementById('shipLink');
	    shipLink.addEventListener('click', function(event) {
	        event.preventDefault();
	        var confirmResult = confirm("이 페이지를 벗어나면 장바구니를 다시 선택해야 합니다. 이동하시겠습니까?");
	        if (confirmResult) {
	            window.location.href = shipLink.href;
	        }
	    });
	});
	
    function toggleCustomComment() {
        var ship_comment = $('#ship_comment').val();
        if (ship_comment === '직접 작성') {
            $('#custom_comment').show().attr('name', 'order_comment');
            $('#ship_comment').removeAttr('name');
        } else {
            $('#custom_comment').hide().removeAttr('name');
            $('#ship_comment').attr('name', 'order_comment');
        }
    }
    
	// form 전송 시 값 설정
    function prepareOrderComment() {
        const commentSelect = document.getElementById("ship_comment").value;
        const customComment = document.getElementById("custom_comment").value;

        // "직접 작성" 선택 시 custom_comment 값을 order_comment에 추가
        const orderComment = (commentSelect === "직접 작성") ? customComment : commentSelect;

        return orderComment;
    }

    
    function validateForm() {
        var ship_no = document.getElementById('ship_no').value;
        var order_check1 = document.getElementById('order_check1').checked;
        var order_check2 = document.getElementById('order_check2').checked;

        if (ship_no === 'option0') {
            alert('배송지를 선택해주세요.');
            return false;
        }

        if (!order_check1 || !order_check2) {
            alert('체크박스를 모두 선택해주세요.');
            return false;
        }

        return true;
    }
    
    
    
    function validateAndCalculate() {
        const myPoint = parseInt(document.getElementById('myPoint').value, 10);  // 10진수 명시적 지정
        let usePoint = parseInt(document.getElementById('usePoint').value, 10) || 0;  // 값이 비어있을때 0 반환

        const totalPrice = parseInt("<%= totalPrice %>", 10);
        const deliveryFee = parseInt(document.getElementById('deliveryFee').innerText, 10);


        if (usePoint > myPoint) {
            alert("사용 포인트는 보유 포인트를 초과할 수 없습니다.");
            usePoint = myPoint;
        }

        if (usePoint > totalPrice) {
            alert("사용 포인트는 상품 금액을 초과할 수 없습니다.");
            usePoint = totalPrice;
        }

        document.getElementById('usePoint').value = usePoint;

        const finalAmount = totalPrice + deliveryFee - usePoint;

        document.getElementById('finalAmount').innerText = finalAmount;
    }
	
	
    /* iamport 결제 모듈 */
    $("#check_module").click(function () {
        if (validateForm()) {
    	var IMP = window.IMP;
    	IMP.init('imp84673356');  // 결제 고유번호
    	IMP.request_pay({
    		pg: 'html5_inicis', // inicis 결제 사용
    		pay_method: 'card',
    		merchant_uid: 'merchant_' + new Date().getTime(),
    		name: '꺼냉 주문/결제', //결제창에서 보여질 이름
            amount: $('#finalAmount').text(),
            buyer_email: $('#email').val(),
            buyer_name: $('#username').val(),
            buyer_tel: $('#phone_number').val(),
            buyer_addr: $('#ship_no').val(),
            buyer_postcode: '123-456',
            
    		}, function (rsp) {
    			console.log(rsp);
    			if (rsp.success) {
    				var msg = '결제가 완료되었습니다.';
    				msg += '고유ID : ' + rsp.imp_uid;
    				msg += '상점 거래ID : ' + rsp.merchant_uid;
    				msg += '결제 금액 : ' + rsp.paid_amount;
    				msg += '카드 승인번호 : ' + rsp.apply_num;
    			    // 'name' 속성이 'prodNos'인 모든 hidden input을 가져와서 배열 처리
    			    var prodNos = $("input[name='prodNos']").map(function() {
    			        return $(this).val();
    			    }).get();

    			    // 'name' 속성이 'prodQuantity'인 모든 hidden input을 가져와서 배열 처리
    			    var prodQuantities = $("input[name='prodQuantity']").map(function() {
    			        return $(this).val();
    			    }).get();
    			    
    				$.ajax({
                    	type : "POST",
                    	url : "/order/processCheckOut",
                        data: {
                            finalAmount: rsp.paid_amount,   // 실제 결제한 금액
                            imp_uid: rsp.imp_uid,
                            merchant_uid: rsp.merchant_uid,
                            user: $('#user_no').val(),
                            ship_no: $('#ship_no').val(),
                            order_comment: prepareOrderComment(), // 수정된 order_comment(+직접입력값) 전송
                            prodNos: prodNos.join(','),  // 배열을 쉼표로 구분된 문자열로 변환
                            prodQuantity: prodQuantities.join(','),  // 배열을 쉼표로 구분된 문자열로 변환
                            usePoint: $('#usePoint').val(),
                            totalPrice: $('#total_price').val() // 선택한 상품 금액
                        },
                        success: function(response) {
                            window.location.href = "/views/user/order-complete.jsp";
                        },
                        error: function(xhr, status, error) {
                        	window.location.href = "/views/user/order_fail.jsp";
                        }
                    	});
    				
    				} else {
    					var msg = '결제에 실패하였습니다.';
    					msg += '에러내용 : ' + rsp.error_msg;
    					}
    			
    			});
        	}
    	});
    </script>
    <!-- End Order sheet -->

    <!-- Start footer  -->
	<%@ include file="../include/footer.jsp" %>

</body>

</html>