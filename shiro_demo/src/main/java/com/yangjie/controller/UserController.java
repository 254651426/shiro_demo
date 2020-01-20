package com.yangjie.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yangjie.entity.SysMenuEntity;
import com.yangjie.entity.User;
import com.yangjie.entity.Student;
import com.yangjie.entity.meet;
import com.yangjie.service.StudentService;
import com.yangjie.util.AcenterApi;
import com.yangjie.util.MD5Util;
import com.yangjie.util.PageUtils;
import com.yangjie.util.R;

@RestController
public class UserController {

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/hello", produces = "text/html; charset=utf-8")
	public ModelAndView show() {
		studentService.getUser(2);
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	@PostMapping(value = "/subLogin", produces = "application/json;charset=utf-8")
	public ModelAndView subLogin(User user, HttpServletRequest req) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
		try {
			subject.login(token);
		} catch (IncorrectCredentialsException ice) {
			ModelAndView view = new ModelAndView("403");
			return view;
		} catch (UnknownAccountException ue) {
			ModelAndView view = new ModelAndView("403");
			return view;
		}
		ModelAndView view = new ModelAndView("index");
		return view;
	}

}
