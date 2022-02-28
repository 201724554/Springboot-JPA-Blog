package com.jin.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jin.blog.model.User;
import com.jin.blog.repository.UserRepository;

@Service //스프링이 컴포넌트 스캔을 통해 bean에 등록을 해줌, IoC
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional //하나의 transaction으로 atomic하게
	public Integer 회원가입(User user)
	{
		try{
			userRepository.save(user);
			return 1;
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("UserService:회원가입():" + e.getMessage());
		}
		return -1;
	}
	
}
