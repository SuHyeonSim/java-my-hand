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
<title>장바구니</title>
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

	<%@ include file="../include/nav.jsp" %>

    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>장바구니</h2>
                </div>
            </div>
        </div>
    </div>

    <!-- Start Cart  -->
    <br>
    <div class="wishlist-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
					<div class="col-12 d-flex shopping-box">
				        <a href="/ship/shipList" class="ml-auto btn hvr-hover" style="background-color: pink ">배송지 관리</a>
				    </div>
    			</div>
    		</div>
    	</div>
    </div>

<div class="container" >

</div>
<br>
<div class="container" style="text-align: left">
    <div class="all-select-box">
        <input class="btn btn-primary" value="전체 선택" type="button" onclick="selectAll(true)">
        <input class="btn btn-secondary" value="전체 선택 해제" type="button" onclick="selectAll(false)">
        <input class="btn btn-warning" value="선택 삭제" type="button" onclick="submitDeleteForm('selected')">
        <input class="btn btn-danger" value="전체 삭제" type="button" onclick="submitDeleteForm('all')">
    </div>
</div>

<div class="cart-box-main2">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="table-main table-responsive">
                    <form id="updateForm" action="/Cart/updateCart" method="post">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>선택</th>
                                    <th>이미지</th>
                                    <th>상품명</th>
                                    <th>가격</th>
                                    <th>수량</th>
                                    <th>총 금액</th>
                                    <th>수량 수정</th>
                                </tr>
                            </thead>
                            <tbody>
                            
                                <%@ page import="com.project.user.vo.User, com.project.user.vo.Cart, java.util.*"%>

                                <% User userLogin = (User) session.getAttribute("user");
                                if (userLogin == null) {
                                    response.sendRedirect("/login.jsp");
                                    return;
                                }
                                %>
                                <input type="hidden" name="user_no" value="<%= user.getUser_no()%>">
                                <%
                                    List<Cart> cart = (List<Cart>) request.getAttribute("cartLists");
                               		if (cart != null && !cart.isEmpty()) {
                                        for (int i = 0; i < cart.size(); i++) {
                                %>
					            <tr>
					                <td class="item_checkBox">
					                    <input type="checkbox" id="check<%= i %>" name="item_check" value="<%= cart.get(i).getProd_no() %>" onchange="updateTotals()">
					                    <label for="check<%= i %>"></label>
					                </td>
					                <td class="thumbnail-img">
					                    <img class="img-fluid" src="../../upload/<%= cart.get(i).getProd_image() %>" alt="상품 이미지" />
					                </td>
					                <td class="name-pr">
					                    <label><%= cart.get(i).getProd_name() %></label>
					                </td>
					                <td class="price-pr">
					                    <label class="price"><%= cart.get(i).getProd_price() %></label>원
					                </td>
					                <td class="quantity-box">
					                    <input type="number" size="4" name="quantities" value="<%= cart.get(i).getCart_quantity() %>" min="0" max="<%= cart.get(i).getProd_inventory() %>" step="1" class="c-input-text qty text" onkeydown="return false" onpaste="return false" oninput="return false">
					                    <input type="hidden" name="prod_nos" value="<%= cart.get(i).getProd_no() %>">
					                </td>
					                <td class="total-pr">
					                    <label class="total"><%= cart.get(i).getProd_price() * cart.get(i).getCart_quantity() %></label>원
					                </td>
					                <td class="remove-pr">
					                    <a href="javascript:submitUpdateForm('<%= cart.get(i).getProd_no() %>')">
					                        <svg width="25px" height="25px" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
					                            <path d="M441 58.9L453.1 71c9.4 9.4 9.4 24.6 0 33.9L424 134.1 377.9 88 407 58.9c9.4-9.4 24.6-9.4 33.9 0zM209.8 256.2L344 121.9 390.1 168 255.8 302.2c-2.9 2.9-6.5 5-10.4 6.1l-58.5 16.7 16.7-58.5c1.1-3.9 3.2-7.5 6.1-10.4zM373.1 25L175.8 222.2c-8.7 8.7-15 19.4-18.3 31.1l-28.6 100c-2.4 8.4-.1 17.4 6.1 23.6s15.2 8.5 23.6 6.1l100-28.6c11.8-3.4 22.5-9.7 31.1-18.3L487 138.9c28.1-28.1 28.1-73.7 0-101.8L474.9 25C446.8-3.1 401.2-3.1 373.1 25zM88 64C39.4 64 0 103.4 0 152V424c0 48.6 39.4 88 88 88H360c48.6 0 88-39.4 88-88V312c0-13.3-10.7-24-24-24s-24 10.7-24 24V424c0 22.1-17.9 40-40 40H88c-22.1 0-40-17.9-40-40V152c0-22.1 17.9-40 40-40H200c13.3 0 24-10.7 24-24s-10.7-24-24-24H88z"/>
					                        </svg>
					                    </a>
					                </td>
					            </tr>

                                <% 
                                        } 
                                    } else {
                                %>
                                <tr>
                                    <td colspan="7">장바구니가 비어 있습니다.</td>
                                </tr>
                                <% 
                                    } 
                                %>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>

        <form action="/order/checkOut" method="post" id="orderForm">
        <div class="row my-5">
            <div class="col-lg-8 col-sm-12"></div>
            <div class="col-lg-4 col-sm-12">
                <div class="order-box">
                    <hr>
                    <div class="d-flex gr-total">
                        <h5>주문 총 금액</h5>
                        <div class="ml-auto h5">
                        <span id="totalPrice">0</span>원
                        <input type="hidden" name="totalPrice" id="totalPriceInput"></div>
                    </div>
                    <div class="d-flex">
                        <h4>주문 총 수량</h4>
                        <div class="ml-auto font-weight-bold">
                        <span id="totalQuantity">0</span>개
                        <input type="hidden" name="totalQuantity" id="totalQuantityInput">
                        </div>
                    </div>
                    <div class="d-flex">
                        <h4>배송비</h4>
                        <div class="ml-auto font-weight-bold">무료</div>
                    </div>
                    <hr class="my-1">
                </div>
            </div>
            <input type="hidden" name="prodNos" id="prodNos">
            <input type="hidden" name="prodQuantity" id="prodQuantity">
		    
		    
	            <div class="col-12 d-flex shopping-box">
                      <a href="javascript:submitOrderForm()" class="ml-auto btn hvr-hover">주문하기</a>
    	        </div>
                
        </div>
                </form>
    </div>
    </div>

	<script>
	function updateTotals() {
	    var totalPrice = 0;
	    var totalQuantity = 0;
	
	    document.querySelectorAll('input[name="item_check"]:checked').forEach(function(checkbox) {
	        var row = checkbox.closest('tr');
	        var price = parseInt(row.querySelector('.price').textContent);
	        var quantity = parseInt(row.querySelector('.qty').value);
	        totalPrice += price * quantity;
	        totalQuantity += quantity;
	    });
	
	    document.getElementById('totalPrice').textContent = totalPrice;
	    document.getElementById('totalQuantity').textContent = totalQuantity;
	}
	
	
	document.querySelectorAll('.qty').forEach(function(input) {
	    input.addEventListener('keydown', function(event) {
	        event.preventDefault();
	    });
	    input.addEventListener('paste', function(event) {
	        event.preventDefault();
	    });
	    input.addEventListener('input', function(event) {
	        event.preventDefault();
	    });
	});
	
	
	function selectAll(isChecked) {
	    document.querySelectorAll('input[name="item_check"]').forEach(function(checkbox) {
	        checkbox.checked = isChecked;
	    });
	    updateTotals();
	}
	
	function submitUpdateForm(prodNo) {
	    var form = document.getElementById('updateForm');
	    var quantities = form.querySelectorAll('input[name="quantities"]');
	    var prodNos = form.querySelectorAll('input[name="prod_nos"]');
	    
	    for (var i = 0; i < prodNos.length; i++) {
	        if (prodNos[i].value == prodNo) {
	            quantities[i].setAttribute('name', 'cart_quantity');
	        } else {
	            quantities[i].removeAttribute('name');
	        }
	    }
	
	    var prodNoInput = document.createElement('input');
	    prodNoInput.setAttribute('type', 'hidden');
	    prodNoInput.setAttribute('name', 'prod_no');
	    prodNoInput.setAttribute('value', prodNo);
	    form.appendChild(prodNoInput);
	
	    form.submit();
	}
	
	
	function submitDeleteForm(action) {
	    var form = document.getElementById('updateForm');
	    var actionInput = document.createElement('input');
	    actionInput.setAttribute('type', 'hidden');
	    actionInput.setAttribute('name', 'action');
	    actionInput.setAttribute('value', action);
	    form.appendChild(actionInput);
	
	    if (action === 'all') {
	        var items = document.querySelectorAll('input[name="item_check"]');
	        if (items.length === 0) {
	            alert('삭제할 항목이 없습니다.');
	            return;
	        }
	    }
	
	    if (action === 'selected') {
	        var checkedItems = document.querySelectorAll('input[name="item_check"]:checked');
	        if (checkedItems.length === 0) {
	            alert('삭제할 항목을 선택하세요.');
	            return;
	        }
	    }
	
	    form.action = '/Cart/deleteCart';
	    form.submit();
	}
	
	
	function submitOrderForm() {
	    var checkedItems = document.querySelectorAll('input[name="item_check"]:checked');
	    if (checkedItems.length === 0) {
	        alert('주문할 항목을 선택하세요.');
	        return;
	    }
	
	    var prodNos = [];
		var prodQuantity = [];
	    var totalPrice = 0;
	    var totalQuantity = 0;
	    
	    checkedItems.forEach(function(item) {
	        var row = item.closest('tr');
	        var price = parseInt(row.querySelector('.price').textContent);
	        var quantity = parseInt(row.querySelector('.qty').value);
	        totalPrice += price * quantity;
	        totalQuantity += quantity;
	        prodNos.push(item.value);
	    	prodQuantity.push(quantity);
	    });
	
	    document.getElementById('prodNos').value = prodNos.join(',');
	    document.getElementById('prodQuantity').value = prodQuantity.join(',');
	    document.getElementById('totalPriceInput').value = totalPrice;
	    document.getElementById('totalQuantityInput').value = totalQuantity;
	    document.getElementById('orderForm').submit();
	}
	
	
	
	</script>
	<!-- End Cart -->

	<!-- Start footer  -->
	<%@ include file="../include/footer.jsp" %>

</body>

</html>