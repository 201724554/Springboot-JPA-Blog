package com.jin.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jin.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	//JPA naming query
	Optional<User> findByUsername(String username);
	//JPA naming 쿼리
	//select * from user where username=?1 and password=?2 
	//실제로 해당 메소드는 존재 x, 근데 이름 이렇게 지으면 위 쿼리 역할 함
	//User findByUsernameAndPassword(String username, String password);
	
	//위랑 같음
	/*
	@Query(value="select * from user where username=?1 and password=?2",nativeQuery=true)
	User login(String username, String password);
	*/
}
