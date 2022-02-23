package com.jin.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //자동으로 setter/getter 생성
@AllArgsConstructor //자동으로 모은 attribute 포함하는 constructor
@NoArgsConstructor  //자동으로 빈 constructor
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
}
