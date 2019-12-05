package com.swkj.smart.market.regulation.equipment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.equipment.mapper.SpecialEquipmentMaintainMapper;
import com.swkj.smart.market.regulation.equipment.service.SpecialEquipmentMaintainService;
import com.swkj.smart.market.regulation.model.SpecialEquipmentMaintain;
import com.swkj.smart.market.regulation.util.Customize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 第三方检测机构备案信息表 服务实现类
 * </p>
 *
 * @author 宋伟朋
 * @since 2019-10-12
 */
@Service
public class SpecialEquipmentMaintainServiceImpl extends ServiceImpl<SpecialEquipmentMaintainMapper, SpecialEquipmentMaintain> implements SpecialEquipmentMaintainService {

    @Autowired
    private SpecialEquipmentMaintainMapper specialEquipmentMaintainMapper;

    /**
     * 维保备案信息查询
     * @param currentPage
     * @return
     */
    @Override
    public IPage<List<Map>> findAllInfo(int currentPage) {
        Page page = new Page(currentPage, Customize.PAGES_SIZE);
        IPage<List<Map>> specialEquipmentMaintain = specialEquipmentMaintainMapper.findAllInfo(page);
        return specialEquipmentMaintain;
    }

    /**
     * 新增维保信息
     * @param specialEquipmentMaintain
     * @return
     */
    @Override
    public Integer insertEquipmentMaintain(SpecialEquipmentMaintain specialEquipmentMaintain) {
        return specialEquipmentMaintainMapper.insert(specialEquipmentMaintain);
    }

    /**
     * 维保备案信息详情
     * @param id
     * @return
     */
    @Override
    public  List<Map<String,Object>> selectByIdEquipmentMaintain(String id) {
        List<Map<String,Object>> equipmentMaintainInfos = specialEquipmentMaintainMapper.findByIdEquipmentMaintain(id);
        return equipmentMaintainInfos;
    }

    /**
     * 维保预警信息
     * @param dateDTO
     * @param currentPage
     * @return
     */
    @Override
    public IPage<List<Map>> selectWaringInfo(DateDTO dateDTO, int currentPage) {
        Page page = new Page(currentPage, Customize.PAGES_SIZE);
        IPage<List<Map>> WaringInfos = specialEquipmentMaintainMapper.findWaringInfo(page,dateDTO.getStartDate(),dateDTO.getEndDate());
        return WaringInfos;
    }
}
