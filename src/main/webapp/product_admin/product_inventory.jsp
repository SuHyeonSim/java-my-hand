<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>제품 등록</title>
    <meta
      content="width=device-width, initial-scale=1.0, shrink-to-fit=no"
      name="viewport"
    />
    <link
      rel="icon"
      href="../assets/img/kaiadmin/favicon.ico"
      type="image/x-icon"
    />

    <!-- Fonts and icons -->
    <script src="../assets/js/plugin/webfont/webfont.min.js"></script>
    <script>
      WebFont.load({
        google: { families: ["Public Sans:300,400,500,600,700"] },
        custom: {
          families: [
            "Font Awesome 5 Solid",
            "Font Awesome 5 Regular",
            "Font Awesome 5 Brands",
            "simple-line-icons",
          ],
          urls: ["../assets/css/fonts.min.css"],
        },
        active: function () {
          sessionStorage.fonts = true;
        },
      });
    </script>

    <!-- CSS Files -->
    <link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="../assets/css/plugins.min.css" />
    <link rel="stylesheet" href="../assets/css/kaiadmin.min.css" />

    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link rel="stylesheet" href="../assets/css/demo.css" />
  </head>
  <body>
    <div class="wrapper">
      <!-- Sidebar -->
      <div class="sidebar" data-background-color="dark">
        <div class="sidebar-logo">
          <!-- Logo Header -->
          <div class="logo-header" data-background-color="dark">
            <a href="/Index" class="logo">
              <img
                src="../assets/img/kaiadmin/ProjectMainLogo.png"
                alt="navbar brand"
                class="navbar-brand"
                width="100px"
              />
            </a>
            <div class="nav-toggle">
              <button class="btn btn-toggle toggle-sidebar">
                <i class="gg-menu-right"></i>
              </button>
              <button class="btn btn-toggle sidenav-toggler">
                <i class="gg-menu-left"></i>
              </button>
            </div>
            <button class="topbar-toggler more">
              <i class="gg-more-vertical-alt"></i>
            </button>
          </div>
          <!-- End Logo Header -->
        </div>
        <div class="sidebar-wrapper scrollbar scrollbar-inner">
          <div class="sidebar-content">
            <ul class="nav nav-secondary">
              
              <li class="nav-section">
                <span class="sidebar-mini-icon">
                  <i class="fa fa-ellipsis-h"></i>
                </span>
                <h4 class="text-section">작업 목록</h4>
              </li>
              
              <li class="nav-item">
                <a data-bs-toggle="collapse" href="#product_admin">
                  <i class="fas fa-table"></i>
                  <p>상품관리</p>
                  <span class="caret"></span>
                </a>
                <div class="collapse" id="product_admin">
                  <ul class="nav nav-collapse">
                    <li>
                      <a href="../product_admin/product_add">
                        <span class="sub-item">제품 등록</span>
                      </a>
                    </li>
                    <li>
                      <a href="../product_admin/product_listUpdate">
                        <span class="sub-item">제품 목록</span>
                      </a>
                    </li>
                    <li>
                      <a href="../product_admin/product_listInventory">
                        <span class="sub-item">재고 입고</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="nav-item">
                <a data-bs-toggle="collapse" href="#order_admin">
                  <i class="fas fa-table"></i>
                  <p>주문내역 관리</p>
                  <span class="caret"></span>
                </a>
                <div class="collapse" id="order_admin">
                  <ul class="nav nav-collapse">
                    <li>
                      <a href="../product_admin/product_listSellCount">
                        <span class="sub-item">판매량 확인</span>
                      </a>
                    </li>
                    <li>
                      <a href="../order_admin/orderList">
                        <span class="sub-item">주문내역 확인</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>
              <li class="nav-item">
                <a data-bs-toggle="collapse" href="#inquiry_admin">
                  <i class="fas fa-table"></i>
                  <p>게시판 관리</p>
                  <span class="caret"></span>
                </a>
                <div class="collapse" id="inquiry_admin">
                  <ul class="nav nav-collapse">
                    <li>
                      <a href="../inquiry_admin/inquiry_adminInquiryList">
                        <span class="sub-item">문의사항 목록</span>
                      </a>
                    </li>
                    <li>
                      <a href="../notice_admin/notice_list">
                        <span class="sub-item">공지사항 목록</span>
                      </a>
                    </li>
                    <li>
                      <a href="../notice_admin/notice_make">
                        <span class="sub-item">공지사항 등록</span>
                      </a>
                    </li>
                  </ul>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </div>
      <!-- End Sidebar -->

      <div class="main-panel">
        <div class="main-header">
          <div class="main-header-logo">
            <!-- Logo Header -->
            <div class="logo-header" data-background-color="dark">
              <a href="../index.jsp" class="logo">
                <img
                  src="../assets/img/kaiadmin/logo_light.svg"
                  alt="navbar brand"
                  class="navbar-brand"
                  height="20"
                />
              </a>
              <div class="nav-toggle">
                <button class="btn btn-toggle toggle-sidebar">
                  <i class="gg-menu-right"></i>
                </button>
                <button class="btn btn-toggle sidenav-toggler">
                  <i class="gg-menu-left"></i>
                </button>
              </div>
              <button class="topbar-toggler more">
                <i class="gg-more-vertical-alt"></i>
              </button>
            </div>
            <!-- End Logo Header -->
          </div>
        </div>

         
            <div class="page-header">
              <h3 class="fw-bold mb-3">상품 등록</h3>
            </div>
            <div class="row">
              <div class="col-md-12">
                <div class="card">
                  <div class="card-header">
                    <div class="card-title">상품 정보 입력</div>
                  </div>
                  <div class="card-body">
                    <div class="row">
                      <div class="col-md-6 col-lg-4">
                        <div class="form-group">
                        
                        <%@page import="com.gn.product_admin.vo.Product_admin, java.util.*" %>
                 		<% Product_admin pa = (Product_admin)request.getAttribute("productInventoryInfo"); %>
                        <form action="/product_admin/product_inventoryEnd" name="product_inventory_form" method="post">
                          <input type="hidden" name="product_no" value="<%=pa.getProd_no() %>">
                          <label for="">상품명</label><br>
                          <p><%=pa.getProd_name() %></p>
                          <br>
                          <label for="product_inventory">입고 수량</label>
                          <input
                            type="number"
                            class="form-control"
                            id="product_inventory"
                            name="product_inventory"
                            value=""
                          /><br>
                          <input type="button" class="btn btn-success" value="확인" onclick="product_inventoryBtn();">
                    	  <input type="reset" class="btn btn-danger" value="비우기">
           			</form>
    <script type="text/javascript">
    	function product_inventoryBtn(){
    		var result = confirm("입고하시겠습니까?");
    		if(result){
    		var form = document.product_inventory_form;
    		form.submit();
    		}
    	}
    </script>
                </div>
              </div>
            </div>
          </div>
        </div>
        

        <footer class="footer">
          <div class="container-fluid d-flex justify-content-between">
            <div>
              Distributed by 꺼냉.
            </div>
          </div>
        </footer>
      </div>
    </div>
    <!--   Core JS Files   -->
    <script src="../assets/js/core/jquery-3.7.1.min.js"></script>
    <script src="../assets/js/core/popper.min.js"></script>
    <script src="../assets/js/core/bootstrap.min.js"></script>

    <!-- jQuery Scrollbar -->
    <script src="../assets/js/plugin/jquery-scrollbar/jquery.scrollbar.min.js"></script>
    <!-- Datatables -->
    <script src="../assets/js/plugin/datatables/datatables.min.js"></script>
    <!-- Kaiadmin JS -->
    <script src="../assets/js/kaiadmin.min.js"></script>
    <!-- Kaiadmin DEMO methods, don't include it in your project! -->
    <script src="../assets/js/setting-demo2.js"></script>
    
    	
    <script>
      $(document).ready(function () {
        $("#basic-datatables").DataTable({});

        $("#multi-filter-select").DataTable({
          pageLength: 5,
          initComplete: function () {
            this.api()
              .columns()
              .every(function () {
                var column = this;
                var select = $(
                  '<select class="form-select"><option value=""></option></select>'
                )
                  .appendTo($(column.footer()).empty())
                  .on("change", function () {
                    var val = $.fn.dataTable.util.escapeRegex($(this).val());

                    column
                      .search(val ? "^" + val + "$" : "", true, false)
                      .draw();
                  });

                column
                  .data()
                  .unique()
                  .sort()
                  .each(function (d, j) {
                    select.append(
                      '<option value="' + d + '">' + d + "</option>"
                    );
                  });
              });
          },
        });

        // Add Row
        $("#add-row").DataTable({
          pageLength: 5,
        });

        var action =
          '<td> <div class="form-button-action"> <button type="button" data-bs-toggle="tooltip" title="" class="btn btn-link btn-primary btn-lg" data-original-title="Edit Task"> <i class="fa fa-edit"></i> </button> <button type="button" data-bs-toggle="tooltip" title="" class="btn btn-link btn-danger" data-original-title="Remove"> <i class="fa fa-times"></i> </button> </div> </td>';

        $("#addRowButton").click(function () {
          $("#add-row")
            .dataTable()
            .fnAddData([
              $("#addName").val(),x
              $("#addPosition").val(),
              $("#addOffice").val(),
              action,
            ]);
          $("#addRowModal").modal("hide");
        });
      });	
    </script>
  </body>
</html>
