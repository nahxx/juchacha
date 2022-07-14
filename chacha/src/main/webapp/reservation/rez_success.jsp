<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../css/default.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/reservation.css">
<title>주차차</title>
</head>
<body>
	<header>
		<%@ include file="/incl/header.jsp" %>
	</header>
	<div class="wrap">
		<p class="success"><span class="color">예약완료</span>되었습니다.</p>
		<button class="btn" onclick="location.href='/chacha/parkinglot/get_parking.do'">홈으로 가기</button>
	</div>
<p>예약완료</p>
</body>
</html>