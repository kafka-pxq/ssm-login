package com.kidream.persistence.service;

import com.kidream.persistence.pojo.User;

public interface IUserService {
	
	void checkLogin(String username,String password);
	
	User getUserByUsername(String username);
	
	void regist(String username, String password);
}
