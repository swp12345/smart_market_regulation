package com.swkj.smart.market.regulation.sysmanage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.BusinessType;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.OperatorType;
import com.swkj.smart.market.regulation.sysmanage.service.ISysUserService;
import com.swkj.smart.market.regulation.sysmanage.utils.CommonProperty;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.util.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    
    @Autowired
    private ISysUserService sysUserService;
    
    @Autowired
    private CommonProperty<SysUser> commonProperty;
    
    public static final String ADMIN = "admin";
    

    
    @PostMapping("/save")
    @ApiOperation(value = "添加/修改用户")
//    @RequiresPermissions(value = {"user:add", "user:edit"})
    @Log(title = "新增/修改用户",businessType = BusinessType.UPDATE)
    public HttpResult save(@RequestBody SysUser sysUser) {
        SysUser user = sysUserService.getById(sysUser.getId());
        SysUser principal = (SysUser)SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            if (user.getUsername().equals(ADMIN)) {
                return HttpResult.error("超级管理员不允许修改");
            }
            commonProperty.setUpdateInfo(sysUser,principal);
        }
        if (user == null) {
            if (sysUserService.findUserByNo(sysUser.getUserNo()) != null) {
                return HttpResult.error("用户名已存在");
            }
            if (sysUserService.findUserByMobile(sysUser.getMobile()) != null){
                return HttpResult.error("手机号重复");
            }
            commonProperty.setCreateInfo(sysUser,sysUser);
            commonProperty.setUpdateInfo(sysUser,principal);
        }
        sysUserService.save(sysUser);
        return HttpResult.ok("保存用户成功");
    }
    
    @Log(title = "删除用户",businessType = BusinessType.DELETE,operatorType = OperatorType.MANAGE)
    @PostMapping("/delete")
    @ApiOperation(value = "删除用户")
//    @RequiresPermissions(value = {"user:del"})
    public HttpResult delete(@RequestBody List<SysUser> sysUsers) {
        for (SysUser record : sysUsers) {
            if ( ADMIN.equalsIgnoreCase(record.getUsername())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        sysUserService.deleteUser(sysUsers);
        return HttpResult.ok("删除成功");
    }
    
   
    @GetMapping("/")
    @ApiOperation(value = "查询用户")
    public HttpResult findPage(String username, String userNo, Integer status, Date startCreateTime,Date endCreateTime, int currentPage){
        Page page = new Page<>(currentPage, Customize.PAGES_SIZE);
        IPage data = sysUserService.findAll(username,userNo,status,startCreateTime,endCreateTime,page);
        return HttpResult.ok(data);
    }
    
    @PostMapping("/importUser")
    @Log(title = "导入用户",businessType = BusinessType.IMPORT,operatorType = OperatorType.MANAGE)
    @ApiOperation(value = "导入用户")
    public HttpResult importUser(MultipartFile file) throws Exception {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        SysUser sysUser = (SysUser)SecurityUtils.getSubject().getPrincipal();
        long  userId = sysUser.getId();
        String message = sysUserService.importUser(userList,userId);
        return HttpResult.ok(message);
    }
    
    @PostMapping("/exportUser")
    @ApiOperation(value = "导出用户")
    @Log(title = "导出用户",businessType = BusinessType.EXPORT,operatorType = OperatorType.MANAGE)
    public HttpResult exportUser(@RequestBody List<SysUser> sysUsers,String downloadPath){
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportExcel(sysUsers, "用户数据",downloadPath);
    }
    
    @PostMapping("/exportTemplateExcel")
    @ApiOperation(value = "导出模板")
    @Log(title = "导出模板",businessType = BusinessType.EXPORT,operatorType = OperatorType.MANAGE)
    public HttpResult exportTemplateExcel(String downloadPath){
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        return util.exportTemplateExcel("用户数据",downloadPath);
    }
}

