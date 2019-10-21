package com.kidream.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kidream.context.UserContext;
import com.kidream.persistence.mapper.IUserMapper;
import com.kidream.persistence.pojo.User;
import com.kidream.persistence.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserMapper userMapper;
	@Override
	public void checkLogin(String username, String password) {
		User user = userMapper.getUser(username, password);
		if (user == null) {
			throw new RuntimeException("’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°");
		}
		UserContext.setCurrentObject(user);
	}

	public User getUserByUsername(String username) {
		return userMapper.getUserByUsername(username);
	}

	@Override
	public void regist(String username, String password) {
		userMapper.insertUser(username,password);
	}
}
