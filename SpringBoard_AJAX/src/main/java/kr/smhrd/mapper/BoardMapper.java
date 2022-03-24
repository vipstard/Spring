package kr.smhrd.mapper;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kr.smhrd.domain.Board;

public interface BoardMapper {
	
	//전체 게시물 가지고오기
	public ArrayList<Board> boardList();
	
	
	
	//	특정 게시글 수정
	//public void boardContentUpdate(HashMap<String, Object> map);
	/*
	 * @Update("update springboard set content=#{content} where idx=#{idx}") public
	 * void boardContentUpdate(Board vo);
	 */
	
	public void boardContentUpdate(Board vo);
	
	public void boardInsert(Board vo);
	
	public void boardTWUpdate(Board vo);
	
	@Delete ("delete from springboard where idx=#{idx}")
	public void boardDelete(Board vo);
}
