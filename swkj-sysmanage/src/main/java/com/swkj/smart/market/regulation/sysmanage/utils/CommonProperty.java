package com.swkj.smart.market.regulation.sysmanage.utils;

import com.swkj.smart.market.regulation.model.BaseEntity;
import com.swkj.smart.market.regulation.model.SysUser;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: Huyang
 * @Date: 2019/11/19
 */

@Component
public class CommonProperty<T extends BaseEntity> {
    
    public void setCreateInfo(T entity, SysUser sysUser){
        entity.setCreateBy(sysUser.getId());
        entity.setCreateTime(new Date());
    }
    
    public void setUpdateInfo(T entity,SysUser sysUser) {
        entity.setLastUpdateBy(sysUser.getId());
        entity.setLastUpdateTime(new Date());
    }
}
