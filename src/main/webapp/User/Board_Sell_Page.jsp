<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>	
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="DTO.*" %>
<%@ page import="DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중고차는 역시 호카!</title>
<style>
.main {
	width: 1200px;
	height: 300px;
	text-align: center;
	position : relative;
}
header {
	background-color: #FFDEAD;
	width:1200px;
	height: 50px;
	text-align: center;
	padding:10px;
}
footer {
	width: 1200px;
	height: 50px;
	background-color:#FFDEAD;
	text-align: center;
	padding:10px;
	}
</style>
</head>
<body>
<%
String id = String.valueOf(session.getAttribute("id"));

userDao userDao = new userDao();

ArrayList<userVo> userDtos = new ArrayList<userVo>();
		
userDtos = userDao.getIDInfo(id);

String userName = userDtos.get(0).getName();
String userPhone = userDtos.get(0).getPhone_num();
String userEmail = userDtos.get(0).getEmail();
String userEmail2 = userDtos.get(0).getEmail2();
%>
	<header>
		<H1>HOCAR 차량 판매 등록</H1>
	</header>
	<br>
	
	<div class = "main">
	<form action="Wish_Sell_List.jsp" method="post" class="form">
			<div>
				<label>판매차량 번호</label><input type="text" name="Car_number"
					placeholder="03가3523" required>
			</div>
			<br>
			<div>
				<label>이름</label> <input type="text" name="User_name"
					value="<%=userName%>" required>
			</div>
			<br>
			<div>
				<label>연락처</label> <input type="text" name="User_phone1"
					value="<%=userPhone.substring(0, 3)%>" required size=3 maxlength=3> &nbsp; <input
					type="text" name="User_phone2" value="<%=userPhone.substring(4, 8)%>" required size=4
					maxlength=4> &nbsp; <input type="text" name="User_phone3"
					value="<%=userPhone.substring(9, 13)%>" required size=4 maxlength=4><br>
			</div>
			<br>
			<div>
				<label>이메일</label> <input type="text" name="User_mail"
					value="<%=userEmail%>@<%=userEmail2%>" required>
			</div>
			<br>
			<button type="submit">판매등록</button>
		</form>
	</div>
	<br>
	
	<footer>
		<div>*안내*</div>
		<div>*판매 등록 이후 1~2일 영업일 내 담당자가 연락 드리겠습니다</div>
	</footer>
</body>
</html>
