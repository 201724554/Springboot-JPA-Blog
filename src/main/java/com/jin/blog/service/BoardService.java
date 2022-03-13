package com.jin.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jin.blog.config.auth.PrincipalDetail;
import com.jin.blog.model.Board;
import com.jin.blog.model.User;
import com.jin.blog.repository.BoardRepository;

@Service //스프링이 컴포넌트 스캔을 통해 bean에 등록을 해줌, IoC
public class BoardService {
	
	@Autowired
	private BoardRepository boardRepository;
	
	
	@Transactional //하나의 transaction으로 atomic하게
	public void 글쓰기(Board board, User user)
	{
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable)
	{
		return boardRepository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Board 글상세보기(int id)
	{
		return boardRepository.findById(id)
				.orElseThrow(()->{return new IllegalArgumentException("글 상세보기 실패: 아이디를 찾을 수 없음");});
	}
		
	@Transactional
	public void 글삭제하기(int id, PrincipalDetail principal)
	{
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{return new IllegalArgumentException("글 찾기 실패: 글이 존재하지 않음");});
		if(board.getUser().getId() != principal.getUser().getId())
		{
			throw new IllegalStateException("글 삭제 실패: 권한이 없음");
		}
		boardRepository.deleteById(id);
	}
	
	@Transactional
	public void 글수정하기(int id, Board requestBoard, PrincipalDetail principal)
	{
		Board board = boardRepository.findById(id)
				.orElseThrow(()->{return new IllegalArgumentException("글 찾기 실패: 글이 존재하지 않음");}); //영속화
		if(board.getUser().getId() != principal.getUser().getId())
		{
			throw new IllegalStateException("글 수정 실패: 권한이 없음");
		}
		board.setTitle(requestBoard.getTitle());
		board.setContent(requestBoard.getContent()); //더티체킹, 서비스 종료시 자동 업데이트
	}
}

