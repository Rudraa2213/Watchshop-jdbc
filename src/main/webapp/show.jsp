<%@page import="com.model.Productmodel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" session="true"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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

td {
	padding: 10px;
	text-align: center;
}

th {
	padding: 10px;
	text-align: center;
}

h1 {
	margin-left: 700px;
}
</style>
</head>
<body>
	<h1>Show Data</h1>
	<%
	ArrayList<Productmodel> data = (ArrayList<Productmodel>) request.getAttribute("data");
	/* out.println(data); */
	session.setAttribute("data", data);
	%>
	<table border="2px">
		<tr>
			<th>Id</th>
			<th>Serial No</th>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile No.</th>
			<th>Image name</th>
			<th>Image</th>
			<th colspan="2">Operation</th>
		</tr>
		<%
		for (int i = 0; i < data.size(); i++) {
		%>
		<tr><td><%=i+1 %></td>
			<td><%=data.get(i).getSno()%></td>
			<td><%=data.get(i).getName()%></td>
			<td><%=data.get(i).getEmail()%></td>
			<td><%=data.get(i).getMobile()%></td>
			<td><%=data.get(i).getFile()%></td>
			<td><img src="image/<%=data.get(i).getFile()%>" height="50px"
				width="100px" /></td>
			<td><a href="update?sno=<%=data.get(i).getSno()%>&id=<%=i+1%>"><button>
						Update</button></a></td>
			<td><a
				href="delete?sno=<%=data.get(i).getSno()%>&file=<%=data.get(i).getFile()%>"><button>
						Delete</button></a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>