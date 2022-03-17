package com.jin.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jin.blog.config.auth.PrincipalDetailService;

@Configuration //bean 등록
@EnableWebSecurity //시큐리티 필터 등록
@EnableGlobalMethodSecurity(prePostEnabled=true) //특정 주소로 접근하면 권한 및 인증을 미리 체크, 이 3개는 사실상 세트
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private PrincipalDetailService principalDetailService;
	
	@Bean	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}


	@Bean //IoC
	public BCryptPasswordEncoder encodePWD()
	{
		return new BCryptPasswordEncoder(); //리턴값을 스프링이 관리함
	}
	
	
	//시큐리티가 대신 로그인해주는데 pwd 가로채서 뭘로 hash 돼있는지 알아야함. 그래야 db에 암호화된 hash와 비교할 수 있음
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http
			.csrf().disable()
			.authorizeRequests() //request가 들어오면
				.antMatchers("/","/auth/**","/js/**","/css/**","/image/**") //누구든 auth로 들어오면 허용
				.permitAll()
				.anyRequest() //else 
				.authenticated() //인증 되어 있어야함
			.and()
				.formLogin()
				.loginPage("/auth/loginForm") //자동으로 로그인 페이지로 이동
				.loginProcessingUrl("/auth/loginProc") //스프링 시큐리티가 해당 주소에서 오는 로그인 가로채서 대신 로그인 해줌
				.defaultSuccessUrl("/"); //로그인 성공시 이동하는 url
				//.failureUrl("/fail") //실패하면 여기로
	}

}
