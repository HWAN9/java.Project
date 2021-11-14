<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ page import = "DAO.*" %>
<%@ page import = "DTO.*" %>
<%@ page import = "java.util.Arrays" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>검색 후 사이트</title>
<style>
header {
	background-color: #FFD9EC;
	width: 1800px;
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
	width: 1800px;
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

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>

<%
String [] type = request.getParameterValues("type");
String [] company = request.getParameterValues("company");
String [] fuel = request.getParameterValues("fuel");
String [] color = request.getParameterValues("color");

DB_Connection sc = new DB_Connection();
sc.truncateSearchList();

ArrayList<SellVO> searchCarList = new ArrayList<SellVO>();
ArrayList<SellVO> bucket1 = new ArrayList<SellVO>();
ArrayList<SellVO> bucket2 = new ArrayList<SellVO>();
ArrayList<SellVO> bucket3 = new ArrayList<SellVO>();
ArrayList<SellVO> bucket4 = new ArrayList<SellVO>();

searchCarList = sc.searchCar();

if(type == null){
	for(int i=0; i<searchCarList.size() ; i++){
		bucket1.add(searchCarList.get(i));
	}
} else if(type != null) {
	for(int i=0; i<searchCarList.size() ; i++){
		for(int j=0; j < type.length; j++){
			if(searchCarList.get(i).getcar_type().equals(type[j])){
				bucket1.add(searchCarList.get(i));
			}
		}	
	}
}

if(company == null){
	for(int i=0; i<bucket1.size() ; i++){
		bucket2.add(bucket1.get(i));
	}
} else if(company != null) {
	for(int i=0; i<bucket1.size() ; i++){
		for(int j=0; j < company.length; j++){
			if(bucket1.get(i).getmade_company().equals(company[j])){
				bucket2.add(bucket1.get(i));
			}
		}	
	}
}

if(fuel == null){
	for(int i=0; i<bucket2.size() ; i++){
		bucket3.add(bucket2.get(i));
	}
} else if(fuel != null) {
	for(int i=0; i<bucket2.size() ; i++){
		for(int j=0; j < fuel.length; j++){
			if(bucket2.get(i).getfuel_type().equals(fuel[j])){
				bucket3.add(bucket2.get(i));
			}
		}	
	}
}

if(color == null){
	for(int i=0; i<bucket3.size() ; i++){
		bucket4.add(bucket3.get(i));
	}
} else if(color != null) {
	for(int i=0; i<bucket3.size() ; i++){
		for(int j=0; j < color.length; j++){
			if(bucket3.get(i).getcolor().equals(color[j])){
				bucket4.add(bucket3.get(i));
			}
		}	
	}
}

for(int i = 0; i < bucket4.size(); i++){
	sc.insertSearchList(bucket4.get(i).getcar_number(), bucket4.get(i).getcar_type(), bucket4.get(i).getcar_name(), bucket4.get(i).getmade_company(),
			bucket4.get(i).getprice(), bucket4.get(i).getmade_year(), bucket4.get(i).getdis_driven(), bucket4.get(i).getfuel_type(), bucket4.get(i).getcolor());
}

%>
	<header>

		<a href="Board_Main.jsp">
			<img src="hocar.PNG" width=200px height=100px align="left">
		</a>
		<h1>판매 차량 리스트</h1>

	</header>
	<nav>
		<h4>
			<form method="get" action="Board_Buy_Search.jsp">
			<%!int currentPage1 = 1;%>
				<h4>차종</h4>
				<input type="checkbox" name="type" value="경차">경차
				<br>
				<input type="checkbox" name="type" value="소형">
				소형
				<br>
				<input type="checkbox" name="type" value="준중형">
				준중형
				<br>
				<input type="checkbox" name="type" value="중형">
				중형
				<br>
				<input type="checkbox" name="type" value="대형">
				대형
				<br>
				<input type="checkbox" name="type" value="SUV">
				SUV
				<br>

				<h4>제조사</h4>
				<input type="checkbox" name="company" value="현대">
				현대
				<br>
				<input type="checkbox" name="company" value="기아">
				기아
				<br>
				<input type="checkbox" name="company" value="삼성">
				삼성
				<br>
				<input type="checkbox" name="company" value="쉐보레">
				쉐보레
				<br>
				<input type="checkbox" name="company" value="쌍용">
				쌍용
				<br>
				<input type="checkbox" name="company" value="SUV">
				SUV
				<br>
				<input type="checkbox" name="company" value="제네시스">
				제네시스
				<br>
				<input type="checkbox" name="company" value="BMW">
				BMW
				<br>
				<input type="checkbox" name="company" value="벤츠">
				<br>

				<h4>연료타입</h4>
				<input type="checkbox" name="fuel" value="가솔린">
				가솔린
				<br>
				<input type="checkbox" name="fuel" value="디젤">
				디젤
				<br>
				<input type="checkbox" name="fuel" value="LPG">
				LPG
				<br>

				<h4>색상</h4>
				<input type="checkbox" name="color" value="흰색">
				흰색
				<br>
				<input type="checkbox" name="color" value="검정색">
				검정색
				<br>
				<input type="checkbox" name="color" value="쥐색">
				쥐색
				<br>
				<input type="checkbox" name="color" value="빨간색">
				빨간색
				<br>
				<input type="checkbox" name="color" value="파란색">
				파란색
				<br>
						<input type="hidden" value="<%=currentPage1 = 1%>">
						<input type="submit" value="검색">
				</form>
		</h4>
	</nav>
	
	<section>
	
		<%!private Connection con = null;
	private Statement st = null;
	private ResultSet rs = null;
	Connection connection = null;
	PreparedStatement totalStatement = null;
	PreparedStatement listStatement = null;
	ResultSet totalResultSet = null;
	ResultSet listResultSet = null;%>

	<%!
	int totalRowCount1 = 0;
	%>
	
	<%
	if (request.getParameter("currentPage1") != null) {
		currentPage1 = Integer.parseInt(request.getParameter("currentPage1"));
	}

	String dbUrl = "jdbc:mysql://127.0.0.1:3306/hocar_db?serverTimezone=UTC&useSSL=false";
	String dbUser = "root";
	String dbPw = "1234";
	
	%>


	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection = DriverManager.getConnection(dbUrl, dbUser, dbPw);

		String totalSql = "SELECT COUNT(*) FROM SEARCHLIST";
		totalStatement = connection.prepareStatement(totalSql);
		totalResultSet = totalStatement.executeQuery();

	if (totalResultSet.next()) {
		totalRowCount1 = totalResultSet.getInt(1);
		}
	%>

		<%
		int pagePerRow1 = 30;
		String listSql = "SELECT * FROM SEARCHLIST ORDER BY CAR_TYPE DESC LIMIT ?, ?";

		listStatement = connection.prepareStatement(listSql);
		listStatement.setInt(1, (currentPage1 - 1) * pagePerRow1);
		listStatement.setInt(2, pagePerRow1);
		listResultSet = listStatement.executeQuery();
		%>
		
		
		<%
		String strType, strCompany, strFuel, strColor = "";
		String searchType, searchCompany, searchFuel, searchColor = "";
		
		if(type != null){
		strType = "&type=" + String.join("&type=", type);
		searchType = "차종(" + String.join(", ", type)+ ") ";
		} else {strType=""; searchType="";}
		if(company != null){
		strCompany = "&company=" + String.join("&company=", company);
		searchCompany = "제조사(" + String.join(", ", company)+ ") ";
		}else {strCompany=""; searchCompany="";}
		if(fuel != null) {
		strFuel = "&fuel=" + String.join("&fuel=",fuel);
		searchFuel = "연료(" + String.join(", ", fuel)+ ") ";
		} else {strFuel=""; searchFuel="";}
		if(color != null) {
		strColor = "&color=" + String.join("&color=", color);
		searchColor = "색상(" + String.join(", ", color)+ ") ";
		} else {strColor=""; searchColor="";}
		
		String stringQuery = (strType+strCompany+strFuel+strColor);
		String stringSearch = (searchType + searchCompany + searchFuel + searchColor);
		%>
		
		<p>선택조건 = <%=stringSearch%></p>
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
				String car_number = listResultSet.getString("car_number");
				String car_type = listResultSet.getString("car_type");
				String car_name = listResultSet.getString("car_name");
				String made_company = listResultSet.getString("made_company");
				int price = listResultSet.getInt("price");
				double made_year = listResultSet.getDouble("made_year");
				int dis_driven = listResultSet.getInt("dis_driven");
				String fuel_type = listResultSet.getString("fuel_type");
				String colorlist = listResultSet.getString("color");

				request.setAttribute("PRICE", price);
				request.setAttribute("DRIVEN", dis_driven);
				request.setAttribute("YEAR", made_year);
				%>
			
			<tr>
				<td width=100px><%=car_number%></td>
				<td width=50px><%=car_type%></td>
				<td><%=car_name%></td>
				<td width=70px><%=made_company%></td>
				<td width=70px>
					<fmt:formatNumber type="number" maxFractionDigits="3" value="${PRICE}" />
					만원
				</td>
				<td width=70px>
					<fmt:parseNumber value="${YEAR}" integerOnly="true" />
					년형
				</td>
				<td width=100px>
					<fmt:formatNumber type="number" maxFractionDigits="3" value="${DRIVEN}" />
					km
				</td>
				<td width=70px><%=fuel_type%></td>
				<td width=70px><%=colorlist%></td>
				<td>
				<form action="Board_Buy_Page.jsp" method="post">
					<input type="hidden" name="carNumber" value="<%=car_number%>">
					<input type="hidden" name="carName" value="<%=car_name%>">
					<input type="hidden" name="company" value="<%=made_company%>">
					<input type="hidden" name="price" value="<%=price%>">
					<input type="submit" value="구매하기" name="">
				</form>
				</td>
				<%
				}
				%>
			</tr>
		</table>


		<%
		
		int lastPage1 = totalRowCount1 / pagePerRow1;
		if (totalRowCount1 % pagePerRow1 != 0) {
			lastPage1++;
		}
		%>
	</section>
	<footer>
	<div>현재 페이지 : <%=currentPage1%> / 전체 페이지 : <%=totalRowCount1/pagePerRow1%><br>
	<%
	if (currentPage1 > 1) {
	%>
	<a href="<%=request.getContextPath()%>/Board_Buy_Search.jsp?<%=stringQuery%>&currentPage1=<%=currentPage1 - 1%>">이전</a>
	<%
	}
	if (currentPage1 < lastPage1-1) {
	%>
	<a href="<%=request.getContextPath()%>/Board_Buy_Search.jsp?<%=stringQuery%>&currentPage1=<%=currentPage1 + 1%>">다음</a>
	<%
	}
	%>
	</div>
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
