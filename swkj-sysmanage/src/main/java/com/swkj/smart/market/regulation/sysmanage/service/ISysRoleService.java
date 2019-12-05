package com.swkj.smart.market.regulation.sysmanage.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.SysRole;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface ISysRoleService extends IService<SysRole> {
    
    /**
     * 通过角色名查询角色
     * @param roleName 角色名
     * @return
     */
    SysRole findByRoleName(String roleName);
    
    /**
     * 批量删除角色
     * @param roles
     */
    void delete(List<SysRole> roles);
    
    /**
     * 删除单个角色
     * @param sysRole
     */
    
    void delete(SysRole sysRole);
    
    /**
     * 通过手机号查询角色
     * @param mobile
     * @return
     */
    SysRole findUserByMobile(String mobile);
}
