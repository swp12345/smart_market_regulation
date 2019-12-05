package com.swkj.smart.market.regulation.license.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.CertificateType;
import com.swkj.smart.market.regulation.license.service.ICertificateTypeService;
import com.swkj.smart.market.regulation.util.Customize;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
@RestController
@RequestMapping("/certificateType")
public class CertificateTypeController {
    @Autowired
    private ICertificateTypeService certificateTypeService;
    
    @PostMapping("/save")
    @ApiOperation(value = "保存证照类型")
    public HttpResult save(@RequestBody CertificateType certificateType){
        certificateType.setCreateTime(new Date());
        certificateTypeService.saveOrUpdate(certificateType);
        return HttpResult.ok("保存成功");
    }
    @PostMapping("/delete")
    @ApiOperation(value = "删除证照类型")
    public HttpResult delete(List<CertificateType> records){
        certificateTypeService.delete(records);
        return HttpResult.ok("删除成功");
    }
    
    @GetMapping("/findPage")
    @ApiOperation(value = "分页查询证照类型")
    public HttpResult findPage(int currentPage){
        Page page = new Page(currentPage, Customize.PAGES_SIZE);
        return HttpResult.ok(certificateTypeService.page(page));
    }
    
    @GetMapping("/findAll")
    @ApiOperation(value = "查询所有证照类型")
    public HttpResult findAll(){
        return HttpResult.ok(certificateTypeService.list());
    }
}

