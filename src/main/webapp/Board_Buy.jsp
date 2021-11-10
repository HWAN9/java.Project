<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
// 단위표기를 위한 jstl 라이브러리 호출
// lib파일에 jstl 1.2 첨부해야 정상적으로 출력됩니다.

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
header {
	background-color: #FFD9EC;
	height: 100px;
}

nav {
	background-color: #339999;
	color: white;
	width: 350px;
	height: 1500px;
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
	width: 1000px
}
</style>
</head>
<body>
<h1>	<a href="Board_main.jsp"><img src="hocar.PNG" alt="" widtg=250px
			height=150px /></a></h1>
	<header>
	<h2>판매중인 차량</h2>
	</header>
	<nav>
	<h2>
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
	</h2>
	</nav>
	<section>
	
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
		</tr>
	</table>
	<br>
	<%!
	private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	%>
	
	<%
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hocar_db?serverTimezone=UTC&useSSL=false", "root", "1234");
	st = con.createStatement();
	%>
	
	
	<%
		String SQL = "SELECT * FROM usedCar";
		try {
			rs = st.executeQuery(SQL);
			while (rs.next()) {
				String car_number = rs.getString("car_number");
				String car_type = rs.getString("car_type");
				String car_name = rs.getString("car_name");
				String made_company = rs.getString("made_company");
				int price = rs.getInt("price");
				double made_year = rs.getDouble("made_year");
				int dis_driven = rs.getInt("dis_driven");
				String fuel_type = rs.getString("fuel_type");
				String color = rs.getString("color"); 
			%>
				
			<table border = '0px'>
			<tr>
				<th><%=car_number%></th>
				<th><%=car_type%></th>
				<th><%=car_name %></th>
				<th><%=made_company%></th>
				<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${PRICE}" />만원</th>
				<th><fmt:parseNumber value="${YEAR}" integerOnly="true" />년형</th>
				<th><fmt:formatNumber type="number" maxFractionDigits="3" value="${DRIVEN}" />km</th>
				<th><%=fuel_type%></th>
				<th><%=color%></th>
			</tr>
		</table>
		
		<%
			}
			rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		%>
		</article>
	</section>
	<footer>
	<h2>페이지 넘김 제작</h2>
	</footer>
</body>
</html>
