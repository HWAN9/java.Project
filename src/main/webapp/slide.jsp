<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.section input[id*="slide"]{
display:none;
}
.section .slidewrap {
max-width:1200px;
margin:0 auto;
overflow:hiddn
}
.section .slidelist {
white-space:nowrap;
font-size:0;
}
.section .slidelist > li {
display:inline-block;
vertical-align:midddle;
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

</style>
</head>
<body>
<div class="section">
		<input type="radio" name="slide" id="slide04" checked> 
		<input type="radio" name="slide" id="slide05"> 
		<input type="radio" name="slide" id="slide06">

		<div class="slidewrap">
			<ul class="slidelist">
				<li>
					<a> 
						<label for="slide06" class="left"></label>
						<img src="slide04.jpg" >
						<label for="slide05" class="Right"></label>
					</a>
				</li>
				<li>
					<a> 
						<label for="slide04" class="left"></label>
						<img src="slide05.jpg">
						<label for="slide06" class="Right"></label>
					</a>
				</li>
				<li>
					<a> 
						<label for="slide05" class="left"></label>
						<img src="slide06.jpg">
						<label for="slide04" class="Right"></label>
					</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
