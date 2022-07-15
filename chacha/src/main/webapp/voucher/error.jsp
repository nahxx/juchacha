<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<link rel="stylesheet" href="../css/default.css">
<link rel="stylesheet" href="../css/header.css">
<style>
.title-wrap {
	   text-align: center;
	   margin-bottom: 30px;
	}
	.title-wrap .title {
	   display: inline-block;
	   height: 100%;
	   font-size: 36px;
	   text-align: center;
	   padding: 0 8px;
	   position: relative;
	}
	.title-wrap .title:before {
	   position: absolute;
	   content: '';
	   width: 100%;
	   height: 14px;
	   bottom: 7px;
	   left: 0;
	   z-index: -1;
	   background: #EDE6DB;
	}

.wrapper {
	width: 975px;
	margin: 100px auto 	0;
}

.form .option_item{
	display: block;
	position: relative;
	width: 175px;
	height: 175px;
	margin: 10px;
}

.option_item .option_inner {
	width: 100%;
	height: 100%;
	background: #fff;
	border-radius: 5px;
	text-align: center;
	padding: 58px 40px;
	cursor: pointer;
	display: block;
	border: 5px solid #1D5C63;
	position: relative;
}

.option_item .checkbox {
	position: absolute;
	top: 10px;
	right: 10px;
}

.option_item .option_inner .icon {
	margin-bottom: 10px;
}
.option_item .option_inner .icon .fab {
	font-size: 32px;
}

.option_item .option_inner .name {
	user-select: none;
	font-size: 20px;
}

.option_item .checkbox:checked ~ .option_inner{
	border-color: #417D7A;
	color: black;
}

.option_item .option_inner .tickmark{
	position: absolute;
	top: 0px;
	right: 0px;
	border: 20px solid;
	border-color: #417D7A;
	display: none;
}

.option_item .checkbox:checked ~ .option_inner .tickmark{
	display: block;
}

.option_item .option_inner .tickmark:before{
	content: "";
	position: absolute;
	top: -11px;
	left: -8px;
	width: 15px;
	height: 5px;
	border: 3px solid;
	border-color: transparent transparent #fff #fff;
	transform: rotate(-45deg);
}
.wrap {
width: 1000px;
height: 200px;
display : flex; 
}

.i-btn {
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 30px;
      padding: 0 80px;
      height: 100%;
      width: 100%;
    }
    .i-btn > button {
      justify-content: center;
      margin-left: 75px;
      border-style: none;
      font-size: 20px;
      background: #417D7A;
      color: white;
      border-radius: 30px;
      width: 150px;
      height: 50px;
      cursor: pointer;
    }
    .i-btn > button > a {
        line-height: 56px;
        display: inline-flex;
    }
</style>
</head>
<body>
	<div id="header">
		<%@ include file="/incl/header.jsp" %>
	</div>
<div class="wrapper">
	<form name="form">
	<div class ="wrap">
		<div>
			<label class="option_item">
			<div class="option_inner">
				<div class="name">구매하실 사항을 선택해주시길 바랍니다.</div>
			</div>
			</label>
		</div>
		</div>
	<div class="i-btn">
	   <button type="button" class="btn" ><a href="/chacha/voucher/voucher.jsp">주차권 구매로 이동</a></button>
	 </div>
	</form>	
</div>
</body>
</html>