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
    <title>상품 페이지</title>
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

<link rel="stylesheet" href="path/to/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="path/to/font-awesome/css/all.min.css">

</head>
<body>

<%@ include file="../include/nav.jsp" %>

<div class="container">
    

                    <div class="row">
                        <%@ page import="com.gn.product_admin.vo.Product_admin, com.project.user.vo.User, java.util.*" %>
                                
                        <%
                            List<Product_admin> list = (List<Product_admin>) request.getAttribute("products");
                            if (!list.isEmpty()) {
                                for (int i = 0; i < list.size(); i++) {
                                    // 현재 로그인한 사용자 정보 가져오기
                                    User userLogin = (User) session.getAttribute("user");
                                    String userNo = (userLogin != null) ? String.valueOf(userLogin.getUser_no()) : "";
                        %>
                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                            <div class="products-single fix">
                                <div class="box-img-hover">
                                    <div class="type-lb">
                                    </div>
                                    <img src="../../upload/<%= list.get(i).getProd_revise_image() %>" alt="상품 이미지"  name="product_img" height="350rem" width="350rem">
                                    <div class="mask-icon">
                                        <a href="#" onclick="addToCart(<%= list.get(i).getProd_no() %>, 1, '<%= userNo %>')" class="cart">장바구니에 추가</a>
                                    </div>
                                </div>
                                <div class="why-text">
                                    <h4><%= list.get(i).getProd_name() %></h4>
                                    <h5><%= list.get(i).getProd_price() %>원</h5>
                                </div>
                            </div>
                        </div>
                        <% 
                                } // end for
                            } // end if
                        %>
                    </div>
                </div>

<script src="path/to/jquery.min.js"></script>
<script src="path/to/bootstrap/js/bootstrap.min.js"></script>
<script src="path/to/font-awesome/js/all.min.js"></script>

<script>
    function addToCart(productNo, quantity, userNo) {
        if (userNo === '') {
            alert('장바구니에 상품을 추가하려면 먼저 로그인하세요.');
            return;
        }
        
        var form = document.createElement('form');
        form.setAttribute('method', 'post');
        form.setAttribute('action', '/Cart/cartCreate');

        var productNoField = document.createElement('input');
        productNoField.setAttribute('type', 'hidden');
        productNoField.setAttribute('name', 'product_no');
        productNoField.setAttribute('value', productNo);
        form.appendChild(productNoField);

        var quantityField = document.createElement('input');
        quantityField.setAttribute('type', 'hidden');
        quantityField.setAttribute('name', 'quantity');
        quantityField.setAttribute('value', quantity);
        form.appendChild(quantityField);

        var userNoField = document.createElement('input');
        userNoField.setAttribute('type', 'hidden');
        userNoField.setAttribute('name', 'user_no');
        userNoField.setAttribute('value', userNo);
        form.appendChild(userNoField);

        document.body.appendChild(form);
        form.submit();
    }
</script>
    <!-- Start copyright  -->
    <div class="footer-copyrigt"><%@ include file = "../include/footer.jsp"%>
        <p class="footer-company">All Rights Reserved. &copy; 2018 <a href="#">ThewayShop</a> Design By :
            <a href="https://jsp.design/">jsp design</a></p>
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
    <script src="../../js/jquery-ui.js"></script>
    <script src="../../js/jquery.nicescroll.min.js"></script>
    <script src="../../js/form-validator.min.js"></script>
    <script src="../../js/contact-form-script.js"></script>
</body>

</html>