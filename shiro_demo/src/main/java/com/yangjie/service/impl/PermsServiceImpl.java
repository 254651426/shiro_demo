package com.yangjie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangjie.dao.PermsDao;
import com.yangjie.entity.Perms;
import com.yangjie.service.PermsService;

@Service
public class PermsServiceImpl implements PermsService {

	@Autowired
	PermsDao permsdao;

	@Override
	public List<String> getPerms(String username) {
		// TODO Auto-generated method stub
		return permsdao.getPerms(username);
	}

}
