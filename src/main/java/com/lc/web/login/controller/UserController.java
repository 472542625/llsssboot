package com.lc.web.login.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.web.login.entity.user;
import com.lc.web.login.service.impl.UserServiceImpl;
import com.lc.web.util.JsonMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes("user")
public class UserController {
	@Autowired
    UserServiceImpl userService;

	@RequestMapping(value = "/login")
	public String login(user user, Model model, HttpServletRequest req) {
		// 1.获取subject对象
		Subject subject = SecurityUtils.getSubject();

		// 使用shiro对密码进行加密,user.getAccount()这个是加盐可以是任意字段，后面是迭代次数
		//Md5Hash hash = new Md5Hash(user.getPassword(), user.getAccount(), 2);

		// 2.封装用户对象
//		AuthenticationToken token = new UsernamePasswordToken(
//				user.getAccount(), hash.toString());// /这里使用加密后的密码
		AuthenticationToken token = new UsernamePasswordToken(
 				user.getAccount(), user.getPassword());// /这里使用加密后的密码
		// 3.执行认证
		try {
			subject.login(token);// 这个会跳转到realm类的认证方法

			user dbuser = (user) subject.getPrincipal();

			req.getSession().setAttribute("username", dbuser.getAccount());

			return "index/layui";
		} catch (UnknownAccountException e) {
			model.addAttribute("msg", "用户名不存在");
			return "login/login";
		} catch (IncorrectCredentialsException e) {
			model.addAttribute("msg", "密码错误");
			return "login/login";
		}

	}

	@RequestMapping(value = "/toLogin")
	public String toLogin() {

		return "login/login";

	}

	@RequestMapping(value = "/index")
	public String index() {

		return "index/layui";

	}

	@RequestMapping(value = "/llsss")
	public String llsss() {

		return "index/layui";

	}

	@RequestMapping(value = "/unAuth")
	public String unAuth() {

		return "/systemManager/auth.html";

	}

	@RequestMapping(value = "/signOut")
	// 返回实体的Map
	public String signOut(HttpServletRequest request, SessionStatus s) {
		// request.getSession().removeAttribute("user");
		// s.setComplete();
		Subject subjects = SecurityUtils.getSubject();
		subjects.logout();
		return "redirect:/toLogin";

	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	// 返回实体的Map
	@ResponseBody
	public user addUser(user user,int roleid) throws Exception {
		//Md5Hash hash = new Md5Hash(user.getPassword(), user.getAccount(), 2);
		//String md5password = hash.toString();
		//user.setPassword(md5password);
		userService.adduser(user);
		Integer uid = userService.findUser(user.getAccount()).getUid();

		HashMap<String,Integer> map = new HashMap<String,Integer>();
		map.put("userid",uid);
		map.put("roleid",roleid);

		userService.addUserWithRole(map);

		return user;

	}

	// 得到所有数据构建分页
	@RequestMapping(value = "/listFyUser")
	@ResponseBody
	public JsonMsg listFyUser(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 传入页码以及size
		PageHelper.startPage(pn, 5);
		List<user> points = userService.listFyUser();
		// /使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
		// 传入连续显示的页数
		PageInfo page = new PageInfo(points, 5);

		return JsonMsg.success().add("pageInfo", page);

	}


	@RequestMapping(value = "/findUserByUid/{uid}", method = RequestMethod.GET)
	public @ResponseBody
	user findUserByUid(@PathVariable("uid") Integer uid) {
		user user =  userService.findUserByUid(uid);

		return user;

	}
	@RequestMapping(value = "/findRoleByUid/{uid}", method = RequestMethod.GET)
	public @ResponseBody
	Integer findRoleByUid(@PathVariable("uid") Integer uid) {
		Integer roleid =  userService.findRoleByUid(uid);

		return roleid;

	}



	@RequestMapping(value = "/updateUser/{uid}", method = RequestMethod.PUT)
	// 返回实体的Map
	@ResponseBody
	public void updateUser(user user,@PathVariable("uid") Integer uid,Integer userid) {

		System.out.println(userid);
		userService.updateUser(user);
		userService.updateUserWithRole(uid,userid);

	}

	@RequestMapping(value = "/deleteuser/{uid}", method = RequestMethod.DELETE)

	@ResponseBody
	public void deleteuser(@PathVariable("uid") Integer uid) {
		userService.deleteuserFromRoleAndUser(uid);
		userService.deleteuser(uid);

	}



	@RequestMapping(value = "/datatablepageList")
	public String datatablepageList() {

		return "datatablepage/list";

	}

	@RequestMapping(value = "/userManagerList")
	public String userManagerList() {

		return "systemManager/userManager/list";

	}








}
