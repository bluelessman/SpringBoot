package edu.pnu.persistence;

import java.util.List;


import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pnu.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Page<Board> findByTitleContaining(String title, Pageable paging);
	List<Board> findByTitleContainingAndCntGreaterThan(String title,long cnt);
	List<Board> findByCntBetweenOrderBySeqAsc(long cnt1, long cnt2);
	List<Board> findByTitleContainingOrContentContainingOrderBySeqDesc(String title, String content);
	
	@Query("select b from Board b where b.title like %?1% order by b.seq desc")
	List<Board> queryAnnotationTest1(String searchKeyword);
	
	@Query("select b from Board b "
			+ "where b.title like %:searchKeyword% "
			+"order by b.seq asc")
	List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	
	@Query("select b.seq, b.title, b.writer, b.createDate "
			+ "from Board b "
			+ "where b.title like %:searchKeyword% "
			+ "order by b.seq desc")
	List<Object[]> queryAnnotationTest3(@Param("searchKeyword") String searchKeyword);

	@Query(value="select seq, title, writer, create_date "
			+ "from board "
			+ "where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery=true)
	List<Object[]> queryAnnotationTest4(String searchKeyword);
	
	@Query("select b from Board b order by b.seq desc")
	Page<Board> queryAnnotationTest5(Pageable paging);
}
