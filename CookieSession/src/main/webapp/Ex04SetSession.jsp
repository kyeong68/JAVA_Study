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
	<%
		session.setAttribute("id", "대한민국");// 문자열 넣기
		session.setAttribute("age", 20);// 숫자 넣기
		
		ArrayList<String> array = new ArrayList<>();
		array.add("카레라이스");
		array.add("우동");
		session.setAttribute("food",array);//ArrayList
	
	%>
	<a href ="Ex05GetSession.jsp">세션확인</a>
	<a href ="Ex05GetSession">세션확인(Servlet)</a>














</body>
</html>