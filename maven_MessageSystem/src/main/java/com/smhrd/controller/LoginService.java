package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.MemberDAO;
import com.smhrd.model.MemberDTO;

import frontcontroller.command;

public class LoginService implements command {

	public String execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 2. 데이터 꺼내오기!
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		System.out.println(email); // 확인때문에 쓴거다
		System.out.println(pw); // 확인때문에 쓴거다

		// 3. 로그인 가능한지 판단! -> DAO 전달 -> login() 메소드 생성!

		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();// 생성자메소드를 봐야한다하지만 우린 2가지값만구할거임

		dto.setEmail(email);
		dto.setPw(pw);
		System.out.println(dto.getEmail());
		MemberDTO loginMember = dao.login(dto);// <-이걸 사용안하고 밑에 // 되어있는 문장3개도 쓸수있다

		// MemberDTO result = dao.login(dto);

		// 4. 로그인 결과에 따른 페이지 이동! -> Main.jsp

		if (loginMember != null) {
			System.out.println("로그인 성공!");
			// 회원의 정보를 저장하여 이동할수 있도록 수정!-> session 영역
			// session 영역을 불러오기!
			HttpSession session = request.getSession();
			session.setAttribute("loginMem", loginMember);
			// session.setAttribute("info", result);
			// response.sendRedirect("Main.jsp");

		}
		// response.sendRedirect("Main.jsp");

		return "Main.jsp";

		// 회원의 로그인을 판단하는 메소드
		// public void login(MemberDTO dto) {
		// SqlSession sqlSession = SqlSessionFactory.openSession(true);
		// 전체 테이블중 일부분만 확인할 수 있는 selecOne()사용!
		// sqlSession.selectone("login",dto)

	}

}
