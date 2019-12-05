package com.swkj.smart.market.regulation.equipment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.SpecialEquipmentMaintain;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 宋伟朋
 * @date 2019/11/13
 */
public interface SpecialEquipmentMaintainMapper extends BaseMapper<SpecialEquipmentMaintain> {
    // 查询所有维保信息
    IPage<List<Map>> findAllInfo(Page page);
    // 维保信息查询
    List<Map<String,Object>> findByIdEquipmentMaintain(@Param("id") String id);

    // 维保信息预警
    IPage<List<Map>> findWaringInfo(Page page,@Param("startDate")Date startDate,@Param("endDate") Date endDate);
}
