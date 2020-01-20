package com.yangjie.service;


import java.util.List;

import com.yangjie.entity.Student;

public interface StudentService {

	 public void add();
	 
	 public boolean show();

	int insert(Student user); 
	
	public Student getUser(int id);
	
	List<Student> getUserlist(Student user, Integer pageNum, Integer pageSize);
}
