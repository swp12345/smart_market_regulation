package com.swkj.smart.market.regulation.equipment.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.equipment.service.SpecialEquipmentInfoService;
import com.swkj.smart.market.regulation.equipment.service.SpecialEquipmentMaintainService;
import com.swkj.smart.market.regulation.model.SpecialEquipmentInfo;
import com.swkj.smart.market.regulation.model.SpecialEquipmentMaintain;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SpecialEquipmentMaintainController{

    @Autowired
    private SpecialEquipmentMaintainService specialEquipmentMaintainService;
    @Autowired
    private SpecialEquipmentInfoService specialEquipmentInfoService;

    @GetMapping("/selectGetAllInfo")
    @ApiOperation(value = "查询所有维保备案信息")
    public HttpResult selectAllEquipmentInfo(int currentPage){
        IPage<List<Map>> specialEquipmentMaintainIPage = specialEquipmentMaintainService.findAllInfo(currentPage);
        return HttpResult.ok(specialEquipmentMaintainIPage);
    }

    @PostMapping("/addEquipmentMaintain")
    @ApiOperation(value = "新增维保备案信息")
    public HttpResult addEquipmentMaintain(SpecialEquipmentMaintain specialEquipmentMaintain){
        SpecialEquipmentInfo specialEquipmentInfo = specialEquipmentInfoService.selectByEidInfo(specialEquipmentMaintain.getEId());
        if (specialEquipmentInfo != null){
            specialEquipmentMaintain.setEId(specialEquipmentInfo.getEId());
            Integer index =specialEquipmentMaintainService.insertEquipmentMaintain(specialEquipmentMaintain);
            if (index > 0){
                return HttpResult.ok("新增成功");
            }
            return HttpResult.error("新增失败");
        }
        return HttpResult.error("该条信息不存在!!!!!");
    }

    @GetMapping("/selectGetEquipmentMaintain")
    @ApiOperation(value = "维保备案信息详情查询")
    public HttpResult selectGetEquipmentMaintain(String id){
        List<Map<String,Object>> specialEquipmentMaintainIPage = specialEquipmentMaintainService.selectByIdEquipmentMaintain(id);
        return HttpResult.ok(specialEquipmentMaintainIPage);
    }

    @GetMapping("/selectWarningEquipmentInfo")
    @ApiOperation(value = "设备维保预警信息")
    public HttpResult selectWarningEquipmentInfo(DateDTO dateDTO,Integer currentPage){
        IPage<List<Map>> specialEquipmentMaintainIPage = specialEquipmentMaintainService.selectWaringInfo(dateDTO,currentPage);
        return HttpResult.ok(specialEquipmentMaintainIPage);
    }
}