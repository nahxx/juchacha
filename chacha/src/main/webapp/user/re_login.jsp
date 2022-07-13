<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<link rel="stylesheet" href="./css/default.css">
<link rel="stylesheet" href="./css/header.css">
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
      padding-top: 150px;
    }
    .container .title-wrap .title {
      height: 100%;
      font-size: 36px;
      text-align: center;
    }
    .container > .form-wrap {
      display: flex;
      height: 100%;
      align-items: flex-start;
      width: 100%;
    }
    .form-wrap > form {
      width: 100%;
    }
    .content {
      height: 50px;
      width: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      margin-top: 30px;
    }
    .content > input {
      height: 35px;
      line-height: 35px;
      padding-left: 5px;
      width: 60%;
      height: 50px;
      font-size: 15px;
    }
    .content > input:focus {
      outline: none;
      border-color: rgba(65, 125, 122, .6);
      box-shadow: 0 0 6px 2px rgba(65, 125, 122, .6);
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
    .i-btn > input {
      justify-content: center;
      border-style: none;
      font-size: 20px;
      background: #417D7A;
      color: white;
      border-radius: 30px;
      width: 150px;
      height: 50px;
      cursor: pointer;
    }
    .i-btn > .in-btn {
      font-size: 20px;
      background: #417D7A;
      color: white;
      border-radius: 30px;
      width: 150px;
      height: 50px;
      line-height: 50px;
      text-align: center;
    }
    .i-btn > .in-btn:hover {
      font-weight: normal;
    }
  </style>
</head>
<body>
<header>
    <!-- include 영역-->
    <%@ include file="/incl/no_login_header.jsp" %>
  </header>
  <!-- 바디영역 -->
  <section>
    <div class="container">
      <div class="title-wrap">
        <h3 class="title">로그인</h3>
      </div>
      <div class="form-wrap">
        <form action="login.do" method="post">
          <div class="content">
            <input type="text" name="userId" placeholder="아이디" /><br>
          </div>
          <div class="content">
            <input type="password" name="passwd" placeholder="비밀번호" /><br>
          </div>
          <div class="btn-group">
            <div class="i-btn">
              <input type="submit" value="로그인" class="in-btn" />
              <a href="./user/add_user.jsp" class="in-btn">회원가입</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </section>
</body>
</html>