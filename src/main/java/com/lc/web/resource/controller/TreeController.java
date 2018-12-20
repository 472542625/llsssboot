package com.lc.web.resource.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lc.web.resource.entity.Coordinate;
import com.lc.web.resource.entity.Tree;
import com.lc.web.resource.service.impl.TreeServiceImpl;
import com.lc.web.util.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//使用@Controller 标示控制器 就可以不实现 Controller接口或HttpRequestHandler接口了
public class TreeController {

	@Autowired
    TreeServiceImpl pointService;

	// 得到树种List列表
	@RequestMapping(value = "/listPointTreespecies")
	public @ResponseBody
	List<Tree> listPointTreespecies() {
		return pointService.listPointTreespecies();
	}
	// 得到生长势List列表
	@RequestMapping(value = "/listPointgrowingPotential")
	public @ResponseBody
	List<Tree> listPointgrowingPotential() {

		return pointService.listPointgrowingPotential();

	}
	// 得到大兴村镇坐标
	@RequestMapping(value = "/listDaxingCoordinate", method = RequestMethod.GET)
	public @ResponseBody
	List<Coordinate> listDaxingCoordinate() {

		return pointService.listDaxingCoordinate();

	}
	// 根据coordinateid得到大兴村镇坐标
	@RequestMapping(value = "/listDaxingCoordinateByid/{coordinateid}", method = RequestMethod.GET)
	public @ResponseBody
	Coordinate listDaxingCoordinateByid(
			@PathVariable("coordinateid") Integer coordinateid) {

		return pointService.listDaxingCoordinateByid(coordinateid);
	}
	// 得到所有数据构建分页
	@RequestMapping(value = "/listFyjsonPoint")
	@ResponseBody
	public JsonMsg listFyJsonPoint(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		// 传入页码以及size
		System.out.println(pn);
		PageHelper.startPage(pn, 5);
		List<Tree> points = pointService.listFyPoint();
		System.out.println("size:"+points.size());
		// /使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
		// 传入连续显示的页数
		PageInfo page = new PageInfo(points, 5);

		System.out.println("page.getList().size():"+page.getList().size());
		return JsonMsg.success().add("pageInfo", page);
	}
	// 根据gid得到点信息
	@RequestMapping(value = "/listPointBygid/{gid}", method = RequestMethod.GET)
	public @ResponseBody
    Tree listPointBygid(@PathVariable("gid") Integer gid) {
		Tree point = pointService.listpointBygid(gid);
		return point;
	}
	// @RequestMapping(value = "/listPointallMap")
	// // 返回实体的Map
	// public @ResponseBody
	// Map<String, Object> listPointallMap(Tree point) {
	//
	// List<Tree> listpoint = pointService.listPointByContractor(point);
	// Map<String, Object> map = new LinkedHashMap<String, Object>();
	//
	// map.put("total", listpoint.size());
	// map.put("rows", listpoint);
	// System.out.println("size:" + listpoint.size());
	// return map;
	//
	// }
	// 更新点要素
	@RequestMapping(value = "/updatePoint/{gid}", method = RequestMethod.PUT)
	@ResponseBody
	public Tree updatePoint(Tree point) {
		// System.out.println("gids:" + );
		System.out.println("getGid()" + point.getGid());
		pointService.updatepoint(point);
		return point;
	}
	// 批量更新点要素
	@RequestMapping(value = "/BatchupdatePoint/{gids}", method = RequestMethod.PUT)
	@ResponseBody
	public String BatchupdatePoint(Tree point, @PathVariable("gids") String gids) {
		// pointService.updatepoint(point);
		if (gids.contains("-")) {
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_gids = gids.split("-");
			for (String string : str_gids) {
				System.out.println(string);
				del_ids.add(Integer.parseInt(string));
				pointService.deletePointBygid(Integer.parseInt(string));
				point.setGid(Integer.parseInt(string));
				pointService.addpoint(point);
			}
		} else {
			Integer gid = Integer.parseInt(gids);
			System.out.println(gid);
			pointService.deletePointBygid(gid);
		}
		return "success";
	}
	// 增加点要素
	@RequestMapping(value = "/addPoint", method = RequestMethod.POST)
	@ResponseBody
	public Tree addPoint(Tree point) {

		System.out.println(point.getTown());
		System.out.println(point.getVillage());
		System.out.println(point.getUrban());
		// System.out.println(point.getVisitage());
		pointService.addpoint(point);
		return point;
	}
	// 删除点要素
	@RequestMapping(value = "/deletePoint/{gids}", method = RequestMethod.DELETE)
	@ResponseBody
	public String deletePointBygid(@PathVariable("gids") String gids) {
		System.out.println(gids);
		if (gids.contains("-")) {
			List<Integer> del_ids = new ArrayList<Integer>();
			String[] str_gids = gids.split("-");

			for (String string : str_gids) {
				System.out.println(string);
				del_ids.add(Integer.parseInt(string));
			}
			pointService.deleteBatch(del_ids);
			return "success";

		} else {
			Integer gid = Integer.parseInt(gids);
			System.out.println(gid);
			pointService.deletePointBygid(gid);
			return "success";
		}

	}
	//根据树龄查询
	@RequestMapping(value = "/listPointBytreeage", method = RequestMethod.GET)
	public @ResponseBody
	List<Tree> listPointBytreeage(double orgintreeage, double destreeage) {

		Map<String, Object> map = new HashMap<String, Object>();
		// System.out.println("orgintreeage:" + orgintreeage);
		// System.out.println("destreeage:" + destreeage);
		map.put("orgintreeage", orgintreeage);
		map.put("destreeage", destreeage);
		List<Tree> listpoint = pointService.listPointBytreeage(map);

		return listpoint;

	}
	//根据树高查询
	@RequestMapping(value = "/listPointBytreeheight", method = RequestMethod.GET)
	public @ResponseBody
	List<Tree> listPointBytreeheight(double orgintreeheight,
                                     double destreeheight) {

		Map<String, Object> map = new HashMap<String, Object>();
		// System.out.println("orgintreeage:" + orgintreeage);
		// System.out.println("destreeage:" + destreeage);
		map.put("orgintreeheight", orgintreeheight);
		map.put("destreeheight", destreeheight);
		List<Tree> listpoint = pointService.listPointBytreeheight(map);

		return listpoint;

	}

