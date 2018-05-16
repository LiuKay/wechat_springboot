package com.kay.service;

import com.kay.entity.TbArea;

import java.util.List;

/**
 * Created by kay on 2018/3/16.
 */
public interface AreaService {

    boolean deleteByPrimaryKey(Integer areaId);

    boolean insert(TbArea record);

    int insertSelective(TbArea record);

    TbArea selectByPrimaryKey(Integer areaId);

    boolean updateByPrimaryKeySelective(TbArea record);

    int updateByPrimaryKey(TbArea record);

    List<TbArea> queryArea();
}
