<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DAO.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String Car_number=request.getParameter("Car_number");
		String User_name=request.getParameter("User_name");
		String User_phone1=request.getParameter("User_phone1");
		String User_phone2=request.getParameter("User_phone2");
		String User_phone3=request.getParameter("User_phone3");
		String User_mail=request.getParameter("User_mail");
		
		DB_Connection db = new DB_Connection();
		
		String User_phone = User_phone1 + User_phone2 + User_phone3;
		
		db.insertWishSellList(Car_number, User_name, User_phone, User_mail);
		
		out.println("구매차량 번호 :" + Car_number + "<br>");
		out.println("이름 :" + User_name + "<br>");
		out.println("연락처 :" + User_phone + "<br>");
		out.println("이메일 :" + User_mail + "<br>");
		
		out.println("위 정보로 판매희망접수가 완료되었습니다.");	
	%>
	
	<form action="Board_Main.jsp" method="post">
		<input type="submit" value="초기화면으로" name="">
	</form>
</body>
</html>
