package com.yangjie.dao;

import java.util.List;

import com.yangjie.entity.Perms;

public interface PermsDao {
	public List<String> getPerms(String username);
}
