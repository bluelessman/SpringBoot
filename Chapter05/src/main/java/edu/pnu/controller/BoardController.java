package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.Board;
import edu.pnu.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class BoardController {
	public BoardController() {
		// TODO Auto-generated constructor stub
		System.out.println("controller 생성");
	}
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/Chpater05")
	public List<Board> getBoard(String condition, String value, boolean isPaging) {

			return boardService.getBoard(condition,value,isPaging);

	}
	
}
