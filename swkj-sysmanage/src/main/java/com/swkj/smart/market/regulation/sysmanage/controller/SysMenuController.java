package com.swkj.smart.market.regulation.sysmanage.controller;


import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.BusinessType;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.SysMenu;
import com.swkj.smart.market.regulation.sysmanage.service.ISysMenuService;
import com.swkj.smart.market.regulation.sysmanage.utils.CommonProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    
    @Autowired
    ISysMenuService sysMenuService;
    
    @Autowired
    private CommonProperty<SysMenu> commonProperty;
    
    @ApiOperation("添加/修改菜单")
//    @RequiresPermissions({"menu:add", "menu:edit"})
    @PostMapping(value="/save")
    @Log(title = "添加/修改菜单",businessType = BusinessType.UPDATE)
    public HttpResult save(@RequestBody SysMenu record) {
        SysMenu sysMenu = sysMenuService.getById(record.getId());
        SysUser principal = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (sysMenu == null){
            commonProperty.setCreateInfo(record,principal);
        }
        commonProperty.setUpdateInfo(record,principal);
        return HttpResult.ok(sysMenuService.saveOrUpdate(record));
        
    }
    
    @ApiOperation("删除菜单")
//    @RequiresPermissions("menu:delete")
    @PostMapping(value="/delete")
    @Log(title = "菜单删除",businessType = BusinessType.DELETE)
    public HttpResult delete(@RequestBody List<SysMenu> records) {
        sysMenuService.delete(records);
        return HttpResult.ok("删除菜单成功");
    }
    
    @ApiOperation("查找导航菜单")
    @GetMapping("/findNavTree")
    public HttpResult findNavTree(@RequestParam Long userId){
        return HttpResult.ok(sysMenuService.findTree(userId,1));
    }
    @ApiOperation("查找所有菜单")
//    @RequiresPermissions("menu:view")
    @RequiresRoles("admin")
    @GetMapping("/findMenuTree")
    public HttpResult findMenuTree(){
        return HttpResult.ok(sysMenuService.findTree(null, 0));
    }
}

