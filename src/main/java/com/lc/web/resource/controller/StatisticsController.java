package com.lc.web.resource.controller;

import com.lc.web.resource.entity.treeStatistics_areaname;
import com.lc.web.resource.entity.treeStatistics_treeage;
import com.lc.web.resource.entity.treeStatistics_treespecies;
import com.lc.web.resource.service.treeStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StatisticsController {
	@Autowired
	treeStatisticsService service;


	@RequestMapping(value = "/ToStatistics_treespecies")

	public String ToStatistics_treespecies() {

		return "statistics_analysis/listTreeStatistics_treesepcies";

	}

	@RequestMapping(value = "/ToTreeStatistics_treeage")

	public String ToTreeStatistics_treeage() {

		return "statistics_analysis/listTreeStatistics_treeage";

	}

	@RequestMapping(value = "/ToTreeStatistics_town")

	public String ToTreeStatistics_town() {

		return "statistics_analysis/listTreeStatistics_areaname";

	}



	@RequestMapping(value = "/listTreeStatistics_treespecies")
	@ResponseBody
	public List<treeStatistics_treespecies> listTreeStatistics_treespecies() {

		return service.listTreeStatistics_treespecies();

	}

	@RequestMapping(value = "/listTreeStatistics_treeage")
	@ResponseBody
	public List<treeStatistics_treeage> listTreeStatistics_treeage() {

		return service.listTreeStatistics_treeage();

	}

	@RequestMapping(value = "/listTreeStatistics_town")
	@ResponseBody
	public List<treeStatistics_areaname> listTreeStatistics_town() {

		return service.listTreeStatistics_town();

	}

}
