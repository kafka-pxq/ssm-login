package com.kidream.context;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.kidream.persistence.pojo.User;

public class UserContext {
	private static  final String USER_IN_SESSION = "user_in_session";
	public static HttpSession getSession() {
		return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest().getSession();
	}
	
	public static void setCurrentObject(User user) {
		if (user != null) {
			getSession().setAttribute(USER_IN_SESSION, user);
		}else {
			getSession().invalidate();
		}
	}
	
	public static User getCurrentObject() {
		return (User) getSession().getAttribute(USER_IN_SESSION);
	}
	
}
