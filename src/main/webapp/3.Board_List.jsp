<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
body {
	text-align: center;
}

header {
	border: 1px solid #999;
}

section {
	width: 1500px;
	height: 800px;
	border: 1px solid #999;
	float: left;
	padding: 10px;
	border: 1px solid #999;
	border: 1px solid #999
}

aside {
	width: 300px;
	height: 800px;
	border: 1px solid #999;
	float: left;
	padding: 10px;
	border: 1px solid #999;
}

footer {
	border: 1px solid #999;
	clear: both;
}

table {
	width: 1500px;
	margin: auto;
}
</style>
</head>
<body>
	<h1>HOCAR ��������</h1>
	<header>
		<h1>��ϵ� ���� ��Ȳ</h1>
	</header>
	<section>
		<%
		int currentPage = 1;
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}

		int totalRowCount = 0;

		Connection con = null;
		Statement st = null;
		ResultSet totalrs = null;
		ResultSet listrs = null;
		PreparedStatement totalpstmt = null;
		PreparedStatement listpstmt = null;
		String url = "jdbc:mysql://127.0.0.1:3306/hocar_db?serverTimezone=UTC&useSSL=false";
		String dbID = "root";
		String dbPW = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, dbID, dbPW);
			String totalSql = "Select count(*)from usedcar";
			totalpstmt = con.prepareStatement(totalSql);
			totalrs = totalpstmt.executeQuery();
			st = con.createStatement();
			if (totalrs.next()) {
				totalRowCount = totalrs.getInt(1);
			}
		%>
		<%
		int pagePerRow = 25;
		String listSql = "select * from usedcar order by car_name desc limit ?,?";

		listpstmt = con.prepareStatement(listSql);
		listpstmt.setInt(1, (currentPage - 1) * pagePerRow);
		listpstmt.setInt(2, pagePerRow);
		listrs = listpstmt.executeQuery();
		%>
		<table border="1">
			<thead>
				<th>������ȣ</th>
				<th>����</th>
				<th>������</th>
				<th>������</th>
				<th>����(��)</th>
				<th>����</th>
				<th>����Ÿ�(km)</th>
				<th>��������</th>
				<th>����</th>
			</thead>
			<tbody>
				<%
				while (listrs.next()) {
				%>
				<tr>
					<td><%=listrs.getString("car_number")%></td>
					<td><%=listrs.getString("car_type")%></td>
					<td><%=listrs.getString("car_name")%></td>
					<td><%=listrs.getString("made_company")%></td>
					<td><%=listrs.getString("price")%></td>
					<td><%=listrs.getString("made_year")%></td>
					<td><%=listrs.getString("dis_driven")%></td>
					<td><%=listrs.getString("fuel_type")%></td>
					<td><%=listrs.getString("color")%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<div>
			<br> ���� ������:
			<%=currentPage%></div>
		<%
		int lastPage = totalRowCount / pagePerRow;
		if (totalRowCount % pagePerRow != 0) {
			lastPage++;
		}
		%>
		<div>
			<%
			if (currentPage > 1) {
			%>
			<a
				href="<%=request.getContextPath()%>/3.Board_List.jsp?currentPage=<%=currentPage - 1%>">����</a>
			<%
			}
			if (currentPage < lastPage) {
			%>
			<a
				href="<%=request.getContextPath()%>/3.Board_List.jsp?currentPage=<%=currentPage + 1%>">����</a>
			<%
			}
			%>
		</div>
	</section>
	<aside>
		<p>��������</p>
		<div>
			<a href="<%=request.getContextPath()%>/������.jsp">�Խñ��Է�</a>
		</div>
	</aside>
	<footer>
		<p>������ �ѹ� �� ��Ÿ ����</p>

	</footer>
	<%
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	try {
		totalrs.close();
	} catch (Exception e) {
	}
	try {
		listrs.close();
	} catch (Exception e) {
	}
	try {
		totalpstmt.close();
	} catch (Exception e) {
	}
	try {
		listpstmt.close();
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