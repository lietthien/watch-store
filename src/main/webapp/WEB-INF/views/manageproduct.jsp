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
<title>Admin Page</title>
</head>

<body>
	<%@ include file="header.jsp"%>
<!--administrator management product -->
        <div class="product-manage">
            <h1>Product Management</h1>
            <table class="ad-list-product">
                <tr>
                    <th>Screenshot</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>Original</th>
                    <th>Gender</th>
                    <th>Discount Percent</th>
                    <th>Price</th>
                    <th>Discount Price</th>
                    <th>Machine</th>
                    <th>Diameter</th>
                    <th>Status</th>
                    <th>Glass</th>
                    <th>Material</th>
                    <th>Modify</th>
                    <th>Delete</th>
                </tr>
                <c:forEach items="${ProductForPage}" var="product">
                <tr>
                    <td class="screenshot-product"><img src="<c:url value="/resources/images/products/${product.image}"/>"
                            alt="product ${product.productid} screenshot"></td>
                    <td class="ad-product-id">${product.productid}</td>
                    <td class="ad-product-name">${product.productname} ${product.brand} ${product.symbolbrand}</td>
                    <td class="ad-product-orginal">${product.original}</td>
                    <td class="ad-product-gender">${product.gendertype}</td>
                    <td class="ad-product-discount">${product.discountpercent}%</td>
                    <td class="ad-product-oldprice"><fmt:formatNumber type="number" value="${product.oldprice}"/>&#8363;</td>
                    <td class="ad-product-discountprice"><fmt:formatNumber type="number" value="${product.discountprice}"/>&#8363;</td>
                    <td class="ad-product-machinetype">${product.machinetype}</td>
                    <td class="ad-product-diameter">${product.diameter}mm</td>
                    <td class="ad-product-status">${product.status}</td>
                    <td class="ad-product-glass">${product.glass}</td>
                    <td class="ad-product-material">${product.material}</td>              
                    <td class="ad-product-edit"><a href="<c:url value="/admin/edit/product/${product.productid}"/>"><i class="fa-solid fa-highlighter"></i></a></td>
                    <td class="ad-product-remove"><a href="<c:url value="/admin/delete/product/${product.productid}"/>"><i class="fa-solid fa-circle-minus"></i></a></td>
                </tr>
                </c:forEach>
            
            </table>
        </div>
        <c:if test="${totalPage>1}">
          <div class="pagination">
          <c:if test="${activePage>1}">
			<a href="<c:url value="/admin/product/manage?page=${activePage-1}"/>">&laquo;</a>
          </c:if>
			<c:forEach begin="1" end="${totalPage}" var="index">
			<a href="<c:url value="/admin/product/manage?page=${index}"/>" class="page-link ${activePage==index?'actived':''}">${index}</a>           
          </c:forEach> 
           <c:if test="${activePage<totalPage}">
			<a href="<c:url value="/admin/product/manage?page=${activePage+1}"/>">&raquo;</a>
			</c:if>
		</div> 
        </c:if>
       
	<%@ include file="footer.jsp"%>
	<c:if test="${not empty updateSucessed}">
	<script>alert("${updateSucessed}")</script>
	</c:if>
	<c:if test="${not empty editSucessed}">
	<script>alert("${editSucessed}")</script>
	</c:if>
	<c:if test="${deleteSuccess}">
	<script>alert("${deleteSuccess}")</script>
	</c:if>
	
</body>
</html>