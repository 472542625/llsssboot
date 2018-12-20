package com.lc.web.login.dao;

import com.lc.web.login.entity.user;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

	public void adduser(user user);
	public void addUserWithRole(HashMap<String, Integer> map);

	public user findUser(String account);
	public user findUserByUid(int uid);
	public void updateUserWithRole(HashMap<String,Integer> map);
	public List<String> findPermissionByUserId(int userId);

	public void updatePassword(user user);
	public void updateUser(user user);

//	删除user之前需要先删除和role表的关联
	public void deleteuserFromRoleAndUser(Integer uid);
	public void deleteuser(Integer uid);
	public List<user>listFyUser();

	Integer findRoleByUid(Integer uid);


}
