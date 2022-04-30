package kr.smhrd.domain;

import lombok.Data;


@Data
public class Criteria {
	
	/* 현재페이지 */
	private int pageNum;
	
	/* 한 페이지 당 보여질 게시물 개수 */
	private int amount;
	
	/* 기본생성자 -> 기본 세팅 : pageNum = 1, amount 10 */
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}
	

}
