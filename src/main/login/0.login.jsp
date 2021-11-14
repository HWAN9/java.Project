<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

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

</head>
<body>

	<header>
	<H1>HOCAR 로그인</H1>
	</header>
	<br>

	<div class="main">
	<form METHOD="post" ACTION="0.login_branch.jsp">
		아이디 : <input type="text" name="id"> &nbsp;&nbsp;&nbsp;&nbsp;
		비밀번호 : <input type="password" name="pw">
	</form>
	<br>
	<form>
		<input type="submit" value="로그인">
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
