package edu.pnu;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import edu.pnu.domain.Board;
import edu.pnu.persistence.BoardRepository;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class QueryAnnotationTest {
	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	@Order(1)
	public void testQueryAnnotationTest1() {
		List<Board> list = boardRepo.queryAnnotationTest1("3번째 게시글");
		
		System.out.println("\n"+"=".repeat(20)+"\n");
		System.out.println("@query 어노테이션 위치 기반 파라미터");
		System.out.println("\n"+"=".repeat(20)+"\n");
		for (Board board : list) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Order(2)
	public void testQueryAnnotationTest2() {
		List<Board> list = boardRepo.queryAnnotationTest2("2번째 게시글");
		
		System.out.println("\n"+"=".repeat(20)+"\n");
		System.out.println("@query 어노테이션 이름 기반 파라미터");
		System.out.println("\n"+"=".repeat(20)+"\n");
		for (Board board : list) {
			System.out.println(board.toString());
		}
	}
	
	@Test
	@Order(3)
	public void testQueryAnnotationTest3() {
		List<Object[]> list = boardRepo.queryAnnotationTest3("3번째 게시글");
		
		System.out.println("\n"+"=".repeat(20)+"\n");
		System.out.println("@query 어노테이션 특정 변수 조회");
		System.out.println("\n"+"=".repeat(20)+"\n");
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}
	
	@Test
	@Order(4)
	public void testQueryAnnotationTest4() {
		List<Object[]> list = boardRepo.queryAnnotationTest4("4번째 게시글");
		
		System.out.println("\n"+"=".repeat(20)+"\n");
		System.out.println("@query 어노테이션 네이티브 쿼리");
		System.out.println("\n"+"=".repeat(20)+"\n");
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}
	
	@Test
	@Order(5)
	public void testQueryAnnotationTest5() {
		Pageable paging = PageRequest.of(0, 3,Sort.Direction.DESC, "seq");
		Page<Board> page = boardRepo.queryAnnotationTest5(paging);
		List<Board> list = page.getContent();
		System.out.println("\n"+"=".repeat(20)+"\n");
		System.out.println("@query 어노테이션 페이징 및 정렬 처리");
		System.out.println("\n"+"=".repeat(20)+"\n");
		for (Board board : list) {
			System.out.println(board.toString());
		}
	}
}
