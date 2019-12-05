package com.swkj.smart.market.regulation.dining.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.swkj.smart.market.regulation.dining.service.IChefInfoService;
import com.swkj.smart.market.regulation.util.Customize;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 备案厨师信息表 前端控制器
 * </p>
 *
 * @author 杨路遥
 * @since 2Customize.NUMBER_OF_JUDGE_019-11-11
 */
@RestController
@RequestMapping("/chef-info")
@ApiOperation(value = "厨师备案")
public class ChefInfoController {

    @Autowired
    private IChefInfoService chefInfoService;

    @PostMapping("/insertChef")
    @ApiOperation(value = "新增厨师")
    public HttpResult insertRecords(@RequestBody ChefInfo chefInfo) {
        int Index = chefInfoService.insertChef(chefInfo);
        if (Index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("录入信息成功");
        }
        return HttpResult.error("录入信息失败");
    }


    @GetMapping("/selectTodayChef/{pn}")
    @ApiOperation(value = "今日新增的厨师")
    @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    public HttpResult selectTodayChef(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn) {
        IPage<ChefInfo> partyInfoIPage = chefInfoService.selectTodayChef(pn);
        return HttpResult.ok(partyInfoIPage);
    }


    @GetMapping("/selectChef/{pn}")
    @ApiOperation(value = "厨师信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    })
    public HttpResult selectChef(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn, DateDTO datedto) {
        IPage<ChefInfo> partyInfoIPage = chefInfoService.selectChef(datedto, pn);
        return HttpResult.ok(partyInfoIPage);
    }


    @PutMapping("/updateChef")
    @ApiOperation(value = "厨师信息修改")
    public HttpResult updateChef(@RequestBody ChefInfo chefInfo) {
        int index = chefInfoService.updateChefById(chefInfo);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("修改信息成功");
        }
        return HttpResult.error("修改信息失败");
    }


    @DeleteMapping("/deleteRecordsById/{id}")
    @ApiOperation(value = "厨师信息删除")
    @ApiImplicitParam(name = "id", value = "用餐信息备案详情id", required = true)
    public HttpResult deleteChefById(@PathVariable Long id) {
        int index = chefInfoService.deleteChefById(id);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("删除成功");
        }
        return HttpResult.error("删除失败");
    }

}

