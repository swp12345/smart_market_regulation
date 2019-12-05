package com.swkj.smart.market.regulation.sysmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.model.UnitMonitorType;
import com.swkj.smart.market.regulation.sysmanage.mapper.UnitMonitorTypeMapper;
import com.swkj.smart.market.regulation.sysmanage.service.IUnitMonitorTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 重点餐饮单位分类名称表 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-11-13
 */
@Service
public class UnitMonitorTypeServiceImpl extends ServiceImpl<UnitMonitorTypeMapper, UnitMonitorType> implements IUnitMonitorTypeService {
    
    @Autowired
    private UnitMonitorTypeMapper unitMonitorTypeMapper;
    
    @Override
    public Integer delete(List<UnitMonitorType> records) {
        for (UnitMonitorType record : records) {
            delete(record);
        }
        return 1;
    }
    
    @Override
    public Integer delete(UnitMonitorType unitMonitorType) {
        return unitMonitorTypeMapper.deleteById(unitMonitorType.getId());
    }
}
