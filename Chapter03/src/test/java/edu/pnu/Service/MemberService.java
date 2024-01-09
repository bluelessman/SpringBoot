package edu.pnu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberVO;


@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public MemberService() {
		// TODO Auto-generated constructor stub
		System.out.println("memberservice 생성");
	}
	
	public List<MemberVO> getMembers(){
		return memberDao.getMembers();
	}
	
	public MemberVO getMember(int id) {
		return memberDao.getMember(id);
	}
	

	public int addMember(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDao.addMember(member);
	}

	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return memberDao.updateMember(member);
	}

	public int deleteMember(int id) {
		// TODO Auto-generated method stub
		return memberDao.deleteMember(id);
	}
}
