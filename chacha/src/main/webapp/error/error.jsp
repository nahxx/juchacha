<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<style>
@font-face {
	src: url("/chacha/css/Jalnan.ttf");
	font-family: "Jalnan";
}

.gnb ul li a {
	line-height: 70px;
	font-size: 20px;
	color: white;
	font-family: "Jalnan";
}

body, html {
	width: 100%;
	height: 100%;
	overflow: hidden;
}

* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

ul, li {
	list-style: none;
}

a {
	text-decoration: none;
	color: #333;
}

#header {
	height: 80px;
	width: 100%;
	text-align: center;
	font-size: 20px;
	background: #417D7A;
}

#header.login_on {
	position: fixed;
	z-index: 10;
}

.header-wrap {
	height: 100%;
	width: 60%;
	margin: 0 auto;
	position: relative;
}

.logo {
	position: absolute;
	display: inline-block;
	height: 100%;
	width: 80px;
	left: 0;
	padding: 5px 0;
}

.juchacha {
	display: block;
	height: 70px;
	width: 70px;
	background-image: url("../image/logo.png");
	background-repeat: no-repeat;
	background-size: contain;
	background-position: center;
}

.gnb {
	padding-left: 90px;
	width: 100%;
	height: 100%;
}

.gnb .left-gnb {
	float: left;
	height: 100%;
}

.gnb .right-gnb {
	float: right;
	height: 100%;
}

ul {
	height: 100%;
	padding: 5px 0;
}

.gnb ul li {
	float: left;
	height: 100%;
	margin-left: 30px;
}

ul li:first-child {
	margin-left: 0;
}

#header a {
	line-height: 70px;
	font-size: 20px;
	color: white;
}

#header a:hover {
	color: white;
	font-weight: 600;
}

section {
	height: 100%;
	overflow: hidden;
	padding-bottom: 240px;
}

.container {
	display: flex;
	flex-wrap: wrap;
	height: 100%;
	width: 700px;
	margin: 0 auto;
	align-items: center;
}

.container .title-wrap {
	width: 100%;
	line-height: 60px;
	padding-top: 150px;
	text-align: center;
}

.container .title-wrap .title {
	display: inline-block;
	height: 100%;
	font-size: 36px;
	text-align: center;
	padding: 0 8px;
	position: relative;
	font-family: "Jalnan";
}

.container .title-wrap .title:before {
	position: absolute;
	content: '';
	width: 100%;
	height: 14px;
	bottom: 7px;
	left: 0;
	z-index: -1;
	background: #EDE6DB;
}

.container>.content-wrapper {
	display: flex;
	height: 100%;
	align-items: flex-start;
	width: 100%;
	padding: 0 80px;
	flex-wrap: wrap;
}

.content {
	height: 200px;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 30px;
	font-family: "Jalnan";
	flex-wrap: wrap;
}

.content .error {
	height: 100%;
	width: 100%;
}

.error li {
	width: 100%;
	color: red;
	font-size: 18px;
	margin: 10px 0;
}

#footer {
	height: 160px;
	background: #f1f1f1;
}

.copyright {
	width: 700px;
	height: 100%;
	margin: 0 auto;
	position: relative;
	padding-top: 40px;
}

.btn-group {
	display: flex;
	width: 100%;
	height: 50px;
	margin-top: 30px;
	justify-content: center;
}

.i-btn {
	display: flex;
	justify-content: space-around;
	height: 100%;
	width: 60%;
}

.i-btn .btn {
	display: flex;
	justify-content: center;
	height: 100%;
	background: #417D7A;
	border-radius: 30px;
	width: 150px;
	height: 50px;
}

button.btn-inner {
	color: white;
	border-style: none;
	height: 100%;
	width: 75px;
	font-size: 20px;
	background: none;
	cursor: pointer;
	font-family: "Jalnan";
}

.i-btn .in-btn {
	font-size: 20px;
	color: white;
	line-height: 50px;
	text-align: center;
	font-family: "Jalnan";
}

.i-btn .in-btn:hover {
	font-weight: normal;
}

.copyright-logo {
	position: absolute;
	right: 0;
	top: 40px;
	width: 80px;
	height: 80px;
	background-image: url("/chacha/image/logo.png");
}

.copyright-txt p {
	margin-top: 5px;
}

.copyright .copyright-logo a {
	color: transparent;
}

.copyright a, .copyright p {
	font-size: 15px;
}
</style>
</head>
<header>
	<%@ include file="/incl/no_login_header.jsp"%>
</header>
<body>
	<section>
		<div class="container">
			<div class="title-wrap">
				<h3 class="title">오류발생</h3>
			</div>
			<div class="content-wrapper">
				<div class="content">
					<c:if test="${not empty error}">
						<ul class="error">
							<c:forEach var="errorMsg" items="${error}">
								<li>* ${errorMsg}</li>
							</c:forEach>
						</ul>
					</c:if>
					<div class="btn-group">
						<div class="i-btn">
			                <div class="btn">
			                  <a href="/chacha/user/add_user.jsp" class="in-btn">되돌아가기</a>
			                </div>
		              	</div>
	              	</div>
				</div>
			</div>
		</div>
	<footer>
		<%@ include file="/incl/footer.jsp"%>
	</footer>
	</section>

</body>
</html>