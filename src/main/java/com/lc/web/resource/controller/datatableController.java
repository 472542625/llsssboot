package com.lc.web.resource.controller;//package com.lc.web.resource.controller;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//import com.lc.web.resource.entity.Tree;
//import com.lc.web.resource.service.TreeService;
//
//@Controller
//public class datatableController {
//
//	@Autowired
//	TreeService pointservice;
//
//	// @RequestMapping(value = "/datatableindex")
//	// public String datatableindex() {
//	//
//	// return "/page/datatablepage/list.html";
//	//
//	// }
//
//	@RequestMapping(value = "/datatableMainFyJson")
//	public String datatableMainFyJson() {
//
//		return "/page/datatablepage/list.html";
//
//	}
//
//	// 得到所有数据构建分页
//	@RequestMapping(value = "/selectFyjsonPoint")
//	@ResponseBody
//	public HashMap<String, Object> listFyJsonPoint(
//			@RequestParam(value = "page", defaultValue = "1") Integer page,
//			@RequestParam(value = "limit") Integer limit) {
//		// 传入页码以及size
//		System.out.println("limit:" + limit);
//		System.out.println("page:" + page);
//		PageHelper.startPage(page, limit);
//		List<Tree> points = pointservice.listFyPoint();
//		// /使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
//		// 传入连续显示的页数
//		PageInfo pageinfo = new PageInfo(points, limit);
//
//		// model.addAttribute("pageinfo", page);
//		// return page;
//
//		HashMap<String, Object> map = new HashMap<String, Object>();
//
//		map.put("code", "0");
//		map.put("msg", " ");
//		map.put("count", points.size());
//		map.put("data", pageinfo.getList());
//		return map;
//
//	}
//
// }
