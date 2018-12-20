package com.lc.web.resource.dao;

import com.lc.web.resource.entity.Treespecies;
import com.lc.web.resource.entity.TreespeciesExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreespeciesMapper {
    long countByExample(TreespeciesExample example);

    int deleteByExample(TreespeciesExample example);

    int deleteByPrimaryKey(Integer treespeciesid);

    int insert(Treespecies record);

    int insertSelective(Treespecies record);

    List<Treespecies> selectByExample(TreespeciesExample example);

    Treespecies selectByPrimaryKey(Integer treespeciesid);

    int updateByExampleSelective(@Param("record") Treespecies record, @Param("example") TreespeciesExample example);

    int updateByExample(@Param("record") Treespecies record, @Param("example") TreespeciesExample example);

    int updateByPrimaryKeySelective(Treespecies record);

    int updateByPrimaryKey(Treespecies record);
}