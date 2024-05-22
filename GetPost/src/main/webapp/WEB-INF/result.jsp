
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, tr, td {
	border: 1px solid black;
}

table {
	width: 300px;
}
td{
text-align: center;
}


</style>
</head>
<body>

	<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("fruits");
	%>


	<div id="title">
		<h1 align="center">선호도 조사결과</h1>
	</div>
	<br>
	<table align="center">
		<tr>
			<td allign>
				<p>이름</p>
			</td>
			<td>
				<p>박병관</p>
			</td>
		</tr>
		<tr>
			<td>
				<p>좋아하는 과일</p>
			</td>
			<td><c:forEach var="fruits" items="${paramValues.fruits}">
					<c:out value="${fruits}" />
				</c:forEach></td>
		</tr>
	</table>




</body>
</html>
