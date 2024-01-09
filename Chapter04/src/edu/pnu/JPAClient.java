package edu.pnu;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.pnu.domain.Board;

public class JPAClient {
	
	private static void insertData(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Board board = new Board();
			board.setTitle("JPA 제목1");
			board.setCnt(1L);
			board.setContent("등록가능1");
			board.setCreateDate(new Date());
			board.setWriter("백진우1");
			em.persist(board);
			tx.commit();
			System.out.println("입력 성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error : " + e.getMessage());
			tx.rollback();
		} finally {
			em.close();
		}

	}
	
	private static void searchData(EntityManagerFactory emf) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		try {
			Board searchBoard = em.find(Board.class, 3L);
			System.out.println("---> " + searchBoard.toString());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error : " + e.getMessage());
		} finally {
			em.close();
		}

	}
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");
		try {
			insertData(emf);
			searchData(emf);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			emf.close();
		}

	}
}
