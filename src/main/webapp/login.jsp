<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
* {
	margin: 0 auto;
	padding: 0;
}

.div1 {
	text-align: center;
	height: 500px;
	width: 400px;
	border: 1px solid black;
	margin-left: 600px;
	margin-top: 100px;
	padding-top: 100px;
	box-sizing: border-box;
	background-color: pink;
	border-radius: 5px;
	box-shadow: 0px 2px 10px 10px;
}

li {
	list-style-type: none;
}

.input {
	width: 180px;
	height: 25px;
	border-radius: 5px;
	background: transparent;
}

.sub {
	margin-top: 60px;
	height: 30px;
	width: 80px;
}

.res {
	margin-top: 60px;
	width: 80px;
	height: 30px;
	width: 80px;
}

.log {
	margin-top: 0px;
}

h1 {
	margin-top: -40px;
}
</style>
</head>
<body>

	<div class="div1">
		<h1>Login Form</h1>
		<br>
		<form action="login" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<td><input class="input" type="text" name="name"
						placeholder="Name"><br> <br></td>
						</tr>
						<tr>
					<td><input class="input" type="text" name="email"
						placeholder="Email"><br> <br></td></tr>
						<tr>
					<td><input class="input" type="text" name="mobile"
						placeholder="Mobile"><br> <br></td></tr>
						<tr>
					<td><input class="input" type="file" name="file"><br></td>
					</tr>
					<tr>
					<td><input class="sub" type="submit" value="Submit"> <input
						class="res" type="reset"></td>
				</tr>
			</table>
		</form>
		<h3>
			<a href="show">Show Data</a>
		</h3>
	</div>
</body>
</html>

<%@include file="footer.jsp"%>