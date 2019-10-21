package com.kidream.persistence.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	
	public User() {}
	
	private Long id;
	@NotNull(message = "用户名不能为空")
	@Size(min = 5,max=10,message = "用户名在5-10位数之间")
	private String username;
	@NotNull(message = "密码不能为空")
	@Size(min = 5,max=10,message = "密码在5-10位数之间")
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(Long id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	
}
