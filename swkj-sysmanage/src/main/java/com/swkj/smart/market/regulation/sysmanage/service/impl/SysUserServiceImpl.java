package com.swkj.smart.market.regulation.sysmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.exception.BusinessException;
import com.swkj.smart.market.regulation.sysmanage.mapper.SysRoleMapper;
import com.swkj.smart.market.regulation.sysmanage.mapper.SysUserMapper;
import com.swkj.smart.market.regulation.model.SysMenu;
import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.service.ISysMenuService;
import com.swkj.smart.market.regulation.sysmanage.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private ISysMenuService sysMenuService;
    
    @Autowired
    private SysRoleMapper sysRoleMapper;
    
    @Override
    public SysUser findUserByNo(String userNo) {
        return sysUserMapper.findUserByNo(userNo);
    }
    
    @Override
    public Integer deleteUser(List<SysUser> sysUsers) {
        for (SysUser sysUser : sysUsers) {
            deleteUser(sysUser);
        }
        return 1;
    }
    
    @Override
    public Integer deleteUser(SysUser sysUser) {
        sysUser.setStatus(0);
        return sysUserMapper.updateById(sysUser);
    }
    
    @Override
    public SysUser findUserByMobile(String mobile) {
        return sysUserMapper.findUserByMobile(mobile);
    }
    
    @Override
    public Set<String> findPermissions(Long userId) {
        Set<String> perms = new HashSet<>();
        List<SysMenu> sysMenus = sysMenuService.findMenuByUser(userId);
        for (SysMenu menu : sysMenus) {
            if (menu.getPerms() != null && !"".equals(menu.getPerms())) {
                String[] split = menu.getPerms().split(",");
                for (int i = 0; i < split.length; i++) {
                    perms.add(split[i]);
                }
            }
        }
        return perms;
    }
    
    @Override
    public List<SysRole> findUserRoles(Long userId) {
        return sysRoleMapper.findUserRoles(userId);
    }
    
    @Override
    public String importUser(List<SysUser> userList, long operUserId) {
        if (userList == null || userList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (SysUser sysUser : userList) {
            SysUser u = sysUserMapper.findUserByMobile(sysUser.getMobile());
            if (u == null) {
                sysUser.setCreateBy(operUserId);
                sysUser.setCreateTime(new Date());
                sysUser.setLastUpdateBy(operUserId);
                sysUser.setLastUpdateTime(new Date());
                save(sysUser);
                successNum++;
                successMsg.append("<br/>" + successNum + "、账号 " + sysUser.getUsername() + " 导入成功");
            } else {
                failureNum++;
                failureMsg.append("<br/>" + failureNum + "、账号 " + sysUser.getUsername() + " 已存在");
            }
        }
        if (failureNum > 0) {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        } else {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
    
    @Override
    public IPage findAll(String username, String userNo, Integer status, Date startCreateTime,Date endCreateTime, Page page) {
        return sysUserMapper.findAll(page,username,userNo,status,startCreateTime,endCreateTime);
    }
}
