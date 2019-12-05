package com.swkj.smart.market.regulation.sysmanage.controller;


import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.SysLogininfor;
import com.swkj.smart.market.regulation.util.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 系统访问记录 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/sysLogininfor")
public class SysLogininforController {
    
    @PostMapping("/exportLogininfo")
    @ApiOperation(value = "导出登录日志")
    public HttpResult exportLogininfo(@RequestBody List<SysLogininfor> logininfors,String downloadPath){
        ExcelUtil<SysLogininfor> util = new ExcelUtil<SysLogininfor>(SysLogininfor.class);
        return util.exportExcel(logininfors, "登录日志数据",downloadPath);
    }
}

