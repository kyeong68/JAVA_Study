package com.smhrd.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.smhrd.model.BoardDAO;
import com.smhrd.model.BoardDTO;

public class WriterService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 여기는 주석은 구체적인 내용임
		// MultipartRequest : 파일 업로드를 위한 요청객체!
		// 1. request: MultipartRequest 연결하기 위한 요청(request)!
		// 2. path : 서버측에 파일을 저장할 경로 -> 상대경로를 쓰는게 좋음!
		// 3. maxSize : 파일의 최대 크기지정!(1024*1024 = 1MB)->(1024*1024*2 = 2MB)
		// 4. encoding : 파일명에 대한 인코딩 작업!
		// 5. DefaultFileRenamePolicy : 파일의 이름이 중복되는 경우 덮어쓰기를 방지할 수 있는 객체

		// getServletContext : 자동적으로 경로 안에다가 파일경로값을 가져오는것 ?
		System.out.println("1");
		String path = request.getServletContext().getRealPath("file");

		int maxSize = 1024 * 1024 * 3;// 3MB

		String encoding = "UTF-8"; // 다시 UTF-8 로하겠습니다

		DefaultFileRenamePolicy rename = new DefaultFileRenamePolicy();
		// DefaultFileRenamePolicy : 사용자 파일 이름으로 합니다

		MultipartRequest multi = // MultipartRequest: 파일을 처리해주는아이
				new MultipartRequest(request, path, maxSize, encoding, rename);
		// multi : 해당하는 파일을 가지고 쓰겠습니다
		System.out.println("2");
		// BoardWrite.jsp 에서 보내주는 요청값 데이터 꺼내오기

		String title = multi.getParameter("title");
		String Writer = multi.getParameter("writer");
		// 설정해놓은 multi.~~~ title등등 로부터 폼테그로부터 값들을 가져오겠습니다
		System.out.println("3");
		// 사용자가 선택한 파일을 가져올때에는 한글이 포함되어 있을수 있다
		// 해당 내용에 대하여 인코딩 작언을 꼬~~~~~옥 진행하기!
		String filename = URLEncoder.encode(multi.getFilesystemName("filename"), "UTF-8");
		System.out.println("4");
		
		String content = multi.getParameter("content");
		System.out.println("title : " + title);
		System.out.println("Writer : " + Writer);
		System.out.println("filename : " + filename);
		System.out.println("content : " + content);

		// 데이터베이스 전달을 위한 작업
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();

		dto.setTitle(title);
		dto.setWriter(Writer);
		dto.setFilename(filename);
		dto.setContent(content);

		int result = dao.upload(dto);
		
		if (result > 0) {
			System.out.println("게시글 등록 성공");
		} else {
			System.out.println("등록 실패");
		}
		response.sendRedirect("BoardMain.jsp");

	}

}
