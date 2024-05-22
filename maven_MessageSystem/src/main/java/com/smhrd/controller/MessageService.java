package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MessageDAO;
import com.smhrd.model.MessageDTO;

@WebServlet("/MessageService")
public class MessageService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 인코딩 작업
		request.setCharacterEncoding("UTF-8");

		// 2. 데이터 꺼내오기
		String sendName = request.getParameter("sendName");
		String receiveEmail = request.getParameter("receiveEmail");
		String message = request.getParameter("message");

		// 3. 데이터베이스에 해당 내용 전달하기 --> DAO 클래스->MessageDAO 클래스분리
		// DAO의 sendMassege() 생성
		// MessageDTO 생성

		MessageDAO dao = new MessageDAO();
		MessageDTO dto = new MessageDTO();
		dto.setSendName(sendName);
		dto.setReceiveEmail(receiveEmail);
		dto.setMessage(message);

		int result = dao.sendMessage(dto);

		// 4. 결과 처리

		if (result > 0) {

			System.out.println("메세지 전송 성공!");
		} else {
			System.out.println("메세지 전송 실패");
		}
		
		response.sendRedirect("Main.jsp");

	}

}
