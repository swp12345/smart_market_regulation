package com.swkj.smart.market.regulation.sysmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.model.SysUser;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface ISysUserService extends IService<SysUser> {
    
    /**
     * 通过用户No查找用户
     * @param userNo
     * @return
     */
    SysUser findUserByNo(String userNo);
    
    /**
     * 批量删除用户
     * @param sysUsers
     * @return
     */
    Integer deleteUser(List<SysUser> sysUsers);
    
    /**
     * 删除单个用户
     * @param sysUser
     * @return
     */
    Integer deleteUser(SysUser sysUser);
    
    /**
     * 通过手机号出查询用户
     * @param mobile
     * @return
     */
    SysUser findUserByMobile(String mobile);
    
    
    /**
     * 查询权限集合
     * @param userId 用户ID
     * @return
     */
    Set<String> findPermissions(Long userId);
    
    /**
     * 查询角色集合
     * @param userId 用户ID
     * @return
     */
    List<SysRole> findUserRoles(Long userId);
    
    /**
     * 导入用户
     * @param userList
     * @param operName
     * @return
     */
    String importUser(List<SysUser> userList, long operUserId);
    
    /**
     * 查询所有(分页)
     * @param page
     * @return
     */
    IPage findAll(String username, String userNo, Integer status, Date startCreateTime, Date endCreateTime, Page page);
}
