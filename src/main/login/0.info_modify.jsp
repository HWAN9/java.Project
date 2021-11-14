<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="DAO.userDao"%>
<%@page import="DTO.userVo" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<style>
.main {
	width: 1200px;
	height: 200px;
	text-align: center;
	position: relative;
	clear:both;

}

header {
	background-color: #FFDEAD;
	width: 1200px;
	height: 50px;
	text-align: center;

}

footer {
	width: 1200px;
	height: 50px;
	background-color: #FFDEAD;
	text-align: center;
	padding: 10px;
}
</style>

<body>

	<header>
	<H1>개인정보수정</H1>
	</header>
	<br>

	<div class="main">
	<form METHOD="post" ACTION="0.login_branch.jsp">
		아이디를 다시 입력해 주세요 : <input type="text" name="id"><br>
		<input type="submit" value="입력">
	</form>
	<br>
	<form ACTION="0.login_main.jsp">
		<button class="button" onclick="location='0.login_main.jsp'">돌아가기</button>
		</form>
	</div class="main">
	<br>

	<footer>

	<div></div>

	</footer>

</body>
</html>
