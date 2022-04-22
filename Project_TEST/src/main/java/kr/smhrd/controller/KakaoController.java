package kr.smhrd.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.smhrd.service.KakaoService;

//카카로 로그인 컨트롤러 

@Controller
public class KakaoController {
	
    @Autowired
    private KakaoService kakaoService;

    @RequestMapping("/KakaoLogin")
    public String home(@RequestParam(value = "code", required = false) String code) throws Exception{
        System.out.println("#########" + code);
        String access_Token = kakaoService.getAccessToken(code);        
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
      
        System.out.println("###access_Token#### : " + access_Token);
        System.out.println("###userInfo#### : " + userInfo.get("email"));
        System.out.println("###nickname#### : " + userInfo.get("nickname"));
        
        return "redirect:/boardList";
    }
}