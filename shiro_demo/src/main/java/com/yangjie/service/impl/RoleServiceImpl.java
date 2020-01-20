package com.yangjie.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangjie.dao.RoleDao;
import com.yangjie.entity.Role;
import com.yangjie.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roledao;

	@Override
	public Role getRole(int id) {
		// TODO Auto-generated method stub
		return roledao.getRole(id);
	}

}
