package com.swkj.smart.market.regulation.license.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.license.service.ICertificateInfoService;
import com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 证照信息表 前端控制器
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
@RestController
@RequestMapping("/certificateInfo")
public class CertificateInfoController {
    @Autowired
    private ICertificateInfoService certificateInfoService;
    
    @GetMapping("/")
    @ApiOperation(value = "查询证照信息")
    public HttpResult findPage(String certificateTypeIdStr, String unitName,int currentPage,int pageSize){
      IPage page = certificateInfoService.findPage(certificateTypeIdStr,unitName,currentPage, pageSize);
      return HttpResult.ok(page);
    }
    
    @GetMapping("/findWarningPage")
    @ApiOperation(value = "查询预警证照")
    public  HttpResult findWarningPage(int expireDays,int currentPage,int pageSize){
        IPage page =  certificateInfoService.findWarningPage(expireDays,currentPage,pageSize);
        return HttpResult.ok(page);
    }
    
    @GetMapping("/findNoLicensePage")
    @ApiOperation(value = "查询有照无证")
    public HttpResult findNoLicensePage(int currentPage,int pageSize){
        IPage page =  certificateInfoService.findNoLicensePage(currentPage,pageSize);
        return HttpResult.ok(page);
    }
    
    @GetMapping("/findLicenseExpire")
    @ApiOperation(value = "查询证照过期")
    public HttpResult findLicenseExpire(int currentPage,int pageSize){
        IPage page =  certificateInfoService.findLicenseExpire(currentPage,pageSize);
        return HttpResult.ok(page);
    }
    
    @GetMapping("/findPunish")
    @ApiOperation(value = "查询行政处罚")
    public HttpResult findPunish(int currentPage,int pageSize){
        IPage page =  certificateInfoService.findPunish(currentPage,pageSize);
        return HttpResult.ok(page);
    }
}

