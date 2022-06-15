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
<title>Watch Store Home Page</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<%@ include file="slider.jsp"%>
	<div class="home-main">
		<!-- -----------best seller product------------>
		<span class="best-seller-title">BÁN CHẠY NHẤT</span>

		<div class="watches-type-best-seller">
			<span class="watches-type-item active">đồng hồ nam</span> <span
				class="watches-type-item">đồng hồ nữ</span> <span
				class="watches-type-item">đồng hồ đôi</span>
		</div>
		<div class="best-seller-container">
			<div class="man-watches best-seller-item active">
				<c:forEach items="${hotManProducts}" var="hotManProduct">
					<div class="product-item">
						<a href="<c:url value="/product/detail/${hotManProduct.productid}"/>"> <img class="product-img"
							src="<c:url value="/resources/images/products/${hotManProduct.image}"/>"
							alt="${hotManProduct.image} image">
						</a> 
						<a href="<c:url value="/product/detail/${hotManProduct.productid}"/>" class="product-detail">
							<p class="product-name">Đồng hồ nam ${hotManProduct.brand}</p>
							<h3 class="product-code">${hotManProduct.symbolbrand}</h3>
						</a>
						<div class="specification">
							<span class="machine-type">${hotManProduct.machinetype}</span> |
							<span class="diameter">${hotManProduct.diameter}MM</span>
						</div>

						<del class="old-price">
							Giá:
							<fmt:formatNumber type="number" value="${hotManProduct.oldprice}" />
							₫
						</del>

						<div class="product-price">
							<span>Giá KM:</span> <span><fmt:formatNumber type="number"
									value="${hotManProduct.discountprice}" />₫</span>
						</div>
						<c:if test="${hotManProduct.discountpercent>0}">
							<div class="product-discount-percent">-${hotManProduct.discountpercent}%</div>
						</c:if>

						<c:if test="${hotManProduct.status!='normal'}">
							<div class="product-state">${hotManProduct.status}</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<div class="woman-watches best-seller-item">
				<c:forEach items="${hotWomanProducts}" var="hotWomanProduct">
					<div class="product-item">
						<a href="<c:url value="/product/detail/${hotWomanProduct.productid}"/>"> <img class="product-img"
							src="<c:url value="/resources/images/products/${hotWomanProduct.image}"/>"
							alt="${hotWomanProduct.image} image">
						</a> 
						<a href="<c:url value="/product/detail/${hotWomanProduct.productid}"/>" class="product-detail">
							<p class="product-name">Đồng hồ nữ ${hotWomanProduct.brand}</p>
							<h3 class="product-code">${hotWomanProduct.symbolbrand}</h3>
						</a>
						<div class="specification">
							<span class="machine-type">${hotWomanProduct.machinetype}</span>
							| <span class="diameter">${hotWomanProduct.diameter}MM</span>
						</div>

						<del class="old-price">
							Giá:
							<fmt:formatNumber type="number"
								value="${hotWomanProduct.oldprice}" />
							₫
						</del>

						<div class="product-price">
							<span>Giá KM:</span> <span><fmt:formatNumber type="number"
									value="${hotWomanProduct.discountprice}" />₫</span>
						</div>
						<c:if test="${hotWomanProduct.discountpercent>0}">
							<div class="product-discount-percent">-${hotWomanProduct.discountpercent}%</div>
						</c:if>

						<c:if test="${hotWomanProduct.status!='normal'}">
							<div class="product-state">${hotWomanProduct.status}</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<div class="couple-watches best-seller-item">
				<c:forEach items="${hotCoupleProducts}" var="hotCoupleProduct">
					<div class="product-item">
						<a href="<c:url value="/product/detail/${hotCoupleProduct.productid}"/>"> <img class="product-img"
							src="<c:url value="/resources/images/products/${hotCoupleProduct.image}"/>"
							alt="${hotCoupleProduct.image} image">
						</a> <a href="<c:url value="/product/detail/${hotCoupleProduct.productid}"/>" class="product-detail">
							<p class="product-name">Đồng hồ đôi ${hotCoupleProduct.brand}</p>
							<h3 class="product-code">${hotCoupleProduct.symbolbrand}</h3>
						</a>
						<div class="specification">
							<span class="machine-type">${hotCoupleProduct.machinetype}</span>
							| <span class="diameter">${hotCoupleProduct.diameter}MM</span>
						</div>

						<del class="old-price">
							Giá:
							<fmt:formatNumber type="number"
								value="${hotCoupleProduct.oldprice}" />
							₫
						</del>

						<div class="product-price">
							<span>Giá KM:</span> <span><fmt:formatNumber type="number"
									value="${hotCoupleProduct.discountprice}" />₫</span>
						</div>
						<c:if test="${hotCoupleProduct.discountpercent>0}">
							<div class="product-discount-percent">-${hotCoupleProduct.discountpercent}%</div>
						</c:if>

						<c:if test="${hotCoupleProduct.status!='normal'}">
							<div class="product-state">${hotCoupleProduct.status}</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<div class="more-bseller-product">
				<a href="<c:url value="/product/hot/man"/>" class="more-bseller-link man-item active">Xem thêm
					đồng hồ nam bán chạy</a> 
					<a href="<c:url value="/product/hot/woman"/>"
					class="more-bseller-link woman-item">Xem thêm đồng hồ nữ bán
					chạy</a>
					 <a href="<c:url value="/product/hot/couple"/>" class="more-bseller-link couple-item">Xem thêm
					đồng hồ đôi bán chạy</a>
			</div>
		</div>

		<!-- -----------newest  product------------>
		<span class="newest-product-title">Sản phẩm mới</span>

		<div class="newest-watches-type">
			<span class="newest-watches-type-item active">đồng hồ nam</span> <span
				class="newest-watches-type-item">đồng hồ nữ</span> <span
				class="newest-watches-type-item">đồng hồ đôi</span>
		</div>
		<div class="newest-product-container">
			<div class="man-watches newest-product-item active">
				<c:forEach items="${newManProducts}" var="newManProduct">
					<div class="product-item">
						<a href="<c:url value="/product/detail/${newManProduct.productid}"/>"> <img class="product-img"
							src="<c:url value="/resources/images/products/${newManProduct.image}"/>"
							alt="${newManProduct.image} image">
						</a> <a href="<c:url value="/product/detail/${newManProduct.productid}"/>" class="product-detail">
							<p class="product-name">Đồng hồ nam ${newManProduct.brand}</p>
							<h3 class="product-code">${newManProduct.symbolbrand}</h3>
						</a>
						<div class="specification">
							<span class="machine-type">${newManProduct.machinetype}</span> |
							<span class="diameter">${newManProduct.diameter}MM</span>
						</div>

						<del class="old-price">
							Giá:
							<fmt:formatNumber type="number" value="${newManProduct.oldprice}" />
							₫
						</del>

						<div class="product-price">
							<span>Giá KM:</span> <span><fmt:formatNumber type="number"
									value="${newManProduct.discountprice}" />₫</span>
						</div>
						<c:if test="${newManProduct.discountpercent>0}">
							<div class="product-discount-percent">-${newManProduct.discountpercent}%</div>
						</c:if>

						<c:if test="${newManProduct.status!='normal'}">
							<div class="product-state">${newManProduct.status}</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<div class="woman-watches newest-product-item">
				<c:forEach items="${newWomanProducts}" var="newWomanProduct">
					<div class="product-item">
						<a href="<c:url value="/product/detail/${newWomanProduct.productid}"/>"> <img class="product-img"
							src="<c:url value="/resources/images/products/${newWomanProduct.image}"/>"
							alt="${newWomanProduct.image} image">
						</a> <a href="<c:url value="/product/detail/${newWomanProduct.productid}"/>" class="product-detail">
							<p class="product-name">Đồng hồ nữ ${newWomanProduct.brand}</p>
							<h3 class="product-code">${newWomanProduct.symbolbrand}</h3>
						</a>
						<div class="specification">
							<span class="machine-type">${newWomanProduct.machinetype}</span>
							| <span class="diameter">${newWomanProduct.diameter}MM</span>
						</div>
						<del class="old-price">
							Giá:
							<fmt:formatNumber type="number" 
								value="${newWomanProduct.oldprice}" />
							₫
						</del>
						<div class="product-price">
							<span>Giá KM:</span> <span><fmt:formatNumber type="number"
									value="${newWomanProduct.discountprice}" />₫</span>
						</div>
						<c:if test="${newWomanProduct.discountpercent>0}">
							<div class="product-discount-percent">-${newWomanProduct.discountpercent}%</div>
						</c:if>

						<c:if test="${newWomanProduct.status!='normal'}">
							<div class="product-state">${newWomanProduct.status}</div>
						</c:if>
					</div>
				</c:forEach>
			</div>
			<div class="couple-watches newest-product-item ">
				<c:forEach items="${newCoupleProducts}" var="newCoupleProduct">
					<div class="product-item">
						<a href="<c:url value="/product/detail/${newCoupleProduct.productid}"/>"> <img class="product-img"
							src="<c:url value="/resources/images/products/${newCoupleProduct.image}"/>"
							alt="${newCoupleProduct.image} image">
						</a> <a href="<c:url value="/product/detail/${newCoupleProduct.productid}"/>" class="product-detail">
							<p class="product-name">Đồng hồ đôi ${newCoupleProduct.brand}</p>
							<h3 class="product-code">${newCoupleProduct.symbolbrand}</h3>
						</a>
						<div class="specification">
							<span class="machine-type">${newCoupleProduct.machinetype}</span>
							| <span class="diameter">${newCoupleProduct.diameter}MM</span>
						</div>
						<del class="old-price">
							Giá:
							<fmt:formatNumber type="number"
								value="${newCoupleProduct.oldprice}" />
							₫
						</del>
						<div class="product-price">
							<span>Giá KM:</span> <span><fmt:formatNumber type="number"
									value="${newCoupleProduct.discountprice}" />₫</span>
						</div>
						<c:if test="${newCoupleProduct.discountpercent>0}">
							<div class="product-discount-percent">-${newCoupleProduct.discountpercent}%</div>
						</c:if>

						<c:if test="${newCoupleProduct.status!='normal'}">
							<div class="product-state">${newCoupleProduct.status}</div>
						</c:if>
					</div>
				</c:forEach>
			</div>

			<div class="more-newest-product">
				<a href="<c:url value="/product/new/man"/>" class="more-newest-product-link man-item active">Xem
					thêm đồng hồ nam mới</a> 
					<a href="<c:url value="/product/new/woman"/>"
					class="more-newest-product-link woman-item">Xem thêm đồng hồ nữ
					mới</a> 
					<a href="<c:url value="/product/new/couple"/>" class="more-newest-product-link couple-item">Xem
					thêm đồng hồ đôi mới</a>
			</div>
		</div>
	</div>
	</div>
	<%@ include file="footer.jsp"%>
	<c:if test="${not empty loginedMessage}">
	<script type="text/javascript">
	alert("${loginedMessage}");
	</script>
	</c:if>
	<c:if test="${not empty denyMessage}">
	<script type="text/javascript">
	alert("${denyMessage}");
	</script>
	</c:if>
	
</body>

</html>