<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="slider">
            <div class="slides">
                <input type="radio" name="radio-btn" id="radio1">
                <input type="radio" name="radio-btn" id="radio2">
                <input type="radio" name="radio-btn" id="radio3">
                <input type="radio" name="radio-btn" id="radio4">
                <div class="slide-show first">
                    <img src="<c:url value="/resources/images/slider/slider1.jpg"/>" alt="slider1">
                </div>
                <div class="slide-show">
                    <img src="<c:url value="/resources/images/slider/slider2.jpg"/>" alt="slider2">
                </div>
                <div class="slide-show">
                    <img src="<c:url value="/resources/images/slider/slider3.jpg"/>" alt="slider3">
                </div>
                <div class="slide-show">
                    <img src="<c:url value="/resources/images/slider/slider4.jpg"/>" alt="slider4">
                </div>

            </div>
            <div class="manual-navigate">
                <label for="radio1" class="manual-btn active"></label>
                <label for="radio2" class="manual-btn"></label>
                <label for="radio3" class="manual-btn"></label>
                <label for="radio4" class="manual-btn"></label>
            </div>
        </div>
</body>
</html>