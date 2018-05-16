package com.kay.dao;

import com.kay.entity.TbArea;

import java.util.List;

public interface TbAreaMapper {
    int deleteByPrimaryKey(Integer areaId);

    int insert(TbArea record);

    int insertSelective(TbArea record);

    TbArea selectByPrimaryKey(Integer areaId);

    int updateByPrimaryKeySelective(TbArea record);

    int updateByPrimaryKey(TbArea record);

    List<TbArea> queryArea();
}