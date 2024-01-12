package edu.pnu;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class BoardRepositoryTest {
	@Autowired
	private BoardRepository boardRepo;

//	@Test
//	@Order(0)
//	public void testInsertBoard() {
//		Board board;
//		Random rand = new Random();
//		for (int i = 0; i < 100; i++) {
//			board = new Board();
//			board.setTitle(i + "번째 게시글");
//			board.setWriter("테스터" + i);
//			board.setContent("잘 등록되나요" + i);
//			board.setCreateDate(new Date());
//			Long cnt = rand.nextLong(101);
//			board.setCnt(cnt);
//			boardRepo.save(board);
//		}
//	}

//	public void testGetAllBoard() {
//		List<Board> list = boardRepo.findAll();
//		for (Board board : list) {
//			System.out.println(board.toString());
//		}
//	}
//	@Test
//	@Order(1)
//	public void testGetBoard() {
//		Board board = boardRepo.findById(2L).get();
//		System.out.println(board.toString());
//	}
//	
//	@Test
//	@Order(2)
//	public void testUpdateBoard() {
//		Board board = boardRepo.findById(2L).get();
//		board.setTitle("제목을 수정했습니다");
//		boardRepo.save(board);
//		System.out.println("변경완료");
//		testGetAllBoard();
//	}
//	
//	@Test
//	@Order(3)
//	public void testDeleteBoard() {
//		boardRepo.deleteById(2L);
//		System.out.println("삭제완료");
//		testGetAllBoard();
//	}
	@Test
	@Order(1)
	public void mission1() {
		Pageable paging = PageRequest.of(1, 10, Sort.Direction.ASC, "seq");
		Page<Board> page = boardRepo.findByTitleContaining("1",paging);
		System.out.println("=".repeat(20));
		System.out.println("mission 1");
		System.out.println("=".repeat(20));
		List<Board> list = page.getContent();
		System.out.println(page.getTotalPages());
		for (Board board : list) {
			System.out.println(board);
		}
	}
//	
//	@Test
//	@Order(2)
//	public void mission2() {
//		List<Board> list = boardRepo.findByTitleContainingAndCntGreaterThan("1",50L);
//		System.out.println("=".repeat(20));
//		System.out.println("mission 2");
//		System.out.println("=".repeat(20));
//		for (Board board : list) {
//			System.out.println(board);
//		}
//	}
//	
//	@Test
//	@Order(3)
//	public void mission3() {
//		List<Board> list = boardRepo.findByCntBetweenOrderBySeqAsc(10L,50L);
//		System.out.println("=".repeat(20));
//		System.out.println("mission 3");
//		System.out.println("=".repeat(20));
//		for (Board board : list) {
//			System.out.println(board);
//		}
//	}
//	
//	@Test
//	@Order(4)
//	public void mission4() {
//		List<Board> list = boardRepo.findByTitleContainingOrContentContainingOrderBySeqDesc("10", "2");
//		System.out.println("=".repeat(20));
//		System.out.println("mission 4");
//		System.out.println("=".repeat(20));
//		for (Board board : list) {
//			System.out.println(board);
//		}
//	}
}
