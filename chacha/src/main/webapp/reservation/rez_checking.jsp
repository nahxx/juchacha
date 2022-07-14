<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/default.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/reservation.css">
</head>
<body>
	<header>
		<%@ include file="/incl/header.jsp" %>
	</header>
	<div class="wrap">
		<h3>예약조회</h3>
		<div class="rezInfo">
			${rListStr}
		</div>
	</div>
</body>
</html>