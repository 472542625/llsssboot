package com.lc.web.login.realm;

import com.lc.web.login.entity.user;
import com.lc.web.login.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

	@Autowired
	public UserService userservice;

	@Override
	public String getName() {
		return "";

	}

	// 授权操作
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		System.out.println("执行了授权方法");

		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


		// 给当前用户进行动态授权
		// 1.获取当前用户的pricipal
		Subject subject = SecurityUtils.getSubject();
		user user = (user) subject.getPrincipal();

		// 2.查询当前用户拥有的资源授权码
		List<String> perms = null;
		try {
			perms = userservice.findPermissionByUserId(user.getUid());
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (perms != null) {
			for (String perm : perms) {
				if (!org.springframework.util.StringUtils.isEmpty(perm)) {
					info.addStringPermission(perm);
					System.out.println(perm);
					// info.addStringPermission("spdata:list");// 进行 资源权限赋予"spdata:list"
					// info.addRole("admin");// 进行角色权限赋予"admin"
				}

			}
		}
		return info;
	}

	// 认证操作
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		System.out.println("执行了认证方法");
		// 1.获取用户输入的账户信息
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

		user user = null;
		try {
			user = userservice.findUser(token.getUsername());
			System.out.print(user.getAccount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (user == null) {
			return null;
		}

		// 返回密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}
}
