package com.jin.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jin.blog.dto.ResponseDto;
import com.jin.blog.model.RoleType;
import com.jin.blog.model.User;
import com.jin.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired //DI
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user)
	{
		System.out.println("UserApiController:save");
		user.setRole(RoleType.USER);
		int result = userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK,result);
	}
}
