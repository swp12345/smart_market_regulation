package com.swkj.smart.market.regulation.sysmanage.controller;


import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.SysOperLog;
import com.swkj.smart.market.regulation.util.ExcelUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 操作日志记录 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/sysOperLog")
public class SysOperLogController {
    
    @PostMapping("/exportOperLog")
    @ApiOperation(value = "导出操作日志")
    public HttpResult exportLogininfo(@RequestBody List<SysOperLog> operLogs, String downloadPath) {
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        return util.exportExcel(operLogs, "操作日志数据", downloadPath);
    }
    
}

