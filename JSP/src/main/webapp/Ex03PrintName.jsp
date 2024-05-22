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
	// POST방식으로 요청할땐 , 인코딩 방식이 필요하다.
	request.setCharacterEncoding("UTF-8");
	String data = request.getParameter("data");
	
	
	%>
	
	
	입력한 이름 :<%=data %>
	입력한 이름 :<%out.print(data); %>



</body>
</html>