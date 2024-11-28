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
                <h2>주문서</h2>
            </div>
        </div>
    </div>
</div>
<!-- End All Title Box -->

<!-- Start cancel  -->
<%@ page import="com.project.user.vo.User, java.util.*" %>
<%@ page import="com.gn.product_admin.vo.Product_admin, com.gn.order_admin.vo.Buy, com.gn.order_admin.vo.Shiplist" %>

<div class="list-box-main">
    <div class="container">
        <div class="title-list">
            <h1>결제 취소</h1>
        </div>
    	<div class="container2" style="text-align: center">
	        <div class="point_views_div" style = "font-size: xx-large;">
	            <label for="point_views"><b>포인트 취소 금액</b></label>
	            <% 
	            User u = (User) session.getAttribute("user");
	            String orderNo = (String) request.getAttribute("order_no");
	            List<Map<String, Object>> list = (List<Map<String, Object>>) request.getAttribute("resultOrderInfo");
	            int totalCancelAmount = 0;
	            for (int i = 0; i < list.size(); i++) {
	                Map<String, Object> item = list.get(i);
	                int price = ((Number) item.get("상품가격")).intValue();
	                int quantity = ((Number) item.get("구매수량")).intValue();
	                int cancelAmount = price * quantity;
	                totalCancelAmount += cancelAmount;
	            }
	            %>
	            <input type="text" id="point_views" disabled="disabled" value="<%= totalCancelAmount %>" style="text-align: center">
	        </div>
       		<br>
	        <div class="pay_text"><b>
	            ⁜ 진행시 전체 취소가 이루어집니다.<br>
	            일부 상품만 구매하기를 원하신다면 재주문을 해주세요.</b>
	        </div>
	        <br>
	        <div class="col-12 d-flex justify-content-center shopping-box">
			    <div class="confirm_div1">
			        <form action="/order/cancelPointEnd" method="post">
			            <input type="hidden" id="user_no" name="user_no" value="<%= u.getUser_no() %>">
			            <input type="hidden" id="order_no" name="order_no" value="<%= orderNo %>">
			            <input type="hidden" name="cancel_amount" value="<%= totalCancelAmount %>">
			            <button type="submit" class="btn btn-primary">네</button>
			        </form>
			    </div>
			    <div class="confirm_div2 ml-2">
			        <button type="button" class="btn btn-secondary" onclick="window.history.back();">아니요</button>
			    </div>
			</div>
		</div>
	</div>
</div>
<!-- End cancel -->

<!-- Start footer  -->
<%@ include file="../include/footer.jsp" %>

</body>
</html>