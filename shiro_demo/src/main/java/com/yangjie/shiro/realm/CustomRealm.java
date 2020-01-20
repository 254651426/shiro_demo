package com.yangjie.shiro.realm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yangjie.entity.Role;
import com.yangjie.entity.User;
import com.yangjie.service.PermsService;
import com.yangjie.service.RoleService;
import com.yangjie.service.UserService;


/**
 * 自定义Realm
 * 
 * @author : xdong
 * @create : 14:29 2018/6/28
 * @Param :
 * @return :
 **/

@Component
public class CustomRealm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private PermsService permsservice;

	@Autowired
	private RoleService roleservice;

	Map<String, String> userMap = new HashMap<>(16);
	{
		userMap.put("Mark", "d40fdd323f5322ff34a41f026f35cf20");
		// userMap.put("Mark", new Md5Hash("Mark","1234567", 1).toString());
		super.setName("cuseomRealm");
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 通过用户获取角色数据
		String userName = (String) principalCollection.getPrimaryPrincipal();
		// 从数据库或缓存中获取数据
		Set<String> roles = getRolesByUserName(userName);
		Set<String> permissions = getPermissionsByUserName(userName);

		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//		simpleAuthorizationInfo.setRoles(roles);
		simpleAuthorizationInfo.setStringPermissions(permissions);
		return simpleAuthorizationInfo;
	}

	private Set<String> getPermissionsByUserName(String userName) {
		Set<String> sets = new HashSet<>();
		List<String> permsList = permsservice.getPerms(userName);
		for (String perms : permsList) {
			if (StringUtils.isBlank(perms)) {
				continue;
			}
			sets.add(perms);
		}
		// sets.add("user:delete");
		// sets.add("user:add");
		return sets;
	}

	/**
	 * 模拟从数据库或缓存中获取数据
	 * 
	 * @param userName
	 * @return
	 */
	private Set<String> getRolesByUserName(String userName) {
		Set<String> sets = new HashSet<>();
		User u = userService.getUser(userName);
		Role r = roleservice.getRole(u.getRoleid());
		sets.add(r.getRole());
		// sets.add("admin");
		// sets.add("user");
		return sets;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 1. 从主题传过来的认证信息中，获取用户名
		String userName = (String) authenticationToken.getPrincipal();

		// 2. 用过用户名取数据中获取凭证
		// String password = getPasswordByUserName(userName);
		User u = userService.getUser(userName); // 不能只返回一个字符串password。 要返回一个实体类。
		if (u == null) {
			return null;
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(u.getUsername(), u.getPassword(),
				getName());
		authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(u.getUsername())); // 加盐
		return authenticationInfo;
	}

	/**
	 * 模拟数据库查询凭证
	 * 
	 * @param userName
	 * @return
	 */
	private String getPasswordByUserName(String userName) {
		return userMap.get(userName);
	}

}
