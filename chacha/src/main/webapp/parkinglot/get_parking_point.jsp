<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>주차장정보</title>
  <link rel="stylesheet" href="../css/default.css">
  <link rel="stylesheet" href="../css/header.css">
  <style>
  body, html { overflow: scroll;}
    .wrap {
      width: 100%;
      height: calc(100vh - 30px);
    }

    .parkingloth1 {
      margin-top: 40px;
    }

    h1,
    h2,
    h4 {
      text-align: center;
    }

    table {
      margin: 0 auto;
      margin-bottom: 20px;
      font-size: 18px;
      font-weight: 700;
      border-collapse: collapse;
      border: 1px solid lightgray;
    }

    .btn {
      display: block;
      width: 150px;
      height: 50px;
      margin: 0 auto;
      margin-top: 40px;
      background: #417D7A;
      border: none;
      border-radius: 30px;
      line-height: 50px;
      text-align: center;
      font-size: 20px;
      color: white;
    }

    .cost,
    .space,
    .review {
      width: 800px;
      height: 200px;
    }

    .cost thead tr th,
    .space thead tr th,
    .review thead tr th {
      background-color: #417D7A;
      color: #fff;
      height: 40px;
    }

    .cost tbody tr td:first-child {
      width: 200px;
      background-color: #417D7A;
      text-align: center;
      color: #fff;
    }

    .cost tbody tr td:last-child {
      text-align: right;
    }

    .space tbody tr td:first-child {
      width: 200px;
      background-color: #417D7A;
      text-align: center;
      color: #fff;
    }

    .space tbody tr td:last-child {
      text-align: right;
    }

    .review {
      margin-top: 20px;
    }

    .review tbody tr:nth-child(1) {
      background-color: #417D7A;
      color: #fff;
      height: 40px;
      text-align: center;
    }

    .review tbody tr.review-header {
      height: 30px;
      text-align: center;
    }

    .review tbody tr.review-content {
      height: 150px;
    }

    .review tbody tr.review-content td:first-child {
      background-color: #417D7A;
      color: #fff;
      text-align: center;
    }
  </style>
</head>

<body>
  <header>
    <%@ include file="/incl/no_login_header.jsp" %>
  </header> 
  <div class="wrap">
    <h1 class="parkingloth1">${ParkingLot.getParkingName()}</h1>
    <h2>${ParkingLot.getParkingAddr()}</h2>
    <h4>${ParkingLot.getParkingTel()}</h4>
    <table border="1" class="cost">
      <thead>
        <tr>
          <th colspan="2">요금</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>시간당</td>
          <td>${ParkingLot.getTimeCost()} 원</td>
        </tr>
        <tr>
          <td>종일권</td>
          <td>${ParkingLot.getDayCost()} 원</td>
        </tr>
        <tr>
          <td>정기권</td>
          <td>${ParkingLot.getMonthCost()} 원</td>
        </tr>
      </tbody>
    </table>
    <table border="1" class="space">
      <thead>
        <tr>
          <th colspan="2">주차가능한 자리</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>주차장 주차공간</td>
          <td>${ParkingLot.getParkingSpace()} 대</td>
        </tr>
        <tr>
          <td>현재 주차중인 차량 수</td>
          <td>${space} 대</td>
        </tr>
      </tbody>
    </table>
    <input type="button" class="btn" value="예약페이지" onClick="location.href='/chacha/reservation/rez.do?pid=${ParkingLot.getPid()}'">

    <table border="1" class="review">
      <thead>
        <tr>
          <th colspan="3">리뷰</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>사용자</td>
          <td>별점</td>
          <td>작성일</td>
        </tr>
        <c:forEach var="re" items="${review}">
          <tr class="review-header">
            <td>사용자</td>
            <td>${re.getStar_rating()}</td>
            <td>${re.getRegDate()}</td>
          </tr>
          <tr class="review-content">
            <td>내용</td>
            <td colspan="2">${re.getContent()}</td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</body>

</html>