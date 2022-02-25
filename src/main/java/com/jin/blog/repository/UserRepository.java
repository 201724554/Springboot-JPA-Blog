package com.jin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jin.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{

}
