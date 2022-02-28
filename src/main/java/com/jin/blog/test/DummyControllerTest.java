package com.jin.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jin.blog.model.RoleType;
import com.jin.blog.model.User;
import com.jin.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@DeleteMapping("/dummy/user/{id}")
	public String delete(@PathVariable int id)
	{
		try 
		{
			userRepository.deleteById(id);
		} 
		catch(Exception e) 
		{
			return "삭제 실패, id 존재하지 않음";
		}
		return "삭제되었습니다 " + id;
	}
	
	@Transactional //더티 체킹, 함수 종료 시 자동 commit, 하나의 transaction으로 묶음
	@PutMapping("/dummy/user/{id}")
	public User updateUser(@PathVariable int id, @RequestBody User requestUser) 
	{		
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("수정에 실패했습니다");
		});
		user.setPassword(requestUser.getPassword());
		user.setEmail(requestUser.getEmail());
		//userRepository.save(requestUser); //@Transactional 있으면 save 없어도 update
		return user;
	}
	
	@GetMapping("/dummy/users")
	public List<User> list()
	{
		return userRepository.findAll();
	}
	
	@GetMapping("dummy/user")
	public List<User> pageList(@PageableDefault(size = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable)
	{
		Page<User> pagingUsers = userRepository.findAll(pageable);
		List<User> users = pagingUsers.getContent();
		return users;
	}
	
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id)
	{
		//findById 메소드는 Optional 객체 return
		User user = userRepository.findById(id).orElseThrow/*<-못 찾을 수도 있으니까*/(new Supplier<IllegalArgumentException>()
				{
					@Override
					public IllegalArgumentException get() 
					{
						// TODO Auto-generated method stub
						return new IllegalArgumentException("해당 유저는 없습니다. id: " + id);
					}
			
				}); 
		return user;
	}
	
	@PostMapping("/dummy/join")
	public String join(User user)
	{
		System.out.println(user.getId());
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getEmail());
		System.out.println(user.getRole());
		System.out.println(user.getCreateDate());
		user.setRole(RoleType.USER);
		userRepository.save(user);//save는 id가 없으면 insert, 있으면 update
		return "회원가입 완료";
	}
}
