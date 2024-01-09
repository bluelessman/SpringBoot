package edu.pnu;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pnu.Service.MemberService;
import edu.pnu.domain.MemberVO;



@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class MemberServiceTest {
	
	
	@Autowired
	private MemberService memberService;
	
	public MemberServiceTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	@Order(0)
	@DisplayName("초기화합니다.")
	public void test00() {
		for(int i = 100;i<=104;i++) {
			memberService.deleteMember(i);
		}
		for(int i = 1000;i<=1004;i++) {
			memberService.deleteMember(i);
		}
	}
	
	@Test
	@Order(3)
	@DisplayName("데이터를 입력합니다.")
	public void test01() {
		for(int i = 0;i<5;i++) {
			MemberVO member = MemberVO.builder().id(100+i).name("name"+(100+i)).pass("pass"+(100+i)).build();
			memberService.addMember(member);
		}

	}
	
	@Test
	@Order(2)
	@DisplayName("입력한 데이터를 읽어 옵니다")
	public void test02() {
		List<MemberVO> list = memberService.getMembers();
		for (MemberVO memberVO : list) {
			System.out.println(memberVO);
		}

	}
	
	@Test
	@Order(1)
	@DisplayName("추가 데이터를 입력합니다")
	public void test03() {
		for(int i = 0;i<5;i++) {
			MemberVO member = MemberVO.builder().id(1000+i).name("name"+(1000+i)).pass("pass"+(1000+i)).build();
			memberService.addMember(member);
		}

	}
	
	@Test
	@Order(4)
	@DisplayName("입력한 데이터를 다시 읽어 옵니다")
	public void test04() {
		List<MemberVO> list = memberService.getMembers();
		for (MemberVO memberVO : list) {
			System.out.println(memberVO);
		}

	}
}
