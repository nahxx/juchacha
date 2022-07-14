<%@page import="java.net.URLEncoder, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<link rel="stylesheet" href="../css/header.css">
<style>
section {
	height: 100%;
	overflow: hidden;
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
	padding-top: 100px;
}

.container .title-wrap .title {
	height: 100%;
	font-size: 36px;
	text-align: center;
}

.container>#content-wrapper {
	display: flex;
	height: 100%;
	align-items: flex-start;
	width: 100%;
	padding: 0 80px;
}

.content {
	width: 100%;
}

.favo {
	padding-top: 20px;
	width: 100%;
}

.inputContainer {
    margin-bottom: 50px;
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
}

.i-btn .in-btn {
	font-size: 20px;
	color: white;
	line-height: 50px;
	text-align: center;
}

.i-btn .in-btn:hover {
	font-weight: normal;
}
</style>
</head>
</head>
<body>
<%
String uid = (String)session.getAttribute("uid");
%>
	<div id="header">
		<%@ include file="/incl/no_login_header.jsp"%>
	</div>
	<h3 class="title">즐겨찾기</h3>
	<div class="container">
		<form action="favorite.do" class="favo" method="post">
			<div class="inputContainer">
			사용자 : <input type="text" name="uid" />
			주차장 : <input type="text" name="pid" />
			</div>
			<div class="i-btn">
				<div class="btn">
					<button type="submit" class="btn-inner">리스트</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>