package com.jin.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jin.blog.service.BoardService;

@Controller
public class BoardController {
	
	/*@Autowired
	private PrincipalDetail principal; 이렇게는 안됨
	*/
	@Autowired 
	private BoardService boardService;
	
	@GetMapping({"","/"})
	public String index(Model model, @PageableDefault(size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable)
	{
		model.addAttribute("boards",boardService.글목록(pageable)); //index로 attribute 전달
		return "index"; //WEB-INF/views의 index.jsp 찾아감 
						//viewResolver가 WEB-INF/views prefix로 붙혀주고 boards도 추가해줌
	}

	@GetMapping({"/board/saveForm"})
	public String saveForm()
	{
		return "board/saveForm";
	}
	
	@GetMapping({"/board/{id}"})
	public String findById(@PathVariable int id, Model model)
	{
		model.addAttribute("board",boardService.글상세보기(id));
		return "board/detail";
	}
	
	@GetMapping("/board/{id}/updateForm")
	public String updateForm(@PathVariable int id, Model model)
	{
		model.addAttribute("board", boardService.글상세보기(id));
		return "board/updateForm";
	}
	
}
