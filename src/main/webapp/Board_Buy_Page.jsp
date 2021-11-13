<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
Buy_list {
	border: 20px solid lightblue;
	padding: 5px 20px;
	position: absolute;
	top: 50%;
	left: 50%;
	width: 450px;
	height: 250px;
	margin-left: -220px;
	margin-top: -170px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-item: center;
}
h1 {
	font- =size: 25px;
	padding-bottom: 20px;
}
.form {
	width: 300px;
}
.form>div {
	display: flex;
	justify-content: center;
	padding-bottom: 7px;
	align-items: center;
}
label {
	flex: 1;
	text-align: left;
}
button {
	width: 85px;
	float: right;
	padding: 3px;
}
input {
	padding: 5px;
}
</style>
</head>
<body>

<%
DecimalFormat formatter = new DecimalFormat("###,###");
%>

	<div id="Buy_list">
		<h1>
			<img src="hocar.PNG" width=300px height=150px>
		</h1>
		<div>
			구매차량 정보<br>
			<%
			request.setCharacterEncoding("UTF-8");
			String carNumber = request.getParameter("carNumber");
			out.println("차량번호 : "+carNumber);
			out.print("<br>");
			String carName = request.getParameter("carName");
			out.println("차량명 : "+carName);
			out.print("<br>");
			String company = request.getParameter("company");
			out.println("제조사 : "+company);
			out.print("<br>");
			String price = request.getParameter("price");
			int intPrice = Integer.parseInt(price);
			out.println("가격 : "+ formatter.format(intPrice)+"만원");
		%>

		</div>
		<br>


		<form action="Wish_Buy_List.jsp" method="post" class="form">
			<div>
				<label>이름</label> <input type="text" name="User_name"
					placeholder="김민수" required>
			</div>

			<div>
				<label>연락처</label> <input type="text" name="User_phone1"
					placeholder=010 required size=3 maxlength=3> &nbsp; <input
					type="text" name="User_phone2" placeholder=1234 required size=4
					maxlength=4> &nbsp; <input type="text" name="User_phone3"
					placeholder=5678 required size=4 maxlength=4><br>
			</div>
			<div>
				<label>이메일</label> <input type="text" name="User_mail"
					placeholder="shj0022@gmail.com" required>
			</div>
			
			<input type="hidden" name="carNumber" value="<%=carNumber%>">
			<input type="submit" value="구매" name="">


		</form>
	</div>
</body>
</html>
