<%@page import="java.util.ArrayList"%>
<%@page import="com.smhrd.model.MessageDAO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.smhrd.model.MemberDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.smhrd.model.MemberDTO" %>
<%@page import="com.smhrd.model.MessageDAO" %>
<%@page import="com.smhrd.model.MessageDTO" %>
<%@page import="java.util.ArrayList" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Message System Example</title>
		<meta charset="UTF-8" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="assets/css/main.css" />
	</head>
	<body>
		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Header -->
		     	<%  
		     	  MemberDTO loginMem =(MemberDTO)session.getAttribute("loginMem");
		     	 
		     	 %>		
					<header id="header" class="alt">
						<a href="Main.jsp" class="logo"><strong>Forty</strong> <span>by HTML5 UP</span></a>
						<nav>
							<!-- Q6. 로그인을 하지않은 상태에서는 로그인탭 출력 -->
							<!--     로그인 한 상태에서는 개인정보수정탭과 로그아웃탭 출력 -->
							<%if(loginMem == null){ %>
								<a href="#menu">로그인</a>
							<%} else{ %>
								<%if(loginMem.getEmail().equals("admin")){ %>
									<a href="ShowMember.jsp">전체회원정보</a>
								<% } %>
									<a href="UpdateMember.jsp">개인정보수정</a>
									<a href="LogoutService.do">로그아웃</a>
							<%} %>


						</nav>
					</header>

				<!-- Menu -->
					<nav id="menu">	
						<ul class="links">
						<!-- Q3. 로그인 기능 만들기 -->
							<li><h5>로그인</h5></li>
								<form action ="LoginService.do" method= "post">
									<li><input type="text" placeholder="Email을 입력하세요" name="email"></li>
									<li><input type="password" placeholder="PW를 입력하세요" name="pw"></li>
									<li><input type="submit" value="LogIn" class="button fit"></li>
								</form>
						</ul>
						<ul class="actions vertical">
						<!-- Q1. 회원가입 기능 만들기 -->
							<li><h5>회원가입</h5></li>
								<form action ="JoinService" method= "post">
									<li><input type="text" id="inputE" name="email" placeholder="Email을 입력해주세요"></li>
									<li><input type="button" id="inputE" value="Email중복체크" onclick="checkE()"></li>
 									<li><span id="resultCheck"></span></li>
									<li><input type="password" name="pw" placeholder="비밀번호를 입력해주세요"></li>
									<li><input type="text" name="tel" placeholder="전화번호를 입력해주세요"></li>
									<li><input type="text" name="address" placeholder="주소를 입력해주세요"></li>
									<li><input type="submit" value="JoinUs" class="button fit"></li>
								</form>
						</ul>
					</nav>			
				<!-- Banner -->
					<section id="banner" class="major">
						<div class="inner">
							<header class="major">
							<!-- Q4. 로그인 후 로그인한 사용자의 email로 바꾸기 -->
							<!-- ex) 00님 환영합니다.  -->
							<%
					
							 if(loginMem !=null){
							%>
						 	<h1><%= loginMem.getEmail() %>님환영합니다 </h1><!-- 로그인한 경우 -->
							<% } else {%>							
						    	<h1>로그인을 해주세요</h1> <!-- 로그인 안한경우 -->
						   	<%}%>
							
							
							</header>
							<div class="content">
								<!-- <p>게시판을 이용해보세요 ^^<br></p> -->
								<ul class="actions">
									<li><a href="BoardMain.jsp" class="button next scrolly">게시판 바로가기</a></li>
								</ul>
							</div>
						</div>
					</section>

				<!-- Main -->
					<div id="main">

						<!-- One -->
							<section id="one" class="tiles">
								<article>
									<span class="image">
										<img src="images/pic01.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">HTML</a></h3>
										<p>홈페이지를 만드는 기초 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic02.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">CSS</a></h3>
										<p>HTML을 디자인해주는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic03.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Servlet/JSP</a></h3>
										<p>Java를 기본으로 한 웹 프로그래밍 언어/스크립트 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic04.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">JavaScript</a></h3>
										<p>HTML에 기본적인 로직을 정의할 수 있는 언어</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic05.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">MVC</a></h3>
										<p>웹 프로젝트 중 가장 많이 사용하는 디자인패턴</p>
									</header>
								</article>
								<article>
									<span class="image">
										<img src="images/pic06.jpg" alt="" />
									</span>
									<header class="major">
										<h3><a href="#" class="link">Web Project</a></h3>
										<p>여러분의 최종프로젝트에 웹 기술을 활용하세요!</p>
									</header>
								</article>
							</section>
							
					<!-- Two -->
							<section id="two">
								<div class="inner">
									<header class="major">
										<!-- Q12. 로그인 이메일 출력! -->
										<h2>나에게 온 메세지 확인하기</h2>
									</header>
									<p></p>
									<% if(loginMem != null){ %>
										 <ul class="actions">
										<!-- Q14. 메시지 전체 삭제 기능 -->								
										<li><a href="DelmessageAllService?email=<%=loginMem.getEmail() %>" class="button next scrolly">전체삭제하기</a></li>
									</ul>
									<%}%>
									
									<!-- Q13. table형태로 나한테 온 메시지만 가져와서 보여주기 -->
									
									<%
									// 회원이 로그인을 한다면 해당 email로 받은 메세지를 가져오는 기능!
									MessageDAO dao = new MessageDAO();

         						  	 if (loginMem != null) {
             				 		 ArrayList<MessageDTO> m_list = dao.showMessage(loginMem.getEmail());
           							 %><ul class="actions">
										<!-- Q14. 메시지 전체 삭제 기능 -->								
										<li><a href="DelmessageAllService?email=<%=loginMem.getEmail() %>" class="button next scrolly">전체삭제하기</a></li>
									</ul>
									<table>
									<tr>
										<td>번호</td>
										<td>보낸내용</td>
										<td>내용</td>
										<td>보낸시간</td>
										
										<td>삭제</td>
										
									</tr>	
									             <%
               for (MessageDTO message : m_list) {
               %>

               <tr>
                  <td><%=message.getNum()%></td>
                  <td><%=message.getSendName()%></td>
                  <td><%=message.getMessage()%></td>
                  <td><%=message.getM_date()%></td>
                  <td><a href ="DelMessageService?num=<%=message.getNum()%>" >삭제</a></td>

               </tr>
					<%}} %>

				</table>

        				<!-- Q15. 메시지 개별 삭제 기능 -->								
								</div>
							</section>

					</div>

				<!-- Contact -->
					<section id="contact">
						<div class="inner">
							<section>
							<!-- Q11. 메시지 보내기 기능 -->
								<form action = "MessageService" method="post">
								<div class="field half first">
										<label for="name">Name</label>
										<input type="text" name="sendName" id="name" placeholder="보내는 사람 이름"/>
									</div>
									<div class="field half">
										<label for="email">Email</label>
										<input type="text" name="receiveEmail" id="email" placeholder="받는 사람 이메일"/>
									</div>

									<div class="field">
										<label for="message">Message</label>
										<textarea name = "message" id="message" rows="6"></textarea>
									</div>
									<ul class="actions">
										<li><input type="submit" value="Send Message" class="special" /></li>
										<li><input type="reset" value="Clear" /></li>
									</ul>
								</form>
							</section>
							
							<section class="split">
								<section>
									<div class="contact-method">
										<span class="icon alt fa-envelope"></span>
										<h3>Email</h3>
										<!-- Q5. 로그인 한 사용자의 이메일을 출력 -->
										<!--<span>로그인 한 사용자의 email</span>  -->
										
							<%
							 if(loginMem !=null){
							%>
						 	<span><%= loginMem.getEmail() %>님환영합니다</span><!-- 로그인한 경우 -->
							<% } else {%>							
						    	<span>로그인 한 사용자의 email</span> <!-- 로그인 안한경우 -->
						   	<%}%>
													
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-phone"></span>
										<h3>Phone</h3>
										<!-- Q5. 로그인 한 사용자의 전화번호를 출력 -->
							<%
							 if(loginMem !=null){
							%>
						 	<span><%= loginMem.getTel()%></span><!-- 로그인한 경우 -->
							<% } else {%>							
						    	<span>로그인 한 사용자의 Tel</span> <!-- 로그인 안한경우 -->
						   	<%}%>
										
									</div>
								</section>
								<section>
									<div class="contact-method">
										<span class="icon alt fa-home"></span>
										<h3>Address</h3>
							<%
							 if(loginMem !=null){
							%>
						 	<span><%= loginMem.getAddress()%> </span><!-- 로그인한 경우 -->
							<% } else {%>							
						    	<span>로그인 한 사용자의 Address</span> <!-- 로그인 안한경우 -->
						   	<%}%>
												
										<!-- Q5. 로그인 한 사용자의 집주소를 출력 -->
										
										<span>로그인 한 사용자의 집주소</span>
									</div>
								</section>
							</section>					
						</div>
					</section>

				<!-- Footer -->
					<footer id="footer">
						<div class="inner">
							<ul class="icons">
								<li><a href="#" class="icon alt fa-twitter"><span class="label">Twitter</span></a></li>
								<li><a href="#" class="icon alt fa-facebook"><span class="label">Facebook</span></a></li>
								<li><a href="#" class="icon alt fa-instagram"><span class="label">Instagram</span></a></li>
								<li><a href="#" class="icon alt fa-github"><span class="label">GitHub</span></a></li>
								<li><a href="#" class="icon alt fa-linkedin"><span class="label">LinkedIn</span></a></li>
							</ul>
							<ul class="copyright">
								<li>&copy; Untitled</li><li>Design: <a href="https://html5up.net">HTML5 UP</a></li>
							</ul>
						</div>
					</footer>

			</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/jquery.scrolly.min.js"></script>
			<script src="assets/js/jquery.scrollex.min.js"></script>
			<script src="assets/js/skel.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>
			
		<script type="text/javascript">
			function checkE(){
				var inputE = $('#inputE').val();
				console.log(inputE);		
			
				$.ajax({ //ajax쓰는이유:  페이지 이동없이 그부분만 바뀌는거 특정부분만 바꿀꺼야!! (비동기통신 )
					// 어디로 요청할것인지
					url : 'EmailCheckService',
					
					// 요청할 데이터{key : value}
					data : {'inputE' :inputE },	
										
					// 요청방식
					type : 'get',
					
					// 요청에 성공했을때 무엇을 할것인지 ?
					success	 :	function(data){
						if(data=='true'){
							$('#resultCheck').text('사용할수 없는 아이디')
						}else if(data=='false'){
							$('#resultCheck').text('사용할수 있는 아이디')
						}
					},
					
					// 요청에 실패했을때
					error : function(){
						alert("통신실패");
					}
				});
			}

		</script>	

	</body>
</html>

