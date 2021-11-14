<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
main {
	
	width: 1200px;
	height: 0px;
	text-align: center;
	position : relative;
	right:450px;
	top :0px;
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

	<header>
		<H1>HOCAR 차량구매</H1>
	</header>
	<br>

	<main>
		<div>
			구매차량 정보<br>
			<%
			request.setCharacterEncoding("UTF-8");
			String number = request.getParameter("carname");
			out.println("차량번호 : "+number);
			out.print("<br>");
			String number2 = request.getParameter("carname2");
			out.println("차량명 : "+number2);
			out.print("<br>");
			String number3 = request.getParameter("carname3");
			out.println("제조사 : "+number3);
			out.print("<br>");
			String number4 = request.getParameter("carname4");
			out.println("가격 : "+number4+"만원");
		%>

		</div>	
		<br>

		<form action="Wish_Buy_List.jsp" method="post" class="form">
			<div>
				<label>이름</label> <input type="text" name="User_name"
					placeholder="김민수" required>
			</div>
			<br>

			<div>
				<label>연락처</label> <input type="text" name="User_phone1"
					placeholder=010 required size=3 maxlength=3> &nbsp; <input
					type="text" name="User_phone2" placeholder=1234 required size=4
					maxlength=4> &nbsp; <input type="text" name="User_phone3"
					placeholder=5678 required size=4 maxlength=4><br>
			</div>
			<br>
			<div>
				<label>이메일</label> <input type="text" name="User_mail"
					placeholder="shj0022@gmail.com" required>
			</div>
			<br>
			<input type="hidden" name="carname" value="<%=number%>"> <input
				type="submit" value="구매등록" name="ddfde">
			</form>
			
				
	</main>
	<br>

	<footer>
		<div>*안내*</div>
		<div>*구매 등록 이후 1~2일 영업일 내 담당자가 연락 드리겠습니다</div>
		<div></div>
		
	</footer>

</body>
</html>
