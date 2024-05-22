<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
	<tr>
		<% for(int i=1; i<=10; i++){%>
		<td><%=i%></td>
			
	<%}%>	
			
	</tr>
	<table border='1'>
	<tr>
	<% for(int i=1; i<=10; i++){
		// jsp에서는 out객체 생성 없이 바로 사용할수 있다.
		// print()는 문자열을 출력하는 메서드.
		out.print("<td>"+i+"</td>");
	}
	
	%>
		</tr>
		</table>
	
	
	
	</table>





</body>
</html>