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
<title>나의 배송 관리</title>
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
	<!-- shipList start -->
	<%@ include file="../include/nav.jsp"%>

	<div class="list-box-main">
		<div class="container">
			<div class="col-sm-6 col-lg-6 mb-3">
				<div class="shipList-box">
					<a href="javascript:submitDeleteAction();"
						class="btn btn-primary mr-2">선택 항목 삭제</a> <a
						href="javascript:submitUpdateAction();"
						class="btn btn-primary mr-2">선택 항목 수정</a> <a
						href="javascript:addShip();" id="addShipLink"
						class="btn btn-primary">배송지 추가</a>
				</div>
			</div>
			<br>
			<div class="title-list">
				<h1>배송지 목록 조회</h1>
			</div>
			<%@ page import="com.project.user.vo.ShipList, java.util.*"%>

			<div class="wishlist-box-main">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="table-main table-responsive">
								<form action="/ship/shipListUpdate" method="post"
									id="updateForm" class="alias_validation">
									<table class="table">
										<thead>
											<tr>
												<th style="text-align: center">선택</th>
												<th style="text-align: center">설정한 배송지 별칭</th>
											</tr>
										</thead>
										<tbody>
											<%
											List<ShipList> ship = (List<ShipList>) request.getAttribute("shipList");
											if (ship != null) {
												for (int i = 0; i < ship.size(); i++) {
											%>
											<tr>
												<td style="text-align: center" class="radio_select"><input
													type="radio" id="alias<%=ship.get(i).getShip_no()%>"
													name="shipName" value="<%=ship.get(i).getShip_no()%>">
												</td>
												<td style="text-align: center" class="alias_view"><label
													for="alias<%=ship.get(i).getShip_no()%>"> <%=ship.get(i).getShip_alias()%></label>
												</td>
											</tr>
											<%
											}
											} else {
											out.print("등록한 배송지가 없습니다. 배송지를 추가하세요.");
											}
											%>
										</tbody>
									</table>
								</form>
								<hr>
								<br>
								<script>
									function submitDeleteAction() {
										var form = document.getElementById('updateForm');
										var selectedShipNo = document.querySelector('input[name="shipName"]:checked');

										if (selectedShipNo) {
											var shipNo = selectedShipNo.value;
											var deleteInput = document.createElement('input');
											deleteInput.type = 'hidden';
											deleteInput.name = 'selectedShipNo';
											deleteInput.value = shipNo;
											form.appendChild(deleteInput);

											form.action = "/ship/shipListDelete";
											form.submit();
										} else {
											alert('선택된 배송지가 없습니다.');
										}
									}

									function submitUpdateAction() {
										var form = document.getElementById('updateForm');
										var selectedShipNo = document.querySelector('input[name="shipName"]:checked');

										if (selectedShipNo) {
											var shipNo = selectedShipNo.value;
											var updateInput = document.createElement('input');
											updateInput.type = 'hidden';
											updateInput.name = 'selectedShipNo';
											updateInput.value = shipNo;
											form.appendChild(updateInput);

											form.submit();
										} else {
											alert('선택된 배송지가 없습니다.');
										}
									}

									function addShip() {
										var currentShipCount = document.querySelectorAll('input[name="shipName"]').length;

										if (currentShipCount >= 5) {
											alert('최대 5개의 주소만 저장할 수 있습니다. 다른 주소를 삭제 후 재진행 해주세요.');
											return;
										}
										window.location.href = '/ship/shipListCreate';
									}
								</script>
								<div>⁜ 최대 5개의 주소만 저장할 수 있습니다.</div>
							</div>
							<div class="col-12 d-flex shopping-box">
								<a href="/Cart/cartList" class="ml-auto btn hvr-hover">장바구니로 이동</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- shipList End -->

	<!-- Start footer  -->
	<%@ include file="../include/footer.jsp"%>

</body>

</html>