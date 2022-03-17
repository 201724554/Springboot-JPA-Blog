package com.jin.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jin.blog.model.RoleType;
import com.jin.blog.model.User;
import com.jin.blog.repository.UserRepository;

@Service //스프링이 컴포넌트 스캔을 통해 bean에 등록을 해줌, IoC
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional //하나의 transaction으로 atomic하게
	public void 회원가입(User user)
	{
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	@Transactional 
	public void 회원수정(User user)
	{
		User persistance = userRepository.findById(user.getId())
				.orElseThrow(()->{return new IllegalArgumentException("유저 찾기 실패");});
		String rawPassword = user.getPassword();
		/*if(rawPassword.equals("") || user.getEmail().equals(""))
		{
			throw new IllegalArgumentException("비밀번호와 메일을 입력해야 합니다");
		}*/
		String encodePassword = encoder.encode(rawPassword);
		persistance.setPassword(encodePassword);
		persistance.setEmail(user.getEmail()); //더티체킹
	}
}
