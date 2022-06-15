<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<title>Add Product Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>
				<h2 style="color: #6781d1; text-align: center;margin: 24px auto;">ADDING NEW PRODUCTS</h2>
<div class="add-product">
			<c:url var="addproducturl" value="/admin/addproduct"/>
            <form:form action="${addproducturl}" modelAttribute="newProduct" method="POST" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="productid">Product ID</label>
                    <form:input type="text" path="productid" placeholder="Product ID Auto Created" id="productid" disabled="true"></form:input>
                </div> 
                <div class="form-group">
                    <label for="productname">Product Name</label>
                    <form:input type="text" path="productname" value="Đồng Hồ" id="productname" disabled="true"></form:input>
                </div>
                <div class="form-group">
                    <label for="brand">Product Brand</label>
                    <form:select path="brand" id="brand">
                        <form:option value="longines" label="Longines"></form:option>
                        <form:option value="hamilton" label="Hamilton"></form:option>
                        <form:option value="seiko" label="Seiko"></form:option>
                        <form:option value="citizen" label="Citizen"></form:option>
                        <form:option value="orient" label="Orient"></form:option>
                        <form:option value="casio" label="Casio"></form:option>
                        <form:option value="calvin klein" label="Calvin klein"></form:option>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="diameter">Product Diameter</label>
                    <form:input type="text" path="diameter" id="diameter"></form:input>
                </div>
                <form:errors path="diameter" cssClass="errorFiled" ></form:errors>
                <div class="form-group">
                    <label for="symbolbrand">Product Symbol Brand</label>
                    <form:input type="text" path="symbolbrand" id="symbolbrand" placeholder="Field Auto Created" disabled="true"></form:input>
                </div>
                <div class="form-group">
                    <label for="gendertype">Product Gender Type</label>
                    <form:select path="gendertype" id="gendertype">
                        <form:option value="man" label="Nam"></form:option>
                        <form:option value="woman" label="Nữ"></form:option>
                        <form:option value="couple" label="Đôi"></form:option>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="machinetype">Product Machine Type</label>
                    <form:select path="machinetype" id="machinetype">
                        <form:option value="automatic" label="Automatic"></form:option>
                        <form:option value="quartz" label="Quartz"></form:option>
                        <form:option value="eco drive" label="Eco Drive"></form:option>
                        <form:option value="manual winding" label="Manual Winding"></form:option>
                    </form:select>
                </div>

                <div class="form-group">
                    <label for="status">Product Status</label>
                    <form:select path="status" id="status">
                        <form:option value="new" label="New"></form:option>
                        <form:option value="hot" label="Hot"></form:option>
                        <form:option value="normal" label="Normal"></form:option>
                    </form:select>
                </div>
                <div class="form-group">
                    <label for="glass">Product Glass Type</label>
                    <form:input type="text" path="glass"></form:input>
                </div>
                <form:errors path="glass" cssClass="errorFiled" ></form:errors>
                <div class="form-group">
                    <label for="material">Product Material</label>
                    <form:input type="text" path="material"></form:input>
                </div>
                <form:errors path="material" cssClass="errorFiled" ></form:errors>
                <div class="form-group">
                    <label for="original">Product Orginal</label>
                    <form:input type="text" path="original"></form:input>
                </div>
                <form:errors path="material" cssClass="errorFiled" ></form:errors>
                <div class="form-group">
                    <label for="temporarysaveimg">Product Image</label>
                    <form:input type="file" path="temporarysaveimg"></form:input>
                </div>
                              <span class="errorFiled">${emptyImg}</span>
                <div class="form-group">
                    <label for="oldprice">Product Price</label>
                    <form:input type="text" path="oldprice"></form:input>
                </div>
                <form:errors path="oldprice" cssClass="errorFiled" ></form:errors>
                <div class="form-group">
                    <label for="discountpercent">Product Discount Percent</label>
                    <form:input type="text" path="discountpercent"></form:input>
                </div>
                <form:errors path="discountpercent" cssClass="errorFiled" ></form:errors>
                <div class="form-group">
                    <label for="discountprice">Product Discount Price</label>
                    <form:input type="text" path="discountprice" placeholder="Field Auto Created" disabled="true"
                         ></form:input>
                </div>
                <input type="submit" value="ADD PRODUCT" id="addproductbtn">
            </form:form>
        </div>
	<%@ include file="footer.jsp" %>
	<c:if test="${not empty updateFailed}">
	<script>
	alert(${updateFailed});
	</script>
	</c:if>
</body>
</html>