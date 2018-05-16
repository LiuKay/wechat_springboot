package com.kay.service.impl;

import com.kay.dao.TbAreaMapper;
import com.kay.entity.TbArea;
import com.kay.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by kay on 2018/3/16.
 */
@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private TbAreaMapper areaMapper;

    @Override
    public boolean deleteByPrimaryKey(Integer areaId) {
        int deleteCount = areaMapper.deleteByPrimaryKey(areaId);
        if(deleteCount>0){
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    @Override
    public boolean insert(TbArea area) {
        if (area.getAreaName()!=null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setUpdateTime(new Date());
            try {
                int insertCount = areaMapper.insert(area);
                if (insertCount > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public int insertSelective(TbArea record) {
        return areaMapper.insertSelective(record);
    }

    @Override
    public TbArea selectByPrimaryKey(Integer areaId) {
        return areaMapper.selectByPrimaryKey(areaId);
    }

    @Override
    public boolean updateByPrimaryKeySelective(TbArea record) {
        if (record.getAreaName()!=null && !"".equals(record.getAreaName())) {
            record.setUpdateTime(new Date());
            try {
                int updateCount = areaMapper.updateByPrimaryKeySelective(record);
                if (updateCount > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新失败"+ e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public int updateByPrimaryKey(TbArea record) {
        return areaMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TbArea> queryArea() {
        return areaMapper.queryArea();
    }
}
