package com.jin.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jin.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>
{
	
}
