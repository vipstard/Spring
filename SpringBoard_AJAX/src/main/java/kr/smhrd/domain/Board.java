package kr.smhrd.domain;

import lombok.Data;

@Data //get set 자동으로 생성 해주는 어노테이션
public class Board {
	private int idx;		//번호
	private String title;	//제목
	private String content;	//내용
	private String writer;	//작성자
	private String indate;	//작성일 ("2022-03-16")
	private int count;		//조회수
	private String memId; 	//작성아이디
	
	
}
