package kr.smhrd.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.Board;
import kr.smhrd.mapper.BoardMapper;

@Service
public class BoardService {
	@Autowired
	private BoardMapper mapper;
	
	//@ResponseBody : 자바 객체는 HTTP 응답객체로 변환주는데 사용
		
		public  ArrayList<Board> boardList(){
			ArrayList<Board> list = mapper.boardList();
			return list;
		}
		
	//boardContentUpdate.do
		//메서드 이름은 boardContentUpdate
		//매개변수 작성
		//@ResponseBody 작성
		//springboard 수정 추상메서드 interface 작성
		//sql작성 - xml
		//응답 데이터 x
		
		/* HashMap 사용해서 풀기
		 * @RequestMapping(value="/boardContentUpdate.do", method=RequestMethod.POST)
		 * 
		 * @ResponseBody public void boardContentUpdate(@RequestBody HashMap<String,
		 * Object> map) { mapper.boardContentUpdate(map);
		 * 
		 * 
		 * }
		 */
		
		
		
		public  void boardContentUpdate(Board vo) {
			mapper.boardContentUpdate(vo);
			
			
		}
		
		
		public  void boardInsert(Board vo) {
			mapper.boardInsert(vo);
			
		}
		
		
		public  void boardTWUpdate(Board vo) {
			mapper.boardTWUpdate(vo);
			
		}
		
		
		public  void boardDelete(Board vo) {
			mapper.boardDelete(vo);
		}
		
		
}
