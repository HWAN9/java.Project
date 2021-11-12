<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
	background-color: #FFD9EC;
	width:1800px;
	height: 100px;
}
nav {
	background-color: #339999;
	color: white;
	width: 200px;
	height: 900px;
	float: left;
}
section {
	width: 1200px;
	text-align: left;
	float: left;
	padding: 10px;
}
footer {
	background-color: #FF6347;
	height: 100px;
	width:1800px;
	clear: both;
}
header, nav, footer {
	text-align: center;
}
header, footer {
	line-height: 100px;
}
nav {
	
}
table {
	width: 1500px
}
table,th,td{
border:1px solid black;
border-collapse:collapse;
}
</style>
</head>
<body>
	<header>

	<a href="Board_Main.jsp"><img src="hocar.PNG" width=200px height=100px align="left"></a>
	<h1>판매 차량 리스트</h1>

	</header>
	<nav>
	<h4>
		<form method="get" action="CheckboxServlet">
			<h4>차종</h4>
			<input type="checkbox" name="item" value="경차">경차<br> <input
				type="checkbox" name="item" value="소형">소형<br> <input
				type="checkbox" name="item" value="준중형">준중형<br> <input
				type="checkbox" name="item" value="중형">중형<br> <input
				type="checkbox" name="item" value="대형">대형<br> <input
				type="checkbox" name="item" value="SUV">SUV <br>
				
				<h4>제조사</h4>
				<input type="checkbox" name="item" value="현대">현대<br> <input
				type="checkbox" name="item" value="기아">기아<br> <input
				type="checkbox" name="item" value="삼성">삼성<br> <input
				type="checkbox" name="item" value="쉐보레">쉐보레<br> <input
				type="checkbox" name="item" value="쌍용">쌍용<br> <input
				type="checkbox" name="item" value="SUV">SUV <br>
				<input type="checkbox" name="item" value="제네시스">제네시스<br> 
				<input type="checkbox" name="item" value="BMW">BMW<br> 
				<input type="checkbox" name="item" value="벤츠">벤츠<br> 
				
				<h4>연료타입</h4>
				<input type="checkbox" name="item" value="가솔린">가솔린<br> <input
				type="checkbox" name="item" value="디젤">디젤<br> <input
				type="checkbox" name="item" value="LPG">LPG<br>  
				
				<h4>색상</h4>
				<input type="checkbox" name="item" value="흰색">흰색<br> <input
				type="checkbox" name="item" value="검정색">검정색<br> <input
				type="checkbox" name="item" value="쥐색">쥐색<br>  
				<input type="checkbox" name="item" value="빨간색">빨간색<br>
				<input type="checkbox" name="item" value="파란색">파란색<br>
				
			<br> <input type="submit" value="검색">
		</form>
	</h4>
	</nav>
	<section>
	
	<%!
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	Connection connection = null;
	PreparedStatement totalStatement = null;
	PreparedStatement listStatement = null;
	ResultSet totalResultSet = null;
	ResultSet listResultSet = null;
	
	int currentPage = 1;
	int totalRowCount = 0;
	%>
	
	<%
	if(request.getParameter("currentPage") != null) {
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
	}
	
	String dbUrl = "jdbc:mysql://127.0.0.1:3306/hocar_db?serverTimezone=UTC&useSSL=false";
	String dbUser = "root";
	String dbPw = "1234";
	%>
	
	
	<%
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);
			
			String totalSql = "SELECT COUNT(*) FROM USEDCAR";
			totalStatement = connection.prepareStatement(totalSql);
			totalResultSet = totalStatement.executeQuery();
			
			
			if(totalResultSet.next()){
				totalRowCount = totalResultSet.getInt(1);
			}
	  %>
	  			
	<%
	int pagePerRow = 30;
	String listSql = "SELECT * FROM USEDCAR ORDER BY CAR_NUMBER DESC LIMIT ?, ?";
	
	listStatement = connection.prepareStatement(listSql);
	listStatement.setInt(1, (currentPage-1)*pagePerRow);
	listStatement.setInt(2, pagePerRow);
	listResultSet = listStatement.executeQuery();
	%>
	
	<div>목록표시 수 : <%=pagePerRow%></div>
	<table border="1">
	<tr>
		<th width=100px>차량번호</th>
		<th width=50px>차종</th>
		<th>차량명</th>
		<th width=70px>제조사</th>
		<th width=70px>가격</th>
		<th width=70px>연식</th>
		<th width=100px>주행거리</th>
		<th width=70px>연료종류</th>
		<th width=70px>색상</th>
		<th width=70px>구매</th>
	</tr>
	
	<%
	while (listResultSet.next()) {
		int i = 0;
		String car_number = listResultSet.getString("car_number");
		String car_type = listResultSet.getString("car_type");
		String car_name = listResultSet.getString("car_name");
		String made_company = listResultSet.getString("made_company");
		int price = listResultSet.getInt("price");
		double made_year = listResultSet.getDouble("made_year");
		int dis_driven = listResultSet.getInt("dis_driven");
		String fuel_type = listResultSet.getString("fuel_type");
		String color = listResultSet.getString("color"); 
		
		request.setAttribute("PRICE", price);
		request.setAttribute("DRIVEN", dis_driven);
		request.setAttribute("YEAR", made_year);
	%>
		<tr>
			<td width=100px><%=car_number%></td>
			<td width=50px><%=car_type%></td>
			<td><%=car_name %></td>
			<td width=70px><%=made_company%></td>
			<td width=70px><fmt:formatNumber type="number" maxFractionDigits="3" value="${PRICE}" />만원</td>
			<td width=70px><fmt:parseNumber value="${YEAR}" integerOnly="true" />년형</td>
			<td width=100px><fmt:formatNumber type="number" maxFractionDigits="3" value="${DRIVEN}" />km</td>
			<td width=70px><%=fuel_type%></td>
			<td width=70px><%=color%></td>
			<form action="Board_Buy_Search.jsp" method="post">
			<th width=70px>
			<input type="hidden" name="carname" value="<%=car_number%>">
			<input type="submit" value="구매하기" name="ddfde"/></th>
			</form>
		</tr>
	<%
	}
	%>
	</table>
	
	<%
	int lastPage = totalRowCount / pagePerRow;
	if(totalRowCount % pagePerRow != 0) {
	lastPage ++;
	}
	%>
	
	</article>
	</section>
	<footer>
	<p>현재 페이지 : <%=currentPage%> / 전체 페이지 : <%=totalRowCount/pagePerRow%>

		

	<%
	if (currentPage > 1) {
	%>
	<a href="<%=request.getContextPath()%>/Board_Buy.jsp?currentPage=<%=currentPage-1%>">이전</a>
	<%
	}
	if (currentPage < lastPage) {
	%>
	<a href="<%=request.getContextPath()%>/Board_Buy.jsp?currentPage=<%=currentPage + 1 %>">다음</a>
	<%
	}
	%>
	</p>
	</footer>
		<%
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	try {
		totalResultSet.close();
	} catch (Exception e) {
	}
	try {
		listResultSet.close();
	} catch (Exception e) {
	}
	try {
		totalResultSet.close();
	} catch (Exception e) {
	}
	try {
		listResultSet.close();
	} catch (Exception e) {
	}
	try {
		con.close();
	} catch (Exception e) {
	}
	}
	%>
</body>
</html>
