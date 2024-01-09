package edu.pnu.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberVO {
	private Integer id;
	private String pass;
	private String name;
	private Date regidate;
}
