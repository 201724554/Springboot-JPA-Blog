package com.jin.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.jin.blog.model.User;

import lombok.Getter;

//스프링 시큐리티가 로그인 요청을 가로채서 로그인 진행해서 완료되면 UserDetails 타입 오브젝트를 스플이 시큐리티 고유 세션에 저장
@Getter
public class PrincipalDetail implements UserDetails{
	private User user;
	
	public PrincipalDetail(User user)
	{
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() { //계정이 가진 권한 목록을 리턴, 이번 경우는 권한 종류 하나여서 loop x
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(()->{return "ROLE_"+user.getRole();});
		return collectors;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() { //계정이 만료되었는지 true - 만료 안됨
		return true;
	}

	@Override
	public boolean isAccountNonLocked() { //계정이 잠겨있지 않는지
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() { //비밀번호가 만료되었는지
		return true;
	}

	@Override
	public boolean isEnabled() { //계정이 활성화되있는지
		return true;
	}
	
	
}
