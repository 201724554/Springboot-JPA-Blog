package com.jin.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jin.blog.dto.ResponseDto;
import com.jin.blog.model.User;
import com.jin.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired //DI
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user)
	{
		System.out.println("UserApiController:save");
		userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update(@RequestBody User user)//json data 받으려면 @RequestBody, x-www-form-urlencoded data 받으려면 필요없음
	{
		userService.회원수정(user);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication); //강제로 다시 로그인,생성되는 authentication 객체를 SecurityContextHolder에 밀어넣음 -> 세션(authentication) 갱신
		return new ResponseDto<Integer>(HttpStatus.OK.value(),1); //즉, 회원 수정 후, 강제로 다시 로그인
	}
}
