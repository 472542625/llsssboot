package com.lc.web.login.service;

import com.lc.web.login.entity.user;

import java.util.HashMap;
import java.util.List;

public interface UserService {
	public void adduser(user user);
	public void addUserWithRole(HashMap<String, Integer> map);
	public user findUser(user user) throws Exception;
	public user findUserByUid(int uid);
	public user findUser(String username) throws Exception;

	public List<String> findPermissionByUserId(int userid) throws Exception;
	public void updateUser(user user);
	//	删除user之前需要先删除和role表的关联
	public void deleteuserFromRoleAndUser(Integer uid);
	public void deleteuser(Integer uid);

	public List<user>listFyUser();

	public Integer findRoleByUid(Integer uid);

	void updateUserWithRole(Integer userid, Integer roleid);
}
