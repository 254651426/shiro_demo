package com.yangjie.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.yangjie.dao.StudentDao;
import com.yangjie.dao.UserDao;
import com.yangjie.entity.User;
import com.yangjie.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private UserDao userDao;

	@Override
	public User getUser(String username) {
		// TODO Auto-generated method stub
		// String num = jdbcTemplate.queryForObject("select password from user
		// where username=" +"\'"+username+"\'", String.class);
		User u = userDao.getUser(username);
		return u;
	}

	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
