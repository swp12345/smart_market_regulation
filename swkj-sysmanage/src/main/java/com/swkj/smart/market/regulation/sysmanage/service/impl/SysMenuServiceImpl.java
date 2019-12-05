package com.swkj.smart.market.regulation.sysmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.sysmanage.mapper.SysMenuMapper;
import com.swkj.smart.market.regulation.model.SysMenu;
import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.sysmanage.service.ISysMenuService;
import com.swkj.smart.market.regulation.sysmanage.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {
    @Autowired
    private ISysUserService sysUserService;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    
    private static final String ADMINROLE = "admin";
    
    
    @Override
    public List<SysMenu> findMenuByUser(Long userId) {
        List<SysRole> userRoles = sysUserService.findUserRoles(userId);
        List<String> roles = new ArrayList<>();
        for (SysRole sysRole : userRoles) {
            roles.add(sysRole.getRoleName());
        }
        if (roles.contains(ADMINROLE) || userId == null) {
            return sysMenuMapper.selectList(null);
        }
        return sysMenuMapper.findMenusByUserId(userId);
    }
    
    @Override
    public Integer delete(List<SysMenu> records) {
        for (SysMenu record : records) {
            delete(record);
        }
        return 1;
    }
    
    @Override
    public List<SysMenu> findTree(Long userId, Integer menuType) {
        List<SysMenu> sysMenus  = new ArrayList<>();
        List<SysMenu> menus = findMenuByUser(userId);
        for (SysMenu menu : menus){
            if (menu.getParentId() == null || menu.getParentId() == 0){
                //找到一级菜单，一级菜单的父Id为0或为null
                menu.setLevel(0);
                if(!exists(sysMenus, menu)) {
                    sysMenus.add(menu);
                }
            }
        }
        sysMenus.sort((o1,o2) ->o1.getOrderNum().compareTo(o2.getOrderNum()));
        findChildren(sysMenus,menus,menuType);
        return sysMenus;
    }
    
    @Override
    public Integer delete(SysMenu sysMenu) {
        return sysMenuMapper.deleteById(sysMenu.getId());
    }
    
    @Override
    public IPage<SysMenu> findPage(Integer currentPage, Integer pageSize) {
        Page<SysMenu> page = new Page<>(currentPage,pageSize);
        page.setRecords(sysMenuMapper.selectList(null));
        return page;
    }
    
    private void findChildren(List<SysMenu> sysMenus, List<SysMenu> menus, Integer menuType) {
        for (SysMenu sysMenu : sysMenus){
            List<SysMenu> children = new ArrayList<>();
            for (SysMenu menu : menus){
                if (menuType == 1 && menu.getType() == 2){
                    // 如果是获取类型不需要按钮，且菜单类型是按钮的，直接过滤掉
                    continue;
                }
                if (sysMenu.getId() != null && sysMenu.getId().equals(menu.getParentId())){
                    menu.setParentName(sysMenu.getName());
                    menu.setLevel(sysMenu.getLevel()+1);
                    if (!exists(children,menu)){
                        children.add(menu);
                    }
                }
            }
            sysMenu.setChildren(children);
            children.sort((o1,o2) -> o1.getOrderNum().compareTo(o2.getOrderNum()));
            findChildren(children,menus,menuType);
        }
    }
    
    private boolean exists(List<SysMenu> sysMenus,SysMenu menu){
        boolean exists = false;
        for (SysMenu sysMenu : sysMenus){
            if (menu.getId().equals(sysMenu.getId())){
                exists = true;
            }
        }
        return exists;
    }
}
