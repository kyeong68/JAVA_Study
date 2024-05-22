<%@page import="com.smhrd.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>안녕하세요</h2>
	<form>
		<button type="button" onclick="location.href='login.html' ">로그인</button>
		<button type="button" onclick="location.href='join.html' ">회원가입</button>
		<!--<a href='join.html'><button>회원가입</button></a>  -->
	</form>



	<%
	try {
		Member loginMember = (Member) session.getAttribute("member");
		if (loginMember != null) {

			out.print(loginMember.getId());
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	%>


</body>
</html>
