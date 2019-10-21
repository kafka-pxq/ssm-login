package com.kidream.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kidream.context.UserContext;
import com.kidream.persistence.pojo.User;
import com.kidream.persistence.service.IUserService;

/**
 * 登录界面用户操作
 * 
 * @author 蒲先泉
 *
 */
@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	/**
	 * 登录检查操作
	 * 
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping("checkLogin")
	public String checkLogin(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
		try {
			userService.checkLogin(username, password);
		} catch (Exception e) {
			session.setAttribute("errorMsg", e.getMessage());
			return "redirect:/login.jsp";
		}
		return "redirect:index";
	}

	/**
	 * 注销登录操作
	 * 
	 * @return
	 */
	@RequestMapping("cancellation")
	public String cancellation() {
		UserContext.getSession().invalidate();
		return "redirect:/login.jsp";
	}

//	@RequestMapping("checkLogon")
//	public String checkLogon(@RequestParam("username") String username, @RequestParam("password") String password) {
//		System.out.println(username);
//		System.out.println(password);
//		User user = userService.getUserByUsername(username);
//		if (user != null) {
//			System.out.println(user);
//			return "redirect:/register.jsp";
//		} else {
//			userService.regist(username, password);
//			return "redirect:/login.jsp";
//		}
//	}

	/**
	 * 注册检查操作 账号不能相同，密码可以相同
	 * 
	 * @return
	 */
	@RequestMapping("regist")
	public String regist(@Validated User user, BindingResult bindingResult, Model model) {
		List<ObjectError> errors = bindingResult.getAllErrors();
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		System.out.println(user.getId());
		if (errors.size() > 0) {
//			model.addAttribute("user",new User());
			model.addAttribute("errors", errors);
			System.out.println("用户名和密码格式不正确");
			return "forward:/register.jsp";
		}
		System.out.println(user.toString());
		User flag = userService.getUserByUsername(user.getUsername());
		if (flag != null) {
//			// 该账户已经存在了，数据库中已有该账户，不允许重复注册
			model.addAttribute("error", "该ID已被注册");
			return "forward:/register.jsp";
		}
		userService.regist(user.getUsername(), user.getPassword());
		return "redirect:/login.jsp";
	}
}
