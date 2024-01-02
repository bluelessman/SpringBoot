package edu.pnu.Controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Data
public class BoardController {
	public BoardController(){
		System.out.println("===> BoardController 생성");
	}
	
	@GetMapping("/hello")
	public String hello(String name) {
		return "Hello : " + name;
	}
	
}