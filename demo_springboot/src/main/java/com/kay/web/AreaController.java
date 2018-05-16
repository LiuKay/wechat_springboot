package com.kay.web;

import com.kay.entity.TbArea;
import com.kay.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kay on 2018/3/16.
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaService areaService;

    /**
     * 列表查询
     * @return
     */
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<TbArea> areas = areaService.queryArea();
        modelMap.put("areaList", areas);
        return modelMap;
    }

    /**
     * areaid 查询
     * @param areaId
     * @return
     */
    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        TbArea area = areaService.selectByPrimaryKey(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    /**
     * 添加area
     * @param area
     * @return
     */
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody TbArea area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isSuccess = areaService.insert(area);
        modelMap.put("success", isSuccess);
        return modelMap;
    }

    /**
     * 修改
     * @param area
     * @return
     */
    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody TbArea area) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean b = areaService.updateByPrimaryKeySelective(area);
        modelMap.put("success", b);
        return modelMap;
    }

    /**
     * 删除area
     * @param areaId
     * @return
     */
    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        boolean isSuccess = areaService.deleteByPrimaryKey(areaId);
        modelMap.put("success", isSuccess);
        return modelMap;
    }
}
