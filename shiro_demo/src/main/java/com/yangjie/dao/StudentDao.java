package com.yangjie.dao;

import java.util.List;

import com.github.pagehelper.PageRowBounds;
import com.yangjie.entity.Student;

public interface StudentDao {

	public boolean show();

	public int insert(Student user);

	public Student getUser(int id);

	public List<Student> selectByUser(Student user, PageRowBounds pageRowBounds);
}
