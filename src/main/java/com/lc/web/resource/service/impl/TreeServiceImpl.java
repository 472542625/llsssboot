package com.lc.web.resource.service.impl;

import com.lc.web.resource.dao.CoordinateMapper;
import com.lc.web.resource.dao.TreeMapper;
import com.lc.web.resource.dao.TreespeciesMapper;
import com.lc.web.resource.entity.Coordinate;
import com.lc.web.resource.entity.Tree;
import com.lc.web.resource.entity.TreeExample;
import com.lc.web.resource.entity.TreeExample.Criteria;
import com.lc.web.resource.entity.TreespeciesExample;
import com.lc.web.resource.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TreeServiceImpl implements TreeService {
    // CategoryServiceImpl被注解@Service标示为一个Service
    // 并且装配了categoryMapper
    @Autowired
    TreeMapper pointmapper;
    @Autowired
    CoordinateMapper coordinatemapper;
    @Autowired
    TreespeciesMapper treespeciesMapper;
    @Override
    public Tree listpointBygid(int gid) {
        return pointmapper.selectByPrimaryKeyWithTreeInfo(gid);
    }

    @Override
    public List<Tree> listFyPoint() {
        // TODO Auto-generated method stub
        return pointmapper.listFyPoint();
    }

    @Override
    public void addpoint(Tree point) {
        // TODO Auto-generated method stub



        TreespeciesExample example = new TreespeciesExample();
        TreespeciesExample.Criteria criteria = example.createCriteria();
        criteria.andTreespeciesidEqualTo(point.getTreespeciesId());
        String Treespecies = treespeciesMapper.selectByExample(example).get(0).getTreespeciesname();
        point.setTreespecies(Treespecies);


        pointmapper.insertSelective(point);


    }

    @Override
    public List<Tree> listPointTreespecies() {

        return pointmapper.listPointTreespecies();

    }

    @Override
    public List<Tree> listPointgrowingPotential() {
        // TODO Auto-generated method stub
        return pointmapper.listPointgrowingPotential();
    }

    @Override
    public void updatepoint(Tree point) {

        TreespeciesExample example = new TreespeciesExample();
        TreespeciesExample.Criteria criteria = example.createCriteria();
        criteria.andTreespeciesidEqualTo(point.getTreespeciesId());
        String Treespecies = treespeciesMapper.selectByExample(example).get(0).getTreespeciesname();
        point.setTreespecies(Treespecies);
        pointmapper.updateByPrimaryKeySelective(point);

    }

    @Override
    public void deletePointBygid(int gid) {

        pointmapper.deleteByPrimaryKey(gid);
    }

    public void deleteBatch(List<Integer> gids) {

        TreeExample example = new TreeExample();
        Criteria criteria = example.createCriteria();
        criteria.andGidIn(gids);
        pointmapper.deleteByExample(example);

    }

    @Override
    public List<Coordinate> listDaxingCoordinate() {
        // TODO Auto-generated method stub
        return coordinatemapper.listCoordinate();
    }

    @Override
    public Coordinate listDaxingCoordinateByid(int coordinateid) {
        // TODO Auto-generated method stub
        return coordinatemapper.listCoordinateById(coordinateid);
    }

    @Override
    public List<Tree> listPointBytreeage(Map<String, Object> map) {
        // TODO Auto-generated method stub
        System.out.println(map.get("orgintreeage"));
        System.out.println(map.get("destreeage"));
        return pointmapper.listPointBytreeage(map);
    }

    @Override
    public List<Tree> listPointBytreeheight(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return pointmapper.listPointBytreeheight(map);
    }

    @Override
    public List<Tree> listPointByContractor(String contractor) {
        // TODO Auto-generated method stub
        return pointmapper.listPointByContractor(contractor);
    }

    @Override
    public List<Tree> listPointBytreespecies(String treespecies) {
        // TODO Auto-generated method stub
        return pointmapper.listPointBytreespecies(treespecies);
    }

    @Override
    public List<String> listtreespecies() {
        // TODO Auto-generated method stub
        return pointmapper.listtreespecies();
    }

    @Override
    public List<String> listVillage() {
        return pointmapper.listVillage();
    }

    @Override
    public List<Tree> listPointById(String id) {
        TreeExample example = new TreeExample();
        TreeExample.Criteria criteria = example.createCriteria();

        if(id!=""){

            criteria.andIdEqualTo(id);
        }
        return pointmapper.selectByExampleWithTreeInfo(example);
    }

    @Override
    public List<Tree> listPointByArea(Tree tree) {
        TreeExample example = new TreeExample();
        TreeExample.Criteria criteria = example.createCriteria();

        if(tree.getArea()!=""){
            criteria.andAreaEqualTo(tree.getArea());
        }


        return pointmapper.selectByExampleWithTreeInfo(example);
    }

    @Override
    public List<Tree> selectTreeByCondtion(Tree tree) {


        TreeExample treeexample = new TreeExample();
        TreeExample.Criteria criteria =  treeexample.createCriteria();
        if (tree.getContractor() != "") {

            System.out.println(tree.getContractor());
            criteria.andContractorEqualTo(tree.getContractor());
        }

        if (tree.getTreespeciesId() != 0) {
            criteria.andTreespeciesIdEqualTo(tree.getTreespeciesId());
            System.out.println(tree.getTreespeciesId());
        }
//
        if (tree.getArea() != "") {
            System.out.println(tree.getArea());

            criteria.andAreaEqualTo(tree.getArea());
        }
//
        if (tree.getGpId() != 9) {

            System.out.println(tree.getGpId());
            criteria.andGpIdEqualTo(tree.getGpId());
        }
//
//
//
//
        if(tree.getId()!=""){
            System.out.println(tree.getId());
            criteria.andIdEqualTo(tree.getId());
        }

        if(!tree.getTown().equals("请选择")){
            System.out.println(tree.getTown());
            criteria.andTownEqualTo(tree.getTown());
        }
        if(!tree.getVillage().equals("请选择")){
            System.out.println(tree.getVillage());
            criteria.andVillageEqualTo(tree.getVillage());
        }






        return pointmapper.selectByExampleWithTreeInfo(treeexample);
    }

    @Override
    public String findTreespeciesByTreeid(Integer treeid) {

        TreespeciesExample example = new TreespeciesExample();
        TreespeciesExample.Criteria criteria = example.createCriteria();
        criteria.andTreespeciesidEqualTo(treeid);
        return  treespeciesMapper.selectByExample(example).get(0).getTreespeciesname();
    }
}
