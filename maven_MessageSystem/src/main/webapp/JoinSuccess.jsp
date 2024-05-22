﻿<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" isELIgnored="false"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Message System Example</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
		
	</head>
	<style>
		#Update > ul.actions {
			margin-top:10%;
		}
	</style>
	<body style="text-align: center;">

		<!-- Wrapper -->
			<div id="wrapper">
				<!-- Menu -->
					<nav id="Update">	
						<ul class="actions vertical">
							<li><h1>환영합니다!</h1></li>
							<li>회원가입을 축하합니다.</li>
							<!-- Q2. 회원가입 한 회원정보 중 email을 출력하시오.(request영역 활용) -->
							<!-- smart@smhrd.or.kr -> 실제 회원가입 한 회원의 email로 출력 -->
				 <% String email = (String)request.getAttribute("email"); %>	
				 
				 
				 <!-- EL기법 :  표현하고자 하는 데이터를 손 쉽게 표현할수 있도록 도와주는 기법
				 	JSTL기법 :  Java의 조건문이나 반복문들의 제어들을 태그형태로 도와주는 기법  -->	
				 				
				 					
					<%-- <li>Message System의 새로운 email은 <%= email %> 입니다.</li>	 --%>	
						
							<li>Message System의 새로운 email은 ${email}입니다.</li>
							<li><button onclick='location.href="Main.jsp"'>시작하기</button></li>
						</ul>
					</nav>			
			</div>
		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
	</body>
</html>

