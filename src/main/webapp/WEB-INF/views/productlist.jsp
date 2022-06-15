<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
<link rel="shortcut icon"
	href="<c:url value="/resources/images/logo/favicon.ico"/>"
	type="image/x-icon">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Product Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%@ include file="slider.jsp"%>
<div class="root" style="background-color: #ededed; padding-bottom: 8px;">
	<!-- product list -->
	<div class="main">
		<c:forEach items="${productList}" var="product">
			<div class="product-item">
				<a href="<c:url value="/product/detail/${product.productid}"/>">
					<img class="product-img"
					src="<c:url value="/resources/images/products/${product.image}"/>"
					alt="${product.image} image">
				</a> <a href="<c:url value="/product/detail/${product.productid}"/>"
					class="product-detail"> 
					<c:if
						test="${product.gendertype=='man'}">
						<p class="product-name">Đồng hồ nam ${product.brand}</p>
					</c:if>
					<c:if
						test="${product.gendertype=='woman'}">
						<p class="product-name">Đồng hồ nữ ${product.brand}</p>
					</c:if>
					<c:if
						test="${product.gendertype=='couple'}">
						<p class="product-name">Đồng hồ đôi ${product.brand}</p>
					</c:if>
					<h3 class="product-code">${product.symbolbrand}</h3>
				</a>
				<div class="specification">
					<span class="machine-type">${product.machinetype}</span> | <span
						class="diameter">${product.diameter}MM</span>
				</div>

				<del class="old-price">
					Giá:
					<fmt:formatNumber type="number" value="${product.oldprice}" />
					₫
				</del>

				<div class="product-price">
					<span>Giá KM:</span> <span><fmt:formatNumber type="number"
							value="${product.discountprice}" />₫</span>
				</div>
				<c:if test="${product.discountpercent>0}">
					<div class="product-discount-percent">-${product.discountpercent}%</div>
				</c:if>

				<c:if test="${product.status!='normal'}">
					<div class="product-state">${product.status}</div>
				</c:if>
			</div>
		</c:forEach>
		</div>
		<!-- <div class="pagination">
			<a href="#">&laquo;</a> 
			<a href="#">1</a> 
			<a href="#">2</a> 
			<a href="#">3</a> 
			<a href="#">4</a> 
			<a href="#">5</a> 
			<a href="#">6</a>
			<a href="#">&raquo;</a>
		</div> -->
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>