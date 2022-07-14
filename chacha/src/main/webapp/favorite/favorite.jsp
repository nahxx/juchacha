<%@page import="java.net.URLEncoder, java.util.*"%>
<%@page import="com.teamecho.chacha.parking.domain.ParkingLot"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

.container > .content-wrapper {
    display: flex;
    height: 100%;
    align-items: flex-start;
    width: 100%;
    padding: 0 80px;
    flex-wrap: wrap;
 }

.content {
	height: 50px;
	width: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 30px;
}

.list {
	height: 70%;
	margin-top: 0;
}
.info-list {
	padding: 0 150px;
}
.info-list li {
	width: 100%;
	height: 50px;
	text-align: center;
	border-bottom: 1px solid #b1b1b1;
	margin-left: 0;
}
.info-list li > a {
	color: #000;
	height: 100%;
	width: 100%;
	font-size: 18px;
}

</style>
</head>
<% 
	String userId = (String)session.getAttribute("userId");
	ParkingLot parkingName = (ParkingLot)session.getAttribute("parkingName");
%>
<header>
	<%@ include file="/incl/header.jsp" %>
</header>
<body>
<section>
    <div class="container">
      <div class="title-wrap">
        <h3 class="title">즐겨찾기 리스트</h3>
      </div>
      <div class="content-wrapper">
        <div class="content">
          <label><h4>회원아이디 :</h4></label>&nbsp;<%= userId %>
        </div>
			<div class="content list">
				<ul class="info-list">
					<c:forEach items="${list}" var ="list">
						<li>${list.getPid()}</li>
					</c:forEach>
				</ul>
			</div>
      </div>
    </div>
  </section>

</html>