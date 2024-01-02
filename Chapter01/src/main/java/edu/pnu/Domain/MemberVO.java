package edu.pnu.Domain;

import java.util.Date;



import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class MemberVO {
	private int id;
	private String pass;
	private String name;
	private Date regidate;
}
