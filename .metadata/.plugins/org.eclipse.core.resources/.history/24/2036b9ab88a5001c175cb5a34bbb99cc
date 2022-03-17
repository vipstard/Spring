package kr.smhrd.myapp;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.Board;
import kr.smhrd.mapper.BoardMapper;

//@Controller : Spring MVC 프로젝트에서 컨트롤러 역할
// 주로 View를 반환하기 위해 사용
@Controller
public class BoardController {
	
	@Autowired
	private BoardMapper mapper;
	
	//게시판리스트 요청받는 메서드
	//@RequestMapping : 특정 URI로 온 요청 처리 방식 정의
	@RequestMapping("/boardList.do")
	public String boardList(HttpServletRequest request) {
		ArrayList<Board> list = mapper.boardList();

		
		request.setAttribute("list", list);
		
		
		return "boardList";
	}

}
