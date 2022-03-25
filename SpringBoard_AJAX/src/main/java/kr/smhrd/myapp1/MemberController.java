package kr.smhrd.myapp1;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.smhrd.domain.Member;
import kr.smhrd.service.MemberService;

@Controller 
public class MemberController {
	@Autowired
	private MemberService MemberService;
	
	
	@RequestMapping("/login.do")
	public String login(Member vo, HttpSession session) {
		//1. 매개인자 : Member
		//2. service 작성
		//3. service - login() 반환값 받아주기
		//4. 세션 생성 (로그인이 가능한지(생성) / 불가능 한지 파악)
		//5. board.jsp 돌아가기
		Member Login=MemberService.login(vo);
		
		if(Login!=null) {
			session.setAttribute("LoginVO", Login);
		}
		
		return "redirect:/";
		
	}
	
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
			
		///session.removeAttribute("LoginVO"); // LoginVO 세션 삭제
		session.invalidate(); //세션 전부 삭제
		return "redirect:/";
	}

}
