package com.lc.web.resource.dao;

import com.lc.web.resource.entity.Growingpotential;
import com.lc.web.resource.entity.GrowingpotentialExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GrowingpotentialMapper {
    long countByExample(GrowingpotentialExample example);

    int deleteByExample(GrowingpotentialExample example);

    int deleteByPrimaryKey(Integer gpid);

    int insert(Growingpotential record);

    int insertSelective(Growingpotential record);

    List<Growingpotential> selectByExample(GrowingpotentialExample example);

    Growingpotential selectByPrimaryKey(Integer gpid);

    int updateByExampleSelective(@Param("record") Growingpotential record, @Param("example") GrowingpotentialExample example);

    int updateByExample(@Param("record") Growingpotential record, @Param("example") GrowingpotentialExample example);

    int updateByPrimaryKeySelective(Growingpotential record);

    int updateByPrimaryKey(Growingpotential record);
}