package com.kidream.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.kidream.persistence.service.IUserService;

@ContextConfiguration(value="classpath:applicationContext.xml")
@SpringJUnitConfig
public class Test {
	@Autowired
	private IUserService userService;
	@org.junit.jupiter.api.Test
	void testGet() throws Exception {
		userService.checkLogin("·¶±ù±ù", "fanbingbing");
	}
	
}
