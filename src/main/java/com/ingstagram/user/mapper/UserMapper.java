package com.ingstagram.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {
	public void updatePostByPostIdUserId(
			@Param("userId") int userId, 
			@Param("name") String name

}
