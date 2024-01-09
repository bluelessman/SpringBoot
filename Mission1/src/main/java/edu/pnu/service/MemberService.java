package edu.pnu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.pnu.domain.MemberVO;

@Service
public class MemberService {
	private List<MemberVO> list;
	
	public MemberService() {
		list = new ArrayList<MemberVO>();
		for(int i = 1; i<=10;i++) {
			list.add(MemberVO.builder().id(i).name("미션1테스터"+i).pass("1234"+i).regidate(new Date()).build());
		}
	}
	
	public List<MemberVO> getMembers(){
		return list;
	}
	
	public MemberVO getMember(int id) {
		for (MemberVO memberVO : list) {
			if(id==memberVO.getId()) {
				return memberVO;
			}
		}
		return null;
	}
	
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
	
	public int removeMember(int id) {
		for (MemberVO memberVO : list) {
			if(id==memberVO.getId()) {
				list.remove(memberVO);
				return 1;
			}
		}
		return 0;
	}
}
