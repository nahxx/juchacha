<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko" dir="ltr">

<head>
  <meta charset="utf-8">
  <title>주차장정보</title>
  <link rel="stylesheet" href="../css/default.css">
  <link rel="stylesheet" href="../css/header.css">
  <style>
  .wrap {
  width : 100%;
  height : calc( 100vh - 30px );
  /* background-color : beige; */
}
.parkingloth1 {
  margin-top: 40px;
}
h1, h2, h4 {
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

.cost{
  width: 800px;
  height: 200px;
}
.cost thead tr th, .space thead tr th {
  background-color: #417D7A;
  color: #fff;
  height: 40px;
}
.cost tbody tr td:first-child{
  width: 200px;
  background-color: #417D7A;
  text-align: center;
  color: #fff;
}

.cost tbody tr td:last-child{
  text-align: right;
}
.space {
  width: 800px;
  height: 200px;
}

.space tbody tr td:first-child{
  width: 200px;
  background-color: #417D7A;
  text-align: center;
  color: #fff;
}

.space tbody tr td:last-child{
  text-align: right;
}
  
  </style>
</head>

<body>
<header>
    <!-- include 영역-->
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
    <table border="1" class="space" >
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
    <input type="button" class="btn" value="예약페이지" onClick="location.href='/chacha/reservation/reservation.jsp?pid=${ParkingLot.getPid()}'">
  </div>
</body>

</html>
