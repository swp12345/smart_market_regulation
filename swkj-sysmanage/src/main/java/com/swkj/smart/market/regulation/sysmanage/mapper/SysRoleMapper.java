package com.swkj.smart.market.regulation.sysmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swkj.smart.market.regulation.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {
    
    /**
     * 通过角色名查询角色
     * @param roleName 角色名
     * @return
     */
    SysRole findByRoleName(@Param("roleName") String roleName);
    
    /**
     * 查询用户的所有角色
     * @param userId
     * @return
     */
    List<SysRole> findUserRoles(Long userId);
    
    /**
     * 通过手机号查询角色
     * @param mobile
     * @return
     */
    SysRole findUserByMobile(String mobile);
}
