package com.lc.web.resource.dao;

import com.lc.web.resource.entity.Tree;
import com.lc.web.resource.entity.TreeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TreeMapper {
	long countByExample(TreeExample example);

	int deleteByExample(TreeExample example);

	int deleteByPrimaryKey(Integer gid);

	int insert(Tree record);

	int insertSelective(Tree record);

	List<Tree> selectByExample(TreeExample example);

	List<Tree> selectByExampleWithTreeInfo(TreeExample example);

	Tree selectByPrimaryKeyWithTreeInfo(Integer gid);

	Tree selectByPrimaryKey(Integer gid);

	int updateByExampleSelective(@Param("record") Tree record,
                                 @Param("example") TreeExample example);

	int updateByExample(@Param("record") Tree record,
                        @Param("example") TreeExample example);

	int updateByPrimaryKeySelective(Tree record);

	int updateByPrimaryKey(Tree record);

	// 自己写的
	public Tree listpointBygid(int gid);

	public List<Tree> listFyPoint();

	public void addpoint(Tree point);

	public List<Tree> listPointTreespecies();

	public List<Tree> listPointgrowingPotential();

	public void updatepoint(Tree point);

	public void deletePointBygid(int gid);



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



}