<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<c:if test="${empty sessionScope.userAccount}">
	<header class="header">
		<div class="header-up">
			<div class="logo">
				<a href="<c:url value="/home"/>"> <img
					src="<c:url value="/resources/images/logo/logo.png"/>"
					alt="Đồng hồ chính hãng" />
				</a>
			</div>
			
			<form class="search-box">
				<input type="text" id="search-input" placeholder="Bạn muốn tìm...">
				<button type="submit" id="search-btn">
					<i class="fa-solid fa-magnifying-glass"></i>

				</button>
			</form>
			<div class="contact">
				<i class="fa-solid fa-phone"></i> <span>012.555.8888</span>
			</div>
			<a href="<c:url value="/user/register"/>">
				<div class="sign-up">
					<span>Đăng ký</span>
				</div>
			</a> <a href="<c:url value="/user/login"/>">
				<div class="sign-in">
					<span>Đăng nhập</span>
				</div>
			</a> <a href="<c:url value="/user/viewcart"/>">
				<div class="cart">
					<div class="quantity">0</div>
					<i class="fa-solid fa-cart-shopping"></i>
				</div>
			</a>
		</div>
		<div class="header-down">
			<a href="<c:url value="/home"/>">
				<div class="back-to-home nav-item">
					<i class="fa-solid fa-house-chimney-user"> </i>
				</div>
			</a>
			<div class="brand nav-item">
				<a href="#">Thương hiệu</a>
				<div class="brand-dropdown">
					<div class="brand-logo">
						<a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=longines"/>"><img
							src="<c:url value="/resources/images/logo/longines-logo.png"/>"
							alt="Longines"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=hamilton"/>"><img
							src="<c:url value="/resources/images/logo/hamilton-logo.png"/>"
							alt="Hamiton"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=seiko"/>"><img
							src="<c:url value="/resources/images/logo/seiko-logo.png"/>"
							alt="Seiko"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=citizen"/>"><img
							src="<c:url value="/resources/images/logo/citizen-logo.png"/>"
							alt="Citizen"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=orient"/>"><img
							src="<c:url value="/resources/images/logo/orient-logo.png"/>"
							alt="Orient"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=casio"/>"><img
							src="<c:url value="/resources/images/logo/casio-logo.png"/>"
							alt="Casio"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=calvin klein"/>"><img
							src="<c:url value="/resources/images/logo/calvin klein-logo.png"/>"
							alt="Calvin Klein"></a>
					</div>
				</div>
			</div>
			<div class="man-band nav-item">
				<a href="<c:url value="/product/gender?gendertype=man"/>">Đồng
					hồ nam</a>
				<div class="man-band-dropdown">
					<div class="list-band-name">
						<span>Thương hiệu</span>
						<ul>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=longines"/>">Longines</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=hamilton"/>">Hamilton</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=seiko"/>">Seiko</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=citizen"/>">Citizen</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=orient"/>">Orient</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=casio"/>">Casio</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=calvin klein"/>">Calvin
									klein</a></li>
						</ul>
					</div>
					<div class="list-price">
						<span>Mức giá</span>
						<ul>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=0&maxprice=2000000"/>">Dưới
									2 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=2000000&maxprice=5000000"/>">Từ
									2 đến 5 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=5000000&maxprice=10000000"/>">Từ
									5 đến 10 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=10000000&maxprice=20000000"/>">Từ
									10 đến 20 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=20000000&maxprice=30000000"/>">Từ
									20 đến 30 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=30000000&maxprice=50000000"/>">Từ
									30 đến 50 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=50000000&maxprice=100000000"/>">Từ
									50 đến 100 triệu</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="woman-band nav-item">
				<a href="<c:url value="/product/gender?gendertype=woman"/>">Đồng
					hồ nữ</a>
				<div class="woman-band-dropdown">
					<div class="list-band-name">
						<span>Thương hiệu</span>
						<ul>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=longines"/>">Longines</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=hamilton"/>">Hamilton</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=seiko"/>">Seiko</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=citizen"/>">Citizen</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=orient"/>">Orient</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=casio"/>">Casio</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=calvin klein"/>">Calvin
									klein</a></li>
						</ul>
					</div>
					<div class="list-price">
						<span>Mức giá</span>
						<ul>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=0&maxprice=2000000"/>">Dưới
									2 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=2000000&maxprice=5000000"/>">Từ
									2 đến 5 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=5000000&maxprice=10000000"/>">Từ
									5 đến 10 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=10000000&maxprice=20000000"/>">Từ
									10 đến 20 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=20000000&maxprice=30000000"/>">Từ
									20 đến 30 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=30000000&maxprice=50000000"/>">Từ
									30 đến 50 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=50000000&maxprice=100000000"/>">Từ
									50 đến 100 triệu</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="switzerland-band nav-item">
				<a href="<c:url value="/product?original=switzerland"/>">Đồng hồ
					thụy sĩ</a>
			</div>
			<div class="other-product nav-item">
				<a href="">Sản phẩm khác</a>
				<div class="other-product-dropdown">
					<ul>
						<li><a
							href="<c:url value="/product/gender?gendertype=couple"/>">Đồng
								hồ đôi</a></li>
						<li><a href="<c:url value="/other"/>">Đồng hồ treo tường</a></li>
						<li><a href="<c:url value="/other"/>">Đồng hồ để bàn</a></li>
					</ul>
				</div>
			</div>

		</div>
	</header>
	</c:if>
	<c:if test="${sessionScope.userAccount.role=='customer'}">
	<header class="header">
		<div class="header-up">
			<div class="logo">
				<a href="<c:url value="/home"/>"> <img
					src="<c:url value="/resources/images/logo/logo.png"/>"
					alt="Đồng hồ chính hãng" />
				</a>
			</div>
			<form class="search-box">
				<input type="text" id="search-input" placeholder="Bạn muốn tìm...">
				<button type="submit" id="search-btn">
					<i class="fa-solid fa-magnifying-glass"></i>

				</button>
			</form>
			<div class="contact">
				<i class="fa-solid fa-phone"></i> <span>012.555.8888</span>
			</div>
			
				<div class="user-account-name">
				<i class="fa-solid fa-user"></i>
					<span>${sessionScope.userAccount.firstname} ${sessionScope.userAccount.lastname}</span>
				</div>
			 <a href="<c:url value="/user/logout"/>">
				<div class="logout">
					<span>Đăng xuất</span>
				</div>
			</a> <a href="<c:url value="/user/viewcart"/>">
				<div class="cart">
				<c:if test="${not empty sessionScope.totalQuantity}">
					<div class="quantity">${sessionScope.totalQuantity}</div>
					<i class="fa-solid fa-cart-shopping"></i>
				</c:if>
				<c:if test="${empty sessionScope.totalQuantity}">
					<div class="quantity">0</div>
					<i class="fa-solid fa-cart-shopping"></i>
				</c:if>
				</div>
			</a>
		</div>
		<div class="header-down">
			<a href="<c:url value="/home"/>">
				<div class="back-to-home nav-item">
					<i class="fa-solid fa-house-chimney-user"> </i>
				</div>
			</a>
			<div class="brand nav-item">
				<a href="#">Thương hiệu</a>
				<div class="brand-dropdown">
					<div class="brand-logo">
						<a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=longines"/>"><img
							src="<c:url value="/resources/images/logo/longines-logo.png"/>"
							alt="Longines"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=hamilton"/>"><img
							src="<c:url value="/resources/images/logo/hamilton-logo.png"/>"
							alt="Hamiton"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=seiko"/>"><img
							src="<c:url value="/resources/images/logo/seiko-logo.png"/>"
							alt="Seiko"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=citizen"/>"><img
							src="<c:url value="/resources/images/logo/citizen-logo.png"/>"
							alt="Citizen"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=orient"/>"><img
							src="<c:url value="/resources/images/logo/orient-logol.png"/>"
							alt="Orient"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=casio"/>"><img
							src="<c:url value="/resources/images/logo/casio-logo.png"/>"
							alt="Casio"></a> <a class="brand-logo-img"
							href="<c:url value="/product/brandspecificate?brand=calvin klein"/>"><img
							src="<c:url value="/resources/images/logo/calvin klein-logo.png"/>"
							alt="Calvin Klein"></a>
					</div>
				</div>
			</div>
			<div class="man-band nav-item">
				<a href="<c:url value="/product/gender?gendertype=man"/>">Đồng
					hồ nam</a>
				<div class="man-band-dropdown">
					<div class="list-band-name">
						<span>Thương hiệu</span>
						<ul>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=longines"/>">Longines</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=hamilton"/>">Hamilton</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=seiko"/>">Seiko</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=citizen"/>">Citizen</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=orient"/>">Orient</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=casio"/>">Casio</a></li>
							<li><a
								href="<c:url value="/product/man/brandspecificate?brand=calvin klein"/>">Calvin
									klein</a></li>
						</ul>
					</div>
					<div class="list-price">
						<span>Mức giá</span>
						<ul>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=0&maxprice=2000000"/>">Dưới
									2 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=2000000&maxprice=5000000"/>">Từ
									2 đến 5 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=5000000&maxprice=10000000"/>">Từ
									5 đến 10 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=10000000&maxprice=20000000"/>">Từ
									10 đến 20 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=20000000&maxprice=30000000"/>">Từ
									20 đến 30 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=30000000&maxprice=50000000"/>">Từ
									30 đến 50 triệu</a></li>
							<li><a
								href="<c:url value="/product/man/pricerange?minprice=50000000&maxprice=100000000"/>">Từ
									50 đến 100 triệu</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="woman-band nav-item">
				<a href="<c:url value="/product/gender?gendertype=woman"/>">Đồng
					hồ nữ</a>
				<div class="woman-band-dropdown">
					<div class="list-band-name">
						<span>Thương hiệu</span>
						<ul>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=longines"/>">Longines</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=hamilton"/>">Hamilton</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=seiko"/>">Seiko</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=citizen"/>">Citizen</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=orient"/>">Orient</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=casio"/>">Casio</a></li>
							<li><a
								href="<c:url value="/product/woman/brandspecificate?brand=calvin klein"/>">Calvin
									klein</a></li>
						</ul>
					</div>
					<div class="list-price">
						<span>Mức giá</span>
						<ul>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=0&maxprice=2000000"/>">Dưới
									2 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=2000000&maxprice=5000000"/>">Từ
									2 đến 5 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=5000000&maxprice=10000000"/>">Từ
									5 đến 10 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=10000000&maxprice=20000000"/>">Từ
									10 đến 20 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=20000000&maxprice=30000000"/>">Từ
									20 đến 30 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=30000000&maxprice=50000000"/>">Từ
									30 đến 50 triệu</a></li>
							<li><a
								href="<c:url value="/product/woman/pricerange?minprice=50000000&maxprice=100000000"/>">Từ
									50 đến 100 triệu</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="switzerland-band nav-item">
				<a href="<c:url value="/product?original=switzerland"/>">Đồng hồ
					thụy sĩ</a>
			</div>
			<div class="other-product nav-item">
				<a href="">Sản phẩm khác</a>
				<div class="other-product-dropdown">
					<ul>
						<li><a
							href="<c:url value="/product/gender?gendertype=couple"/>">Đồng
								hồ đôi</a></li>
						<li><a href="<c:url value="/other"/>">Đồng hồ treo tường</a></li>
						<li><a href="<c:url value="/other"/>">Đồng hồ để bàn</a></li>
					</ul>
				</div>
			</div>

		</div>
	</header>
	</c:if>
	
	<c:if test="${sessionScope.userAccount.role=='administrator'}">
	<header class="header">
		<div class="header-up">
			<div class="logo">
				<a href="<c:url value="/home"/>"> <img
					src="<c:url value="/resources/images/logo/logo.png"/>"
					alt="Đồng hồ chính hãng" />
				</a>
			</div>
			<form class="search-box">
				<input type="text" id="search-input" placeholder="Bạn muốn tìm...">
				<button type="submit" id="search-btn">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</form>
			<a href="#">
				<div class="user-account-name">
				<i class="fa-solid fa-user"></i>
					<span>${sessionScope.userAccount.firstname} ${sessionScope.userAccount.lastname}</span>
				</div>
			</a> <a href="<c:url value="/user/logout"/>">
				<div class="logout">
					<span>Đăng xuất</span>
				</div>
			</a> 
			
		</div>
		<div class="header-down">
			<a class="admin-link" href="<c:url value="/admin/addproduct"/>">
				Add Product
			</a>
			<a class="admin-link" href="<c:url value="/admin/product/manage"/>">
				Product Management
			</a>
			<a class="admin-link" href="<c:url value="/admin/userlist"/>">
				Customer List
			</a>

		</div>
	</header>
	</c:if>
</body>
</html>