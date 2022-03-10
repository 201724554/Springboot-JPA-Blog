package com.jin.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.jin.blog.dto.ResponseDto;

@ControllerAdvice //모든 Controller에서 일어나는 error 처리
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class) //@ControllerAdvice 없으면 해당 bean이 적용된 클래스 안에서 일어나는 error만 처리
	public ResponseDto<String> HandleArgException(IllegalArgumentException e)
	{
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
	}

}
