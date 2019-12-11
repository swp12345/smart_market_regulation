package com.swkj.smart.market.regulation.sysmanage.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.UnitInfo;
import com.swkj.smart.market.regulation.sysmanage.service.IUnitInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 被监管单位信息表 前端控制器
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@RestController
@RequestMapping("/unit-info")
public class UnitInfoController {

    @Autowired
    private IUnitInfoService iUnitInfoService;

    @ApiOperation(value = "所有单位查询")
    @GetMapping(value = "/selectUnitInfos")
    public HttpResult selectUnitInfos(int currentPage){
        IPage<UnitInfo> infoIPage = iUnitInfoService.selectUnitInfos(currentPage);
        return HttpResult.ok(infoIPage);
    }

}

