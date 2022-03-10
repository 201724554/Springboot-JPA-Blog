package com.jin.blog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.jin.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
	
	/*@Autowired
	private PrincipalDetail principal; 이렇게는 안됨
	*/
	
	@GetMapping({"","/"})
	public String index(@AuthenticationPrincipal PrincipalDetail principal/*시큐리티 세션 접근*/)
	{
		return "index"; //WEB-INF/views의 index.jsp 찾아감
	}
}
