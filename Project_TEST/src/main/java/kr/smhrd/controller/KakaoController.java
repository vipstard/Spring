package kr.smhrd.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.domain.MemberVO;
import kr.smhrd.service.KakaoService;
import kr.smhrd.service.MemberService;

//카카로 로그인 컨트롤러 

@Controller
public class KakaoController {
	
    @Autowired
    private KakaoService kakaoService;


    @RequestMapping("/KakaoLogin")
    public String home(@RequestParam(value = "code", required = false) String code, HttpSession session) throws Exception{
        System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code);        
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
      
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        
        String email =(String)userInfo.get("email");
        MemberVO K_Login = kakaoService.K_Login(email);
        
        System.out.println("성공 : " + K_Login);
        System.out.println("KaKaoController : " + access_Token);
        if(K_Login!=null) {
        	session.setAttribute("LoginVo", K_Login);
        	session.setAttribute("access_Token", access_Token);
        	
        }else {
        	System.out.println("일치하는 아이디가 없습니다.");
        }
        
        
        return "redirect:/boardList";
    }
}