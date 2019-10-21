package com.kidream.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.kidream.context.UserContext;

public class CheckLoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (UserContext.getCurrentObject() == null) {
			response.sendRedirect("/ssm-testLogin/login.jsp");
			return false;
		}
		return true;
	}
}
