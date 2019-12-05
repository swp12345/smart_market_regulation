package com.swkj.smart.market.regulation.equipment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.SpecialEquipmentInfo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *     特种设备信息 mapper 接口
 * </p>
 * @author 宋伟朋
 * @date 2019/11/11
 */
@Component
public interface SpecialEquipmentInfoMapper extends BaseMapper<SpecialEquipmentInfo> {

    //  特种设备地图分布
    List<Map> findByAddressInfo();
    // 特种设备所有备案信息查询
    IPage<SpecialEquipmentInfo> selectAllEquipmentInfo(Page page);
    // 特种设备详情
    Map<String,Object> selectByIdInfo(String id);
    // 根据设备编号查询设备信息
    SpecialEquipmentInfo selectByEidInfo(String eId);

    IPage<Map<String,Object>> selectByEidEquipmentInfo(Page page,String eId);
}
