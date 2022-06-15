<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta path="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
<link rel="shortcut icon"
	href="<c:url value="/resources/images/logo/favicon.ico"/>"
	type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Register Page</title>
</head>

<body>
	<%@ include file="header.jsp"%>
	<!-- register form form -->
	<h3 style="text-align: center;color: red;padding-top: 12px;">${duplicatedInfo}</h3>
	<div class="register-form">
		<h2>Register Form</h2>
		<c:url var="url" value="/user/register" />
		<form:form action="${url}" modelAttribute="user" method="POST" acceptCharset="utf-8">
			<div class="registerform-body">
				<div class="registerform-body-left">
					<div>
						<form:input type="text" path="firstname" id="firstname"
							placeholder="Your First Name" tabindex="1"></form:input>
						<span class="errorMessage"> <form:errors path="firstname"></form:errors>
						</span>
					</div>
					<div>
						<form:input type="text" path="phonenumber" id="phonenumber"
							placeholder="Your Phone Number" tabindex="3"></form:input>
						<span class="errorMessage"> <form:errors
								path="phonenumber"></form:errors>
						</span>
					</div>
					<div>
						<form:input type="text" path="email" id="email"
							placeholder="Your Email" tabindex="5"></form:input>
						<span class="errorMessage"> <form:errors path="email"></form:errors>
						</span>
					</div>
				</div>
				<div class="registerform-body-right">
					<div>
						<form:input type="text" path="lastname" id="lastname"
							placeholder="Your Last Name" tabindex="2"></form:input>
						<span class="errorMessage"> <form:errors path="lastname"></form:errors>
						</span>
					</div>
					<div>
						<form:input type="text" path="address" id="address"
							placeholder="Your Address" tabindex="4"></form:input>
						<span class="errorMessage"> <form:errors path="address"></form:errors>
						</span>
					</div>
					<div>
						<form:input type="password" path="password" id="password"
							placeholder="Your Password" tabindex="6"></form:input>
						<span class="errorMessage"> <form:errors path="password"></form:errors>
						</span>
					</div>
				</div>
			</div>
			<input type="submit" value="Register" id="registerbtn">
		</form:form>
	</div>
	<hr>
	<%@ include file="footer.jsp"%>
</body>
</html>