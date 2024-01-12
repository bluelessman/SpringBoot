package edu.pnu.persistence;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;

import edu.pnu.domain.Board;
import edu.pnu.domain.QBoard;

@Repository
public class DynamicQueryTest {

	@Autowired
	private DynamicBoardRepository boardRepo;


	public void testDynamicQuery() {
		String searchcondition = "title";
		String searchKeyword = "9";

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		if (searchcondition.equals("title")) {
			builder.and(qboard.title.like("%" + searchKeyword + "%"));
		} else if (searchcondition.equals("content")) {
			builder.and(qboard.content.like("%" + searchKeyword + "%"));
		}
		Pageable paging = PageRequest.of(0, 5);

		Page<Board> list = boardRepo.findAll(builder, paging);

		System.out.println("검색 결과");
		for (Board board : list) {
			System.out.println(board.toString());
		}
	}


	public List<Board> testDynamicQuery1() {
		String searchKeyword = "1";

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		builder.and(qboard.title.like("%" + searchKeyword + "%"));

		List<Board> list = (List<Board>) boardRepo.findAll(builder);

//		System.out.println("검색 결과");
//		for (Board board : list) {
//			System.out.println(board.toString());
//		}
		return list;
	}


	public List<Board> testDynamicQuery2() {

		int searchCnt = 50;

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		builder.and(qboard.cnt.gt(searchCnt));

		List<Board> list = (List<Board>) boardRepo.findAll(builder);

//		System.out.println("검색 결과");
//		for (Board board : list) {
//			System.out.println(board.toString());
//		}
		
		return list;
	}


	public List<Board> testDynamicQuery3() {
		String searchcondition = "title";
		String searchTitle = "1";
		int searchCnt = 50;

		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;

		if (searchcondition.equals("title")) {
			builder.and(qboard.title.like("%" + searchTitle + "%"));
		} else if (searchcondition.equals("cnt")) {
			builder.and(qboard.cnt.gt(searchCnt));
		}
		Pageable paging = PageRequest.of(0, 5);

		Page<Board> list = boardRepo.findAll(builder, paging);

//		System.out.println("검색 결과");
//		for (Board board : list) {
//			System.out.println(board.toString());
//		}
		
		List<Board> returnlist = list.getContent();
		return returnlist;
	}


	public List<Board> getBoard(String condition, String value, boolean isPaging) {
		// TODO Auto-generated method stub
		BooleanBuilder builder = new BooleanBuilder();

		QBoard qboard = QBoard.board;
		if (condition.equals("title")) {
			builder.and(qboard.title.like("%" + searchTitle + "%"));
		} else if (condition.equals("cnt")) {
			builder.and(qboard.cnt.gt(searchCnt));
		}
		Pageable paging = PageRequest.of(0, 5);

		Page<Board> list = boardRepo.findAll(builder, paging);

//		System.out.println("검색 결과");
//		for (Board board : list) {
//			System.out.println(board.toString());
//		}
		
		List<Board> returnlist = list.getContent();
		return returnlist;
	}
}
