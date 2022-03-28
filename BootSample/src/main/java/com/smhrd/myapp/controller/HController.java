package com.smhrd.myapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HController {
	
	@RequestMapping("/home")
	public String home() {
		
		return "main";
	}

}
