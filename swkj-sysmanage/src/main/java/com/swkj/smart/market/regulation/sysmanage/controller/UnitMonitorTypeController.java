package com.swkj.smart.market.regulation.sysmanage.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.UnitMonitorType;
import com.swkj.smart.market.regulation.sysmanage.service.IUnitMonitorTypeService;
import com.swkj.smart.market.regulation.util.Customize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 重点餐饮单位分类名称表 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-13
 */
@RestController
@RequestMapping("/unitMonitorType")
public class UnitMonitorTypeController {
    @Autowired
    private IUnitMonitorTypeService unitMonitorTypeService;
    
    @PostMapping("/save")
    public HttpResult save(@RequestBody UnitMonitorType unitMonitorType){
        unitMonitorType.setCreateTime(new Date());
        unitMonitorTypeService.saveOrUpdate(unitMonitorType);
        return HttpResult.ok("保存成功");
    }
    @PostMapping("/delete")
    public HttpResult delete(List<UnitMonitorType> records){
        unitMonitorTypeService.delete(records);
        return HttpResult.ok("删除成功");
    }
    
    @GetMapping("/")
    public HttpResult findPage(int currentPage){
        Page page = new Page(currentPage, Customize.PAGES_SIZE);
        return HttpResult.ok(unitMonitorTypeService.page(page));
    }
}

