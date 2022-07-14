<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<link rel="stylesheet" href="../css/default.css">
<link rel="stylesheet" href="../css/header.css">
<style type="text/css">
html, body {
   margin: 0;
}
</style>
</head>
<body>
<header>
	<%@ include file="/incl/header.jsp" %>
</header>
<div id="map" style="width:100%;height:100vh;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1b4ff6e20d754b853ba624fa3a2f172d"></script>
<script>
   var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
       mapOption = { 
           center: new kakao.maps.LatLng(35.8660426, 128.5938422), // 지도의 중심좌표
           level: 3 // 지도의 확대 레벨
       };
   
   // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
   var map = new kakao.maps.Map(mapContainer, mapOption);
   
   // 현재 위치 좌표
   var markerPosition  = new kakao.maps.LatLng(35.8660426, 128.5938422);
   
   var listName = new Array(); // 주차장이름 담을 배열
   var listX = new Array(); // 주차장 좌표x 담을 배열
   var listY = new Array(); // 주파장 좌표y 담을 배열

   <c:forEach var="parking" items="${ParkingLotList}">
   		listName.push("${parking.parkingName}");
	  	listX.push("${parking.pointX}");
	  	listY.push("${parking.pointY}");
   </c:forEach>
   
   // 마커를 표시할 위치와 title 객체
   var positions = [];
   
   for(let i = 0; i < listX.length; i++) {
	   positions.push({
		   title: listName[i],
	       latlng: new kakao.maps.LatLng(listX[i], listY[i])
	   });
   }
   
   // 마커 생성
   // 현재 위치 마커
   var marker = new kakao.maps.Marker({
        position: markerPosition
    });
   
   // 주차장 위치 마커
   for(let i = 0; i < positions.length; i++) {
	   
	   // 마커 생성
	   let marker = new kakao.maps.Marker({
		   map: map, // 마커를 표시할 지도
		   position: positions[i].latlng, // 마커 표시 위치
		   title: positions[i].title, // 마커 타이틀
	   });
	   
	   // 아래 코드는 위의 마커를 생성하는 코드에서 clickable: true 와 같이
	   // 마커를 클릭했을 때 지도의 클릭 이벤트가 발생하지 않도록 설정합니다
	   marker.setClickable(true);
	    
	   // 마커에 클릭이벤트를 등록합니다
	   kakao.maps.event.addListener(marker, 'click', function() {

	   // 마커 위에 인포윈도우를 표시합니다
	   location.href = '/chacha/parking/get_parking_point.do?pointX=' + listX[i] + '&pointY=' + listY[i] + "'";
	   });
	   
   }

    
    // 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    
    // 현재 위치 마커 위에 콘텐츠 표시
    var content = '<div style="width: 85px; height: 26px; margin-top: -70px; background: white; border: 1px solid lightgray; font-size: 16px; text-align: center;">현재 위치</div>';
    var position = new kakao.maps.LatLng(35.8660426, 128.5938422);
    
    // 커스텀 오버레이 생성 생성
    var customOverlay = new kakao.maps.CustomOverlay({
    	position: position,
    	content: content
    });
    
    // 커스텀 오버레이 지도에 표시
    customOverlay.setMap(map);
    // 아래 코드는 지도 위의 마커를 제거하는 코드입니다
    // marker.setMap(null);
    
</script>
</body>
</html>