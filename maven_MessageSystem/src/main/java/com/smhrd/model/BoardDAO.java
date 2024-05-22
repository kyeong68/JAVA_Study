package com.smhrd.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.smhrd.db.SqlSessionManager;

public class BoardDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlsession();

	// 게시글 작성에 대한 메소드
	public int upload(BoardDTO dto) {

		// SqlSession sqlSession = SqlSessionFactory.opensession(true);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert("upload", dto);

		sqlSession.close();

		return result;

	}

	// 전체 게시글을 읽어올수 있는 메소드
	public ArrayList<BoardDTO> showBoard() {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		ArrayList<BoardDTO> list = new ArrayList<>();

		list = (ArrayList) sqlSession.selectList("showBoard");

		sqlSession.close();

		return list;

	}

	
	//게시글 상세보기 기능
	public BoardDTO showDetail(int num) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);

		BoardDTO list = sqlSession.selectOne("showDetail", num);

		sqlSession.close();

		return list;
	}

}
