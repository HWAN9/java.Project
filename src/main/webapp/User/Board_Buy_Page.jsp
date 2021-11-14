<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="DTO.*" %>
<%@ page import="DAO.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고차는 역시 호카!</title>
<style>
main {
	width: 1200px;
	height: 0px;
	text-align: center;
	position : relative;
	right:0px;
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
<%
DecimalFormat formatter = new DecimalFormat("###,###");
%>
	<header>
		<H1>HOCAR 차량구매</H1>
	</header>
	<br>

	<main>
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
			
			String id = String.valueOf(session.getAttribute("id"));
			
			userDao userDao = new userDao();
			
			ArrayList<userVo> userDtos = new ArrayList<userVo>();
					
			userDtos = userDao.getIDInfo(id);
			
			String userName = userDtos.get(0).getName();
			String userPhone = userDtos.get(0).getPhone_num();
			String userEmail = userDtos.get(0).getEmail();
			String userEmail2 = userDtos.get(0).getEmail2();
		
		%>
		</div>
		<br>
		
		<form action="Wish_Buy_List.jsp" method="post" class="form">
			<div>
				<label>이름</label> <input type="text" name="User_name"
					value="<%=userName%>" required>
			</div>
			
			<div>
				<label>연락처</label> <input type="text" name="User_phone1"
					value="<%=userPhone.substring(0, 3)%>"required size=3 maxlength=3> &nbsp; <input
					type="text" name="User_phone2" value="<%=userPhone.substring(4, 8)%>" required size=4
					maxlength=4> &nbsp; <input type="text" name="User_phone3"
					value="<%=userPhone.substring(9, 13)%>" required size=4 maxlength=4><br>
			</div>
			<div>
				<label>이메일</label> <input type="text" name="User_mail"
					value="<%=userEmail%>@<%=userEmail2%>" required>
			</div>
			<br>
			
			<input type="hidden" name="carNumber" value="<%=carNumber%>">
			<input type="submit" value="구매등록" name="">
		</form>
		</main>
		<br>
		<footer style="padding-top: 10px;border-top-style: solid;border-top-width: 0px;margin-top: 250px;">
			<div>*안내*</div>
			<div>*구매 등록 이후 1~2일 영업일 내 담당자가 연락 드리겠습니다</div>
		</footer>
</body>
</html>
