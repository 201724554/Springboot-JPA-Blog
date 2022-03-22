package com.jin.blog.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {

	@GetMapping("/auth/joinForm")
	public String joinForm()
	{
		return "user/joinForm";
	}
	
	@GetMapping("/auth/loginForm")
	public String loginForm()
	{
		return "user/loginForm";
	}
	
	@GetMapping("/user/updateForm")
	public String updateForm()
	{
		return "user/updateForm";
	}
	
	@GetMapping("/auth/kakao/callback")
	public @ResponseBody String kakaoCallback(String code) //@ResponseBody -> data를 리턴해주는 컨트롤러 함수
	{
		RestTemplate rt = new RestTemplate();
		HttpHeaders header = new HttpHeaders();
		header.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("grant_type","authorization_code");
		params.add("client_id","58e9b2e62e635e63b04c19e20acefae5");
		params.add("redirect_uri","http://localhost:8000/auth/kakao/callback");
		params.add("code",code);
		
		//HttpHeader와 HttpBody를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = new HttpEntity<>(params, header);
		
		//Http 요청 후, request에 해당하는 response 받아옴
		ResponseEntity response = rt.exchange(
					"https://kauth.kakao.com/oauth/token",
					HttpMethod.POST,
					kakaoTokenRequest,
					String.class //response의 type
				);
		return "카카오 토큰 요청 완료, response: " + response;
	}
}
