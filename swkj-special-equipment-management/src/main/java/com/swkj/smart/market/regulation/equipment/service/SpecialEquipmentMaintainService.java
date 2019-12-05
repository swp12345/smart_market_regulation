package com.swkj.smart.market.regulation.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.model.SpecialEquipmentMaintain;

import java.util.List;
import java.util.Map;

/**
 * @author 宋伟朋
 * @date 2019/11/13
 */
public interface SpecialEquipmentMaintainService extends IService<SpecialEquipmentMaintain> {

    // 查询所有维保信息
    IPage<List<Map>> findAllInfo(int currentPage);
    // 新增维保信息
    Integer insertEquipmentMaintain(SpecialEquipmentMaintain specialEquipmentMaintain);
    // 维保信息查询
    List<Map<String,Object>> selectByIdEquipmentMaintain(String id);
    // 维保信息预警
    IPage<List<Map>> selectWaringInfo(DateDTO dateDTO, int currentPage);
}
