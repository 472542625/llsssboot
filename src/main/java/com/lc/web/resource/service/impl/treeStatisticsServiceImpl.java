package com.lc.web.resource.service.impl;

import com.lc.web.resource.dao.treeStatisticsMapper;
import com.lc.web.resource.entity.treeStatistics_areaname;
import com.lc.web.resource.entity.treeStatistics_treeage;
import com.lc.web.resource.entity.treeStatistics_treespecies;
import com.lc.web.resource.service.treeStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class treeStatisticsServiceImpl implements treeStatisticsService {

	@Autowired
	treeStatisticsMapper dao;

	@Override
	public List<treeStatistics_treespecies> listTreeStatistics_treespecies() {
		return dao.listTreeStatistics_treespecies();
	}

	@Override
	public List<treeStatistics_treeage> listTreeStatistics_treeage() {
		// TODO Auto-generated method stub
		return dao.listTreeStatistics_treeage();
	}

	@Override
	public List<treeStatistics_areaname> listTreeStatistics_town() {
		return dao.listTreeStatistics_town();

	}

}
