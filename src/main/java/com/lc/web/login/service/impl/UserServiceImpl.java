package com.lc.web.login.service.impl;

import com.lc.web.login.dao.UserMapper;
import com.lc.web.login.entity.user;
import com.lc.web.login.service.UserService;
import com.lc.web.util.ThisPassWordSHA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    UserMapper usermapper;

	@Override
	public void adduser(user user) {
		// TODO Auto-generated method stub
		usermapper.adduser(user);
	}

	@Override
	public void addUserWithRole(HashMap<String, Integer> map) {
		usermapper.addUserWithRole(map);

	}

	@Override
	public user findUser(user users) throws Exception {

		// 断言user中的账号是否为空
		// isNotNull("该用户账号为空", users.getAccount());
		// user中的密码加密
		String formatSHA = ThisPassWordSHA.getFormatSHA(users.getPassword());
		System.out.println("密码加密前：" + users.getPassword());
		System.out.println("密码加密后并且格式化后的：" + formatSHA);

		// 使用账号对数据库的user表查询
		user findUser = usermapper.findUser(users.getAccount());
		// System.out.println(findUser.getUid());
		// System.out.println(findUser.getAccount());
		// System.out.println(findUser.getPassword());
		// 断言对象不为空
		// isObjectNotNull("当前账号未注册，联系管理员", findUser);
		// 返回的对象中的密码与加密的对比
		// isEques("账号与密码不匹配", findUser.getPassword(), formatSHA);

		findUser.setPassword(null);
		return findUser;
	}

	@Override
	public user findUserByUid(int uid) {
		return usermapper.findUserByUid(uid);
	}
	@Override
	public Integer findRoleByUid(Integer uid) {
		return usermapper.findRoleByUid(uid);
	}

	@Override
	public void updateUserWithRole(Integer userid, Integer roleid) {

		HashMap<String,Integer> map = new HashMap<>();
		map.put("userid",userid);
		map.put("roleid",roleid);
		usermapper.updateUserWithRole(map);
	}

	@Override
	public user findUser(String username) throws Exception {

		return usermapper.findUser(username);

	}

	@Override
	public List<String> findPermissionByUserId(int userid) throws Exception {

		return usermapper.findPermissionByUserId(userid);
	}

	@Override
	public void updateUser(user user) {
		usermapper.updateUser(user);
	}

	@Override
	public void deleteuserFromRoleAndUser(Integer uid) {
		usermapper.deleteuserFromRoleAndUser(uid);
	}

	@Override
	public void deleteuser(Integer uid) {
		usermapper.deleteuser(uid);

	}

	@Override
	public List<user> listFyUser() {
		return usermapper.listFyUser();
	}


}
