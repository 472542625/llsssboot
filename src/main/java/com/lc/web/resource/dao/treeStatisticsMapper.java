package com.lc.web.resource.dao;

import com.lc.web.resource.entity.treeStatistics_areaname;
import com.lc.web.resource.entity.treeStatistics_treeage;
import com.lc.web.resource.entity.treeStatistics_treespecies;

import java.util.List;

public interface treeStatisticsMapper {

	/* 树种统计 */
	public List<treeStatistics_treespecies> listTreeStatistics_treespecies();

	/* 树龄统计 */
	public List<treeStatistics_treeage> listTreeStatistics_treeage();

	/* 地名统计 */
	public List<treeStatistics_areaname> listTreeStatistics_town();
}
