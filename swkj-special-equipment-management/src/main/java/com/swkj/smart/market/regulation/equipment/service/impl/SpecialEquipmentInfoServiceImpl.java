package com.swkj.smart.market.regulation.equipment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.equipment.mapper.SpecialEquipmentInfoMapper;
import com.swkj.smart.market.regulation.equipment.service.SpecialEquipmentInfoService;
import com.swkj.smart.market.regulation.model.SpecialEquipmentInfo;
import com.swkj.smart.market.regulation.util.Customize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author 宋伟朋
 * @date 2019/11/11
 */
@Service
public class SpecialEquipmentInfoServiceImpl extends ServiceImpl<SpecialEquipmentInfoMapper, SpecialEquipmentInfo> implements SpecialEquipmentInfoService {
    @Autowired
    private SpecialEquipmentInfoMapper specialEquipmentInfoMapper;

    /**
     * 特种设备分布地图
     * @return
     */
    @Override
    public List<Map> getAllEquipmentInfo() {
        List<Map> maps = specialEquipmentInfoMapper.findByAddressInfo();
        return maps;
    }

    /**
     * 特种设备所有备案信息查询
     * @param currentPage
     * @return
     */
    @Override
    public IPage<SpecialEquipmentInfo> selectAllEquipmentInfo(int currentPage) {
        Page page = new Page(currentPage, Customize.PAGES_SIZE);
        IPage<SpecialEquipmentInfo> specialEquipmentInfo = specialEquipmentInfoMapper.selectAllEquipmentInfo(page);
        return specialEquipmentInfo;
    }

    /**
     * 设备详情
     * @param id
     * @return
     */
    @Override
    public Map<String,Object>  selectByIdInfo(String id) {
        Map<String,Object>  specialEquipmentInfoIPage = (Map<String, Object>) specialEquipmentInfoMapper.selectByIdInfo(id);
        return specialEquipmentInfoIPage;
    }

    @Override
    public SpecialEquipmentInfo selectByEidInfo(String eId) {
        SpecialEquipmentInfo infos = specialEquipmentInfoMapper.selectByEidInfo(eId);
        return infos;
    }

    /**
     * 新增业主备案信息
     * @param specialEquipmentInfo
     * @return
     */
    @Override
    public Integer insertEquipmentInfo(SpecialEquipmentInfo specialEquipmentInfo) {
        return specialEquipmentInfoMapper.insert(specialEquipmentInfo);
    }

    @Override
    public IPage<Map<String, Object>> selectByEidEquipmentInfo(int currentPage, String eId) {
        Page page = new Page(currentPage,Customize.PAGES_SIZE);
        IPage<Map<String, Object>> infos = specialEquipmentInfoMapper.selectByEidEquipmentInfo(page,eId);
        return infos;
    }

}
