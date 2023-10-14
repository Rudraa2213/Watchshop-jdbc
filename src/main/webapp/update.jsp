<%@page import="java.util.ArrayList"%>
<%@page import="com.model.Productmodel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	height: 550px;
	width: 400px;
	border: 1px solid black;
	margin-left: 600px;
	margin-top: 100px;
	padding-top: 100px;
	box-sizing: border-box;
	background-color: aliceblue;
	border-radius: 5px;
	box-shadow: 0px 2px 20px 0px;
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

.div2 {
	margin-top: -60px;
	font-size: 40px;
	font-family: arial;
	font-weight: bold;
	color: #EB371B;
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
</style>
</head>
<body>
	<%
		ArrayList<Productmodel> pm = (ArrayList<Productmodel>) request.getAttribute("data");
	%>
	<%
	String ids=(String)request.getAttribute("id");
	int id=Integer.parseInt(ids);
	
	%>
	<div class="div1">
		<div class="div2">Update Page</div>
		<br>
		<br>
		<form action="updaterecord" method="post"
			enctype="multipart/form-data">
			<table>
				<tr>
					<td><input class="input" type="text" name="sno"	value="<%=pm.get(id-1).getSno()%>"><br>
					<br></td>
				</tr>
				<tr>
					<td><input class="input" type="text" name="name"
						value="<%=pm.get(id-1).getName()%>"><br>
					<br></td>
				</tr>
				<tr>
					<td><input class="input" type="text" name="email"
						value="<%=pm.get(id-1).getEmail()%>"><br>
					<br></td>
				</tr>
				<tr>
					<td><input class="input" type="text" name="mobile"
						value="<%=pm.get(id-1).getMobile()%>"><br>
					<br></td>
				</tr>
				<tr>
					<td><input type="text" hidden name="oldfile"
						value="<%=pm.get(id-1).getFile()%>"></td>
				</tr>
				<tr>
					<td><img src="image/<%=pm.get(id-1).getFile()%>" width="100px"
						height="80px"></td>
				</tr>
				<tr>
					<%-- <h3><%=pm.getFile() %></h3><br> --%>
					<td><input class="input" name="file" type="file"></td>
				</tr>
				<tr>
					<td>
						<input class="sub" type="submit" value="Submit"> 
						<input	class="res" type="reset" value="Reset"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>