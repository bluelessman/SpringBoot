package edu.pnu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	public MemberController() {
		System.out.println("MemberController 생성");
	}
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return memberService.getMembers();
	}
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable("id") int id) {
		return memberService.getMember(id);
	}
	@PostMapping("/member")
	public int addMember(MemberVO member) {
		return memberService.addMember(member);
	}

	
	@PutMapping("/member")
	public int updateMember(MemberVO member) {
		return memberService.updateMember(member);
	}
	
	@DeleteMapping("member/{id}")
	public int deleteMember(@PathVariable("id") int id) {
		return memberService.deleteMember(id);
	}
}
