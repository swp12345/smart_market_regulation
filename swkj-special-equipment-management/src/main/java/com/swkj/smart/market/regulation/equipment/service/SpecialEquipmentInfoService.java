package com.swkj.smart.market.regulation.equipment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.SpecialEquipmentInfo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *     特种设备基础信息 业务接口
 * </p>
 * @author 宋伟朋
 * @date 2019/11/11
 */
public interface SpecialEquipmentInfoService extends IService<SpecialEquipmentInfo> {

    // 特种设备分布地图
    List<Map> getAllEquipmentInfo();

    // 特种设备所有备案信息查询
    IPage<SpecialEquipmentInfo> selectAllEquipmentInfo(int currentPage);

    // 特种设备详情
    Map<String,Object>  selectByIdInfo(String id);

    // 根据设备编号查询设备信息
    SpecialEquipmentInfo selectByEidInfo(String eId);

    // 新增业主信息备案
    Integer insertEquipmentInfo(SpecialEquipmentInfo specialEquipmentInfo);

    IPage<Map<String,Object>> selectByEidEquipmentInfo(int currentPage, String eId);
}
