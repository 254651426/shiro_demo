package com.yangjie.dao;

import java.util.List;

import com.github.pagehelper.PageRowBounds;
import com.yangjie.entity.Student;
import com.yangjie.entity.User;

public interface UserDao {

	public User getUser(String username);

}
