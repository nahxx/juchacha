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
.btn {
display : block;
float : right;
}
</style>
</head>
<body>
	<div id="header">
		<%@ include file="/incl/header.jsp" %>
	</div>
<div class="wrapper">
		<div class="title-wrap">
        	<h3 class="title">주차권 구입</h3>
     	</div>
	<form name="form" action="voucher.do" method="post" class="form">
	<div class ="wrap">
		<div>
			<label class="option_item">
			<input type="checkbox" class="checkbox" name="voucher" value="A.1">
			<div class="option_inner">
				<div class="tickmark"></div>
				<div class="name">1시간 <br> 주차권</div>
			</div>
			</label>
		</div>
		<div>
			<label class="option_item">
			<input type="checkbox" class="checkbox" name="voucher" value="A.3">
			<div class="option_inner">
				<div class="tickmark"></div>
				<div class="name">3시간 <br> 주차권</div>
			</div>
			</label>
		</div>
		<div>
			<label class="option_item">
			<input type="checkbox" class="checkbox" name="voucher" value="A.5">
			<div class="option_inner">
				<div class="tickmark"></div>
				<div class="name">5시간 <br> 주차권</div>
			</div>
			</label>
		</div>
		<div>
			<label class="option_item">
			<input type="checkbox" class="checkbox" name="voucher" value="B.0">
			<div class="option_inner">
				<div class="tickmark"></div>
				<div class="icon">
					<i class="fab" aria-hidden="true"></i>
				</div>
				<div class="name">종일권</div>
			</div>
			</label>
		</div>
		<div>
			<label class="option_item">
			<input type="checkbox" class="checkbox" name="voucher" value="C.0">
			<div class="option_inner">
				<div class="tickmark"></div>
				<div class="icon">
					<i class="fab" aria-hidden="true"></i>
				</div>
				<div class="name">정기권</div>
			</div>
			</label>
		</div>
		</div>
	   <input type="submit" class="btn" value="구매하기">
	</form>	

</div>
</body>
</html>