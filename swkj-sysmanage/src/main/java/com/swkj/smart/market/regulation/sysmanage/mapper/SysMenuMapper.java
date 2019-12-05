package com.swkj.smart.market.regulation.sysmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swkj.smart.market.regulation.model.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    
    
    /**
     *查询用户菜单
     * @param userId
     * @return
     */
    List<SysMenu> findMenusByUserId(Long userId);
}
