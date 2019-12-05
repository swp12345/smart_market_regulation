package com.swkj.smart.market.regulation.sysmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface ISysMenuService extends IService<SysMenu> {
    
    /**
     * 查询用户菜单权限
     * @param userId
     * @return
     */
    List<SysMenu> findMenuByUser(Long userId);
    
    /**
     * 删除菜单
     * @param records
     * @return
     */
    Integer delete(List<SysMenu> records);
    
    /**
     * 查找菜单树
     * @param o
     * @param i
     * @return
     */
    List<SysMenu> findTree(Long userId, Integer menuType);
    
    /**
     * 删除菜单
     * @param sysMenu
     * @return
     */
    Integer delete(SysMenu sysMenu);
    
    /**
     * 查找菜单（分页）
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<SysMenu> findPage(Integer currentPage, Integer pageSize);
    
}
