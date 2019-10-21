package com.kidream.persistence.mapper;

import org.apache.ibatis.annotations.Param;

import com.kidream.persistence.pojo.User;

public interface IUserMapper {

	User getUser(@Param("username")String username,@Param("password")String password);
	
	User getUserByUsername(@Param("username")String username);

	void insertUser(@Param("username")String username, @Param("password")String password);
}
