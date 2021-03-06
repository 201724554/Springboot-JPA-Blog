package com.jin.blog.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jin.blog.model.User;
import com.jin.blog.repository.UserRepository;

@Service //빈 등록
public class PrincipalDetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override //스프링이 로그인 요청을 가로챌 때 username과 password 가로채는데, password 부분 처리는 알아서 함, username이 db에 있는지 확인해주면 됨
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User principal = userRepository.findByUsername(username)
				.orElseThrow(()->
				{
					return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다:"+username);
				});
		return new PrincipalDetail(principal);//시큐리티 세션에 user 정보 저장됨
	}
}
