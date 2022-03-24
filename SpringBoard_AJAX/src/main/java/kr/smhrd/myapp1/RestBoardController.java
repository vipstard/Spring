package kr.smhrd.myapp1;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.smhrd.domain.Board;
import kr.smhrd.service.BoardService;



@RestController //Controller와 ResponseBody 합친것과 같다.

public class RestBoardController {
	
	@Autowired
	private BoardService service;
	
	//@ResponseBody : 자바 객체는 HTTP 응답객체로 변환주는데 사용
		@RequestMapping("/boardList.do")
		public  ArrayList<Board> boardList(){
			ArrayList<Board> list = service.boardList();
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
		 * Object> map) { service.boardContentUpdate(map);
		 * 
		 * 
		 * }
		 */
		
		
		@RequestMapping("/boardContentUpdate.do")
		public  void boardContentUpdate(Board vo) {
			service.boardContentUpdate(vo);
			
			
		}
		
		@RequestMapping("/boardInsert.do")
		public  void boardInsert(Board vo) {
			service.boardInsert(vo);
			
		}
		
		@RequestMapping("/boardTWUpdate.do")
		public  void boardTWUpdate(Board vo) {
			service.boardTWUpdate(vo);
			
		}
		
		@RequestMapping("/boardDelete.do")
		public  void boardDelete(Board vo) {
			service.boardDelete(vo);
		}
}
