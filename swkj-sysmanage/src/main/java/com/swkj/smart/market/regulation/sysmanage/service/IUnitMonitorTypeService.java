package com.swkj.smart.market.regulation.sysmanage.service;

import com.swkj.smart.market.regulation.model.UnitMonitorType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 重点餐饮单位分类名称表 服务类
 * </p>
 *
 * @author hy
 * @since 2019-11-13
 */
public interface IUnitMonitorTypeService extends IService<UnitMonitorType> {
    
    Integer delete(List<UnitMonitorType> records);
    
    Integer delete(UnitMonitorType unitMonitorType);
}
