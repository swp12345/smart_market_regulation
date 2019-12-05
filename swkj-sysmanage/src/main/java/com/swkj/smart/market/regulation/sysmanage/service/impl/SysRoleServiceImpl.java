package com.swkj.smart.market.regulation.sysmanage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.sysmanage.mapper.SysRoleMapper;
import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.sysmanage.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
    
    @Autowired
    private SysRoleMapper sysRoleMapper;
    
    @Override
    public SysRole findByRoleName(String roleName) {
        return sysRoleMapper.findByRoleName(roleName);
    }
    
    @Override
    public void delete(List<SysRole> roles) {
        for (SysRole role : roles) {
            delete(role);
        }
    }
    
    @Override
    public void delete(SysRole sysRole) {
        sysRoleMapper.deleteById(sysRole.getId());
    }
    
    @Override
    public SysRole findUserByMobile(String mobile) {
        return sysRoleMapper.findUserByMobile(mobile);
    }
}
