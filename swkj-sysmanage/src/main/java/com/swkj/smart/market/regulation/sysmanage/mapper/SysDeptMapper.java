package com.swkj.smart.market.regulation.sysmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swkj.smart.market.regulation.model.SysDept;

/**
 * <p>
 * 部门表 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface SysDeptMapper extends BaseMapper<SysDept> {
    
    /**
     * 通过用户查询部门
     * @param userId
     * @return
     */
    SysDept findDeptByUser(Long userId);
}
