<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주차차</title>
<script type="text/javascript" src="../js/jquery.js"></script>
</head>
<body>
	<div class="wrap">
      <div class="parkingInfo">
        <table>
          <tr>
            <th>주차장명</th>
            <td>ooo주차장</td>
          </tr>
          <tr>
            <th>연락처</th>
            <td>xxx-xxx-xxxx</td>
          </tr>
          <tr>
            <th>주소</th>
            <td>xxx-xxx-xxxx</td>
          </tr>
        </table>
      </div>

      <form class="rez" action="rez.do" method="post">
        <p>주차타입</p>
        <label><input type="radio" name="type" value="A" checked>시간당</label>
        <label><input type="radio" name="type" value="B">종일권</label>
        <label><input type="radio" name="type" value="C">정기권</label>

        <!-- A면 예약 일월, 시작-종료시간 전부 표시
            B면 예약 일월만 표시
            C면 예약 월만 표시-->
        <p>예약일자</p>
        <label>
          <select class="startMonth" name="startMonth">
            <option value="01">1</option>
            <option value="02">2</option>
            <option value="03">3</option>
            <option value="04">4</option>
            <option value="05">5</option>
            <option value="06">6</option>
            <option value="07">7</option>
            <option value="08">8</option>
            <option value="09">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
          </select>
          월
        </label>
        <label>
          <select class="startDate" name="startDate">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
            <option value="11">11</option>
            <option value="12">12</option>
            <option value="13">13</option>
            <option value="14">14</option>
            <option value="15">15</option>
            <option value="16">16</option>
            <option value="17">17</option>
            <option value="18">18</option>
            <option value="19">19</option>
            <option value="20">20</option>
            <option value="21">21</option>
            <option value="22">22</option>
            <option value="23">23</option>
            <option value="24">24</option>
            <option value="25">25</option>
            <option value="26">26</option>
            <option value="27">27</option>
            <option value="28">28</option>
            <option value="29">29</option>
            <option value="10">30</option>
            <option value="11">31</option>
          </select>
          일
        </label>
        <p>예약시간</p>
        <label>시작시간
          <select class="startTime" name="startTime">
            <option value="00">00</option>
            <option value="01">01</option> 
            <option value="02">02</option>
            <option value="03">03</option>  
            <option value="04">04</option> 
            <option value="05">05</option> 
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option> 
            <option value="12">12</option>
            <option value="13">13</option>  
            <option value="14">14</option> 
            <option value="15">15</option> 
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option> 
            <option value="22">22</option>
            <option value="23">23</option>     
          </select>
          시
        </label>
        <label>종료시간
          <select class="endTime" name="endTime">
          	<option value="00" selected>00</option>
            <option value="01">01</option> 
            <option value="02">02</option>
            <option value="03">03</option>  
            <option value="04">04</option> 
            <option value="05">05</option> 
			<option value="06">06</option>
			<option value="07">07</option>
			<option value="08">08</option>
			<option value="09">09</option>
			<option value="10">10</option>
			<option value="11">11</option> 
            <option value="12">12</option>
            <option value="13">13</option>  
            <option value="14">14</option> 
            <option value="15">15</option> 
			<option value="16">16</option>
			<option value="17">17</option>
			<option value="18">18</option>
			<option value="19">19</option>
			<option value="20">20</option>
			<option value="21">21</option> 
            <option value="22">22</option>
            <option value="23">23</option>
            <!-- js에서 주차장의 영업시작시간 및 영업종료시간 받아와서 option 입력
              https://blog.aacii.net/136 참고 -->
          </select>
          시
        </label>

        <input type="submit" name="" value="예약하기">
      </form>
    </div>
    <script type="text/javascript">
   		 $(function() {
    	  let date = new Date();
    	  let month = "0" + (date.getMonth() + 1); // 현재 월
    	  let day = date.getDate(); // 현재 일자
    	  let hour = date.getHours(); // 현재 시
    	  
    	  $('.startMonth').val(month).attr("selected", "selected"); // 현재 월로 selected
    	  $('.startDate').val(day).attr("selected", "selected"); // 현재 일로 selected
    	  $('.startTime').val(hour).attr("selected", "selected"); // 현재 시로 selected
    	  $('.endTime').val(hour + 1).attr("selected", "selected");  // 현재 시 + 1로 selected
    	  
    	  
    	});
    </script>
</body>
</html>