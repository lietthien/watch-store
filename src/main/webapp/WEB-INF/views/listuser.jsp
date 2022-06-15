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
        <div class="user-manage">
            <h1>User List</h1>
            <table class="ad-list-user">
                <tr>
                    <th>User ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Phone Number</th>
                    <th>Email</th>
                    <th>Password</th>
                    <th>Address</th>
                    <th>Role</th>
                </tr>
                <c:forEach items="${allUser}" var="user">
                <tr>
                    <td class="ad-user-id">${user.userid}</td>
                    <td class="ad-firstname">${user.firstname}</td>
                    <td class="ad-lastname">${user.lastname}</td>
                    <td class="ad-phonenumber">${user.phonenumber}</td>
                    <td class="ad-email">${user.email}</td>
                    <td class="ad-password">${user.password}</td>
                    <td class="ad-address">${user.address}</td>
                    <td class="ad-role">${user.role}</td>
                </tr>
               </c:forEach>
            </table>
        </div>
	<%@ include file="footer.jsp"%>
	
	
</body>
</html>