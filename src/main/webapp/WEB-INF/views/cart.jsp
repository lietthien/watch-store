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
<title>User Cart</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<div class="customer-cart">
            <h1>Product Management</h1>
            <c:if test="${not empty emptycart}"><h2 style="text-align: center;margin-bottom: 60px;">${emptycart}</h2></c:if>
            <c:if test="${not empty cartViewDataList}">
             <div class="total-price">
                <p>List of product in your cart</p>
                <p>Total Payment: <span class="cart-product-total-payment"><fmt:formatNumber type="number" value="${cartViewDataList[0].totalprice}"></fmt:formatNumber>&#8363;</span></p>
            </div>

            <table class="cart-list-product">
                <tr>
                    <th>Screen-Shot</th>
                    <th>Product ID</th>
                    <th>Product name</th>
                    <th>Original</th>
                    <th>Discount Price</th>
                    <th>Stock Unit</th>
                    <th>Payment</th>
                    <th>Remove</th>
                </tr>
            
           
           
                <c:forEach items="${cartViewDataList}" var="cartviewdata">
                <tr>
                    <td class="screenshot-product"><img src="<c:url value="/resources/images/products/${cartviewdata.image}"/>" alt="product screenshot"></td>
                    <td class="cart-product-id">${cartviewdata.productid}</td>
                    <td class="cart-product-name">${cartviewdata.productname} ${cartviewdata.brand} ${cartviewdata.symbolbrand}</td>
                    <td class="cart-product-orginal">${cartviewdata.original}</td>
                    <td class="cart-product-discount-price"><fmt:formatNumber type="number" value="${cartviewdata.price}"></fmt:formatNumber>&#8363;</td>
                    <td class="cart-product-quantity">
                    <a class="decrease-quantity" href="<c:url value="/user/modifyquantity/substractone/${cartviewdata.productid}"/>"><i class="fa-solid fa-minus"></i></a>
                    <span id="stock-unit">${cartviewdata.quantity}</span>
                    <a class="increase-quantity" href="<c:url value="/user/modifyquantity/plusone/${cartviewdata.productid}"/>"><i class="fa-solid fa-plus"></i></a>
                    </td>
                    <td class="cart-product-totalprice"><fmt:formatNumber type="number" value="${cartviewdata.price*cartviewdata.quantity}"></fmt:formatNumber>&#8363;</td>
                    <td class="cart-product-remove"><a href="<c:url value="/user/deleteproductincart/${cartviewdata.productid}"/>"><i class="fa-solid fa-circle-minus"></i></a></td>
                </tr>
                </c:forEach>
                
            </table>
             </c:if>
            <c:if test="${not empty cartViewDataList}">
            <span class="checkout"><a href="<c:url value="/user/cart/checkout?cartid=${cartViewDataList[0].cartid}"/>">Đặt Hàng</a></span>
            <span class="remove-all-products"><a href="<c:url value="/user/deleteallproductincart"/>">Gỡ Bỏ Toàn Bộ Mặt Hàng</a></span>
            </c:if>
        </div>
	<%@ include file="footer.jsp"%>
</body>
</html>