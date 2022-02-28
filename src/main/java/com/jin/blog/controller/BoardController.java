package com.jin.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@GetMapping({"","/"})
	public String index()
	{
		return "index"; //WEB-INF/views의 index.jsp 찾아감
	}
}
