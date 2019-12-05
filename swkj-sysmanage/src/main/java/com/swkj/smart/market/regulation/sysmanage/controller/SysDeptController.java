package com.swkj.smart.market.regulation.sysmanage.controller;


import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.SysDept;
import com.swkj.smart.market.regulation.model.SysMenu;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.service.ISysDeptService;
import com.swkj.smart.market.regulation.sysmanage.utils.CommonProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {
    @Autowired
    private ISysDeptService sysDeptService;
    
    @Autowired
    private CommonProperty<SysDept> commonProperty;
    
    //    @RequiresPermissions("dept:view")
    @ApiOperation(value = "查询部门")
    @GetMapping("/{currentPage}/{pageSize}")
    public HttpResult findPage(@PathVariable int currentPage, @PathVariable int pageSize) {
        return HttpResult.ok(sysDeptService.findPage(currentPage, pageSize));
    }
    
    //    @RequiresPermissions({"dept:add","dept:edit"})
    @PostMapping("/save")
    @ApiOperation(value = "保存部门")
    public HttpResult save(@RequestBody SysDept sysDept) {
        SysDept dept = sysDeptService.getById(sysDept.getId());
        SysUser principal = (SysUser) SecurityUtils.getSubject().getPrincipal();
        if (dept == null){
            commonProperty.setCreateInfo(sysDept,principal);
        }
        commonProperty.setUpdateInfo(sysDept,principal);
        return HttpResult.ok(sysDeptService.saveOrUpdate(sysDept));
    }
    
    //    @RequiresPermissions("dept:del")
    @PostMapping("/delete")
    @ApiOperation(value = "删除部门")
    public HttpResult deleteDept(@RequestBody List<SysDept> records) {
        return HttpResult.ok(sysDeptService.deleteDepts(records));
    }
    
    //    @RequiresPermissions("dept:view")
    @ApiOperation(value = "查找部门树")
    public HttpResult findTree() {
        return HttpResult.ok(sysDeptService.findTree());
    }
}

