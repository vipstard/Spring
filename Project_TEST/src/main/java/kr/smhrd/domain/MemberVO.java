package kr.smhrd.domain;

import lombok.Data;

@Data
public class MemberVO {
	private int idx;
	private String name;
	private String pw;
	private String nick;
	private String email;
	private String Address;
	private String indate;
}
