<%@page import="java.net.URLEncoder, java.util.*"%>
<%@page import="com.teamecho.chacha.parking.domain.ParkingLot"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<link rel="stylesheet" href="../css/default.css">
<link rel="stylesheet" href="../css/header.css">
<link rel="stylesheet" href="../css/reservation.css">
</head>
<% 
	String userId = (String)session.getAttribute("userId");
	ParkingLot parkingName = (ParkingLot)session.getAttribute("parkingName");
%>
<body>
	<header>
		<%@ include file="/incl/header.jsp" %>
	</header>
    <div class="wrap">
      <h3><%= userId %>님의 즐겨찾기 리스트</h3>
      <c:forEach var="fav" items="${favorites}">
      	<div class="rezInfo">
			<table>	
				<tbody>
					<tr>
						<th>주차장명</th>
						<td>>시원유료주차장</td>
					</tr>
					<tr>
						<th>주차장위치</th>
						<td>>대구광역시 중구 덕산동 124-40</td>
					</tr>
					<tr>
						<th>주차장번호</th>
						<td>>053-425-8109</td>
					</tr>
				</tbody>
			</table>
		</div>
      </c:forEach>
		<div class="rezInfo">
			<table>	
				<tbody>
					<tr>
						<th>주차장명</th>
						<td>>시원유료주차장</td>
					</tr>
					<tr>
						<th>주차장위치</th>
						<td>>대구광역시 중구 덕산동 124-40</td>
					</tr>
					<tr>
						<th>주차장번호</th>
						<td>>053-425-8109</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="rezInfo">
			<table>	
				<tbody>
					<tr>
						<th>주차장명</th>
						<td>>시원유료주차장</td>
					</tr>
					<tr>
						<th>주차장위치</th>
						<td>>대구광역시 중구 덕산동 124-40</td>
					</tr>
					<tr>
						<th>주차장번호</th>
						<td>>053-425-8109</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="rezInfo">
			<table>	
				<tbody>
					<tr>
						<th>주차장명</th>
						<td>>시원유료주차장</td>
					</tr>
					<tr>
						<th>주차장위치</th>
						<td>>대구광역시 중구 덕산동 124-40</td>
					</tr>
					<tr>
						<th>주차장번호</th>
						<td>>053-425-8109</td>
					</tr>
				</tbody>
			</table>
		</div>
    </div>
</html>