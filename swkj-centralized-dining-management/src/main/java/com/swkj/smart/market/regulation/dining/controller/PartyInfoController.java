package com.swkj.smart.market.regulation.dining.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.swkj.smart.market.regulation.model.PartyInfo;
import com.swkj.smart.market.regulation.dining.service.IPartyInfoService;
import com.swkj.smart.market.regulation.util.Customize;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聚餐的基本信息表 前端控制器
 * </p>
 *
 * @author 杨路遥
 * @since 2Customize.NUMBER_OF_JUDGE_019-11-11
 */
@RestController
@RequestMapping("/party-info")
@ApiOperation(value = "集中用餐备案")
public class PartyInfoController {

    @Autowired
    private IPartyInfoService iPartyInfoService;

    @GetMapping("/todayDinner/{pn}")
    @ApiOperation(value = "今日正在进行的聚餐")
    @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    public HttpResult todayDinner(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn) {
        IPage<PartyInfo> partyInfoIPage = iPartyInfoService.selectTodayDinner(pn);
        return HttpResult.ok(partyInfoIPage);
    }

    @GetMapping("/recordDinnerToday/{pn}")
    @ApiOperation(value = "今日提交备案的聚餐信息")
    @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    public Object recordDinnerToday(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn) {
        IPage<PartyInfo> partyInfoIPage = iPartyInfoService.submitDineTogether(pn);
        return HttpResult.ok(partyInfoIPage);
    }

    @GetMapping("/selectRecords/{pn}")
    @ApiOperation(value = "用餐信息查询全部")
    @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    public Object selectRecords(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn) {
        IPage<PartyInfo> partyInfoIPage = iPartyInfoService.selectRecords(pn);
        return HttpResult.ok(partyInfoIPage);
    }

    @GetMapping("/selectRecordsByDate/{pn}")
    @ApiOperation(value = "用餐信息查询根据条件")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    })
    public HttpResult selectRecordsByDate(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn, DateDTO datedto) {
        IPage<PartyInfo> partyInfoIPage = iPartyInfoService.selectRecordsByDate(datedto, pn);
        return HttpResult.ok(partyInfoIPage);
    }

    @PostMapping("/insertRecords")
    @ApiOperation(value = "用餐信息备案")
    public HttpResult insertRecords(@RequestBody PartyInfo partyInfo) {
        int Index = iPartyInfoService.insertRecords(partyInfo);
        if (Index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("录入信息成功");
        }
        return HttpResult.error("录入信息失败");

    }

    @GetMapping("/selectGroup/{groupName}")
    @ApiOperation(value = "用餐信息备案,根据团队名称查询团队")
    public HttpResult selectGroup(@PathVariable String groupName) {
        List<ChefGroupInfo> chefGroupInfo = iPartyInfoService.selectGroup(groupName);
        return HttpResult.ok(chefGroupInfo);
    }


    @GetMapping("/selectRecordsById/{id}")
    @ApiOperation(value = "用餐信息详情")
    @ApiImplicitParam(name = "id", value = "用餐信息备案详情id", required = true)
    public HttpResult selectRecordsById(@PathVariable Long id, Long chefGroupId) {
        List<Map> partyInfo = iPartyInfoService.selectRecordsById(id, chefGroupId);
        return HttpResult.ok(partyInfo);
    }

    @DeleteMapping("/deleteRecordsById/{id}")
    @ApiOperation(value = "用餐信息删除")
    @ApiImplicitParam(name = "id", value = "用餐信息备案详情id", required = true)
    public HttpResult deleteRecordsById(@PathVariable Long id) {
        int index = iPartyInfoService.deleteRecordsById(id);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("删除成功");
        }
        return HttpResult.error("删除失败");

    }

    @PutMapping("/updateRecordsById")
    @ApiOperation(value = "用餐信息修改")
    public HttpResult updateRecordsById(@RequestBody PartyInfo partyInfo) {
        int index = iPartyInfoService.updateRecordsById(partyInfo);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("修改信息成功");
        }
        return HttpResult.error("修改信息失败");
    }

}

