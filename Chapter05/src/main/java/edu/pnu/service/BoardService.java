package edu.pnu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.domain.Board;

import edu.pnu.persistence.DynamicQueryTest;

@Service
public class BoardService {
	
	@Autowired
	private DynamicQueryTest dRepo;



	public List<Board> getBoard(String condition, String value, boolean isPaging) {
		// TODO Auto-generated method stub
		return dRepo.getBoard(condition,value,isPaging);
	}

}
