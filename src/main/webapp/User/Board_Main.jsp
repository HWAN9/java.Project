<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>
header {
	background-color: #FFDEAD;
	width:1800px;
	height: 100px;
}
section {
	width: 1800px;
	text-align: left;
	float: left;
	padding: 10px;
}
footer {
	background-color: #FFDEAD;
	width:1800px;
	height: 100px;
	clear: both;
}
 header, nav {
	text-align: center;
}
header{
	line-height: 100px;
}
.section > .slide {
display:none;
}
.section .slidewrap {
max-width:1800px;
overflow:hidden;
}
.section .slidelist {
white-space:nowrap;
font-size:0;
}
.section .slidelist > li {
display:inline-block;
vertical-align:middle;
width:100%;
transition:all .5s;
}
.section .slidelist > li > a {
display:block;
position:relative;
}
.section .slidelist > li > a lmg {
width:100%;
}
.section .slidelist label {
position:absolute;
z-index:10;
top:50%;
transform:translateY(-50%);
padding:50px;
cursor:pointer;
}
.section .slidelist .left{
left:30px;
background:url('left.png') center center / 100% no-repeat;
}
.section .slidelist .right{
right:30px;
background:url('right.png') center center / 100% no-repeat;
}
.section input[id="slide04"]:checked ~ .slidewrap .slidelist > li {transform:translateX(0%);}
.section input[id="slide05"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-100%);}
.section input[id="slide06"]:checked ~ .slidewrap .slidelist > li {transform:translateX(-200%);}
.button {
float:left;
width:20%;
font-size:25px;
padding:5px 5px;
border-radius:5px;
}
form:nth-child(1){
position: relative;
left:50px;
}
form:nth-child(2){
position: relative;
left:300px;
}
form:nth-child(3){
position: relative;
left:600px;
}
</style>
</head>

<body>

<header>
<h1>HOCAR</h1>
</header>

<section>
	<div class="section">
		<input class= slide type="radio" name="slide" id="slide04" checked> 
		<input class= slide type="radio" name="slide" id="slide05"> 
		<input class= slide type="radio" name="slide" id="slide06">

		<div class="slidewrap">
			<ul class="slidelist">
				<li>
					<a> 
						<label for="slide06" class="left"></label>
						<img src="slide04.jpg" width=1800px height=500px>
						<label for="slide05" class="right"></label>
					</a>
				</li>
				<li>
					<a> 
						<label for="slide04" class="left"></label>
						<img src="slide05.jpg" width=1800px height=500px>
						<label for="slide06" class="right"></label>
					</a>
				</li>
				<li>
					<a> 
						<label for="slide05" class="left"></label>
						<img src="slide06.jpg" width=1800px height=500px>
						<label for="slide04" class="right"></label>
					</a>
				</li>
			</ul>
		</div>
	</div>
	</section>
<footer>
	<form ACTION="Board_Buy.jsp">
		<button class="button" onclick="location='Board_Buy.jsp'">구매</button>
	</form>

	<form ACTION="Board_Sell_Page.jsp">
		<button class="button" onclick="location='Board_Sell_Page.jsp'">판매</button>
	</form>

	<form ACTION="Board_Login.jsp">
		<button class="button" onclick="location='Board_Login.jsp'">로그아웃</button>
	</form>
</footer>
</body>
</html>
