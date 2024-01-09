package edu.pnu.Controller;

import org.springframework.web.bind.annotation.RestController;

import edu.pnu.Domain.MemberVO;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class MemberController {
	List<MemberVO> list;
	public MemberController(){
		System.out.println("===> MemberController 생성");
		list = new ArrayList<MemberVO>();
		for(int i=1;i<=10;i++) {
			list.add(MemberVO.builder().id(i).name("테스터"+i).pass("1234"+i).regidate(new Date()).build());
		}
	}
	
	
//	private MemberVO isExistMember(MemberVO member) {
//		for (MemberVO memberVO : list) {
//			if(member.getId()==memberVO.getId()) {
//				return memberVO;
//			}
//		}
//		return null;
//	}
	
	@GetMapping("/member")
	public List<MemberVO> getMembers(){
		return list;
	}
	
	@GetMapping("/member/{id}")
	public MemberVO getMember(@PathVariable("id") Integer id) {
		for (MemberVO memberVO : list) {
			if(id==memberVO.getId()) {
				return memberVO;
			}
		}
		return null;
	}
	
	@PostMapping("/member")
	public int addMember(MemberVO member) {
		member.setRegidate(new Date());
		for (MemberVO memberVO : list) {
			if(member.getId()==memberVO.getId()) {
				return 0;
			}
		}

		list.add(member);
		return 1;
	}
	
	
	@PostMapping("/memberJSON")
	public int addMemberJSON(@RequestBody MemberVO member) {
		member.setRegidate(new Date());
		for (MemberVO memberVO : list) {
			if(member.getId()==memberVO.getId()) {
				return 0;
			}
		}

		list.add(member);
		return 1;
	}
	
	@PutMapping("/member")
	public int updateMembers(MemberVO member) {
		for (MemberVO memberVO : list) {
			if(member.getId()==memberVO.getId()) {
				memberVO.setName(member.getName());
				memberVO.setPass(member.getPass());
				memberVO.setRegidate(new Date());
				return 1;
			}
		}
		return 0;
	}
	
	@DeleteMapping("/member/{id}")
	public int removeMember(@PathVariable("id") Integer id) {
		for (MemberVO memberVO : list) {
			if(id==memberVO.getId()) {
				list.remove(memberVO);
				return 1;
			}
		}
		return 0;
	}
}
