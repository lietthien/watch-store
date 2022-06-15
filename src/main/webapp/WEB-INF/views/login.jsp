<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" />
<link rel="shortcut icon" href="<c:url value="/resources/images/logo/favicon.ico"/>"
	type="image/x-icon">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Login Page</title>
</head>

<body>
	<%@ include file="header.jsp"%>
<!-- login-form form -->
<h3 style="text-align: center;color: red;padding-top: 12px;">${successMessage}</h3>
<h3 style="text-align: center;color: red;padding-top: 12px;">${loginFailedMessage}</h3>
<h3 style="text-align: center;color: red;padding-top: 12px;">${loginFirst}</h3>

        <div class="login-form">
            <h2>Login Form</h2>
            <form action="<c:url value="/user/login"/>" method="post">
                <div class="loginform-body">
                    <input type="text" name="email" id="email" placeholder="Enter Your Email">
                    <input type="password" name="password" id="password" placeholder="Enter your Password">
                </div>
                <input type="submit" value="login" id="loginbtn">
            </form>

        </div>
	<%@ include file="footer.jsp"%>
</body>
</html>