	// 根据承包人
	@RequestMapping(value = "/listPointBycontractor/{contractor}", method = RequestMethod.GET)
	public @ResponseBody
	List<Tree> listPointBycontractor(
			@PathVariable("contractor") String contractor) {

		List<Tree> listpoint = pointService.listPointByContractor(contractor);
		return listpoint;
	}

	// 根据承包人
	@RequestMapping(value = "/listPointBytreespecies/{treespecies}", method = RequestMethod.GET)
	public @ResponseBody
	List<Tree> listPointBytreespecies(
			@PathVariable("treespecies") String treespecies) {

		List<Tree> listpoint = pointService.listPointBytreespecies(treespecies);
		return listpoint;
	}

	//列出所有树种
	@RequestMapping(value = "/listtreespecies", method = RequestMethod.GET)
	public @ResponseBody
	List<String> listtreespecies() {

		List<String> listpoint = pointService.listtreespecies();
		return listpoint;
	}
	@RequestMapping(value = "/listVillage", method = RequestMethod.GET)
	public @ResponseBody
	List<String> listVillage() {

		List<String> listpoint = pointService.listVillage();
		return listpoint;
	}




	//数据列表查询
	@RequestMapping(value = "/listPointById", method = RequestMethod.GET)
	public @ResponseBody
	List<Tree> listPointById(String id) {

		List<Tree> list = pointService.listPointById(id);
		//使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
		//传入连续显示的页数
	return list;
	}
	//可视化通用查询
	@RequestMapping(value = "/listPointByArea", method = RequestMethod.GET)
	public @ResponseBody
	List<Tree> listPointByArea(Tree tree) {

		List<Tree> list = pointService.listPointByArea(tree);
		//使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
		//传入连续显示的页数
		return list;
	}

    //数据列表查询
	@RequestMapping(value = "/selectTreeByCondtion", method = RequestMethod.GET)
	public @ResponseBody
    JsonMsg selectTreeByCondtion(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Tree tree) {



		PageHelper.startPage(pn, 5);
		List<Tree> points =pointService.selectTreeByCondtion(tree);

		// /使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
		// 传入连续显示的页数
		PageInfo page = new PageInfo(points, 5);
		return JsonMsg.success().add("pageInfo", page);



	}




	@RequestMapping(value = "/findTreespeciesByTreeid", method = RequestMethod.GET)
	public @ResponseBody
	String findTreespeciesByTreeid(Integer treeid) {

		String treespecies = pointService.findTreespeciesByTreeid(treeid);
		//使用PageInfo包装查询后的结果，只需要将PageInfo交给页面就行了，封装了详细的分页信息
		//传入连续显示的页数
		return treespecies;
	}


}
