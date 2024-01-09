package edu.pnu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pnu.domain.MemberVO;
import edu.pnu.dao.MemberDao;

@RestController
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;

	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return memberDao.getMembers();
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable("id") Integer id) {
		return memberDao.getMember(id);
	}
	
	@PostMapping("/member")
	public int addMember(MemberVO member) {
		return memberDao.addMember(member);
	}
	
	@PutMapping("/member")
	public int updateMembers(MemberVO member) {
		return memberDao.updateMembers(member);
	}
	
	@DeleteMapping("/member/{id}")
	public int removeMember(@PathVariable("id") Integer id) {
		return memberDao.removeMember(id);
	}
}