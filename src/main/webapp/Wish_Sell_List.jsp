<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		String User_phone=request.getParameter("User_phone");
		String User_mail=request.getParameter("User_mail");

		out.println("구매차량 번호 :" + Car_number + "<br>");
		out.println("이름 :" + User_name + "<br>");
		out.println("연락처 :" + User_phone + "<br>");
		out.println("이메일 :" + User_mail + "<br>");
	%>
</body>
</html>
