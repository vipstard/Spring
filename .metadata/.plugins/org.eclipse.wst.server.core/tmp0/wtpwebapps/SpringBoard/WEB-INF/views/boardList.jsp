<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
boardList!

<%
	ArrayList<String> list = (ArrayList<String>)request.getAttribute("list");
%>
<table border="1">
	<tr>
		<th>계절</th>
	</tr>
	
		<%for(String s : list){ %>
			<tr><td><%=s %></td></tr>
		<%} %>

</table>
</body>
</html>


