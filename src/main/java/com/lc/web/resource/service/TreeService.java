package com.lc.web.resource.service;

import com.lc.web.resource.entity.Coordinate;
import com.lc.web.resource.entity.Tree;

import java.util.List;
import java.util.Map;

public interface TreeService {
	Tree listpointBygid(int gid);

	List<Tree> listFyPoint();

	void addpoint(Tree point);

	List<Tree> listPointTreespecies();

	List<Tree> listPointgrowingPotential();

	void updatepoint(Tree point);

	void deletePointBygid(int gid);

	List<Coordinate> listDaxingCoordinate();

	Coordinate listDaxingCoordinateByid(int coordinateid);

	// //根据树龄查询
	public List<Tree> listPointBytreeage(Map<String, Object> map);

	// //根据树高查询
	public List<Tree> listPointBytreeheight(Map<String, Object> map);

	// /承包人
	public List<Tree> listPointByContractor(String contractor);

	// /树名
	public List<Tree> listPointBytreespecies(String treespecies);

	// 得到所有树种名称
	public List<String> listtreespecies();

	public List<String> listVillage();
	//可视化通用查询
	List<Tree> listPointByArea(Tree tree);

	List<Tree> listPointById(String id);
    List<Tree> selectTreeByCondtion(Tree tree);
	 String  findTreespeciesByTreeid(Integer treeid);

}
