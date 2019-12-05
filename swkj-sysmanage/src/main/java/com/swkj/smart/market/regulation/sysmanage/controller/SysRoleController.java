package com.swkj.smart.market.regulation.sysmanage.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.BusinessType;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.sysmanage.service.ISysRoleService;
import com.swkj.smart.market.regulation.sysmanage.utils.CommonProperty;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.util.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {
    
    @Autowired
    private ISysRoleService sysRoleService;
    
    @Autowired
    private CommonProperty<SysRole> commonProperty;
    
    public static final String ADMINROLE = "admin";
    
    
    @PostMapping("/save")
    @ApiOperation(value = "新增/修改角色")
    @Log(title = "新增/修改角色", businessType = BusinessType.UPDATE)
    public HttpResult save( SysRole sysRole) {
        SysUser principal = (SysUser) SecurityUtils.getSubject().getPrincipal();
        SysRole role = sysRoleService.getById(sysRole.getId());
        if (role != null) {
            if (sysRole.getRoleName().equalsIgnoreCase(ADMINROLE)) {
                HttpResult.error("超级管理员角色不允许修改");
            }
            commonProperty.setUpdateInfo(sysRole,principal);
        }
        if (role == null ) {
           if (sysRoleService.findByRoleName(sysRole.getRoleName()) != null){
               return HttpResult.error("该角色已存在");
           }
           commonProperty.setCreateInfo(sysRole,principal);
            commonProperty.setUpdateInfo(sysRole,principal);
        }
        sysRoleService.save(sysRole);
        return HttpResult.ok("保存角色成功");
    }
    
    @PostMapping("/delete")
    @ApiOperation(value = "删除角色")
    @Log(title = "删除角色", businessType = BusinessType.DELETE)
    public HttpResult delete(@RequestBody List<SysRole> roles) {
        for (SysRole role : roles) {
            if (role.getRoleName().equals(ADMINROLE)) {
                return HttpResult.error("超级管理员角色不允许删除");
            }
        }
        sysRoleService.delete(roles);
        return HttpResult.ok("删除角色成功");
    }
    
    @GetMapping("/")
    @ApiOperation(value = "查询角色")
    public HttpResult findPage(int currentPage) {
        Page page = new Page(currentPage, Customize.PAGES_SIZE);
        return HttpResult.ok(sysRoleService.page(page));
    }
    
    @PostMapping("/exportRole")
    @ApiOperation(value = "导出角色")
    public HttpResult exportRole(@RequestBody List<SysRole> roles, String downloadPath) {
        ExcelUtil<SysRole> util = new ExcelUtil<SysRole>(SysRole.class);
        return util.exportExcel(roles, "角色数据", downloadPath);
    }
}

