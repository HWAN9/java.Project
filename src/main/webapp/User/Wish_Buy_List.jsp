<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="DAO.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>중고차는 역시 호카!</title>
</head>
<body>
	<br>
	<%
		request.setCharacterEncoding("UTF-8");
		String User_name = request.getParameter("User_name");
		String User_phone1 = request.getParameter("User_phone1");
		String User_phone2 = request.getParameter("User_phone2");
		String User_phone3 = request.getParameter("User_phone3");
		String User_mail = request.getParameter("User_mail");
		String id = String.valueOf(session.getAttribute("id"));
		String carNumber = request.getParameter("carNumber");
		
		String phoneNum = User_phone1 + "-" + User_phone2 + "-" +User_phone3;
		
		DB_Connection sc = new DB_Connection();
		
		sc.insertWishBuyList(User_name, id, phoneNum, carNumber, User_mail);
		
		out.println("구매차량 번호 :" + carNumber + "<br>");
		out.println("이름 :" + User_name + "<br>");
		out.println("연락처 :" + User_phone1 + "-" + User_phone2 + "-" + User_phone3 + "<br>");
		out.println("이메일 :" + User_mail + "<br>");
		
		out.println("위 정보로 구매희망접수가 완료되었습니다.");	
	%>
	<form action="Board_Main.jsp" method="post">
		<input type="submit" value="초기화면으로" name="">
</body>
</html>
