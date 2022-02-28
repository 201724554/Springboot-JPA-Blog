package com.jin.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice //모든 Controller에서 일어나는 error 처리
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = IllegalArgumentException.class) //@ControllerAdvice 없으면 해당 bean이 적용된 클래스 안에서 일어나는 error만 처리
	public String HandleArgException(IllegalArgumentException e)
	{
		return "<h1>"+e.getMessage()+"</h1>";
	}

}
