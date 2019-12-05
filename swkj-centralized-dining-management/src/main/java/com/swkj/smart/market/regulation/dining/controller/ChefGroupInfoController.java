package com.swkj.smart.market.regulation.dining.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.swkj.smart.market.regulation.model.HealthCertificate;
import com.swkj.smart.market.regulation.dining.service.IChefGroupInfoService;
import com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.BusinessType;
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
 * 厨师团队备案管理信息 前端控制器
 * </p>
 *
 * @author 杨路遥
 * @since 2Customize.NUMBER_OF_JUDGE_019-11-11
 */
@RestController
@RequestMapping("/chef-group-info")
@ApiOperation(value = "厨师团队备案")
public class ChefGroupInfoController {

    @Autowired
    private IChefGroupInfoService iChefGroupInfoService;

    @GetMapping("/getChefRecords/{pn}")
    @ApiOperation(value = "今日新增团队")
    @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    public HttpResult selectChefRecords(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn) {
        IPage<ChefGroupInfo> partyInfoIPage = iChefGroupInfoService.selectChefRecords(pn);
        return HttpResult.ok(partyInfoIPage);
    }

    @GetMapping("/getChefTeamInfo/{pn}")
    @ApiOperation(value = "根据团队id获取团队成员")
    @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    public HttpResult getChefTeamInfo(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn, String chefTeamId) {
        IPage<ChefInfo> partyInfoIPage = iChefGroupInfoService.getChefTeamInfo(pn, chefTeamId);
        return HttpResult.ok(partyInfoIPage);
    }


    @GetMapping("/getRecordsByDate/{pn}")
    @ApiOperation(value = "团队信息查询")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pn", value = "分页第几页", required = true)
    })
    public HttpResult getRecordsByDate(@RequestParam(value = "pn", defaultValue = "1") @PathVariable Long pn, DateDTO datedto) {
        IPage<ChefGroupInfo> partyInfoIPage = iChefGroupInfoService.selectRecordsByDate(datedto, pn);
        return HttpResult.ok(partyInfoIPage);
    }


    @GetMapping("/getTeamById/{id}")
    @ApiOperation(value = "团队信息详情")
    @ApiImplicitParam(name = "id", value = "团队信息详情id", required = true)
    public HttpResult selectTeamById(@PathVariable Long id) {
        List<Map> chefGroupInfo = iChefGroupInfoService.selectTeamById(id);
        return HttpResult.ok(chefGroupInfo);
    }


    @PostMapping("/setTeam")
    @ApiOperation(value = "团队信息录入")
    public HttpResult insertTeam(@RequestBody ChefGroupInfo chefGroupInfo) {
        int index = iChefGroupInfoService.insertTeam(chefGroupInfo);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("录入信息成功");
        }
        return HttpResult.error("录入信息失败");
    }

    @GetMapping("/selectTeam/{ManagerName}")
    @ApiOperation(value = "根据管理者名称模糊查询管理者信息，用于团队信息备案")
    public HttpResult selectTeamByManagerName(@PathVariable String ManagerName) {
        List<HealthCertificate> healthCertificate = iChefGroupInfoService.selectTeamByManagerName(ManagerName);
        return HttpResult.ok(healthCertificate);
    }


    @PutMapping("/updateTeamById")
    @Log(title = "团队信息删除",businessType = BusinessType.UPDATE)
    @ApiOperation(value = "团队信息修改")
    public HttpResult updateTeamById(@RequestBody ChefGroupInfo chefGroupInfo) {
        int index = iChefGroupInfoService.updateTeamById(chefGroupInfo);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("修改信息成功");
        }
        return HttpResult.error("修改信息失败");
    }

    @DeleteMapping("/deleteTeamById/{id}")
    @Log(title = "团队信息删除",businessType = BusinessType.DELETE)
    @ApiOperation(value = "团队信息删除")
    @ApiImplicitParam(name = "id", value = "团队信息删除根据id", required = true)
    public HttpResult deleteTeamById(@PathVariable Long id) {
        int index = iChefGroupInfoService.deleteTeamById(id);
        if (index > Customize.NUMBER_OF_JUDGE_0) {
            return HttpResult.ok("删除成功");
        }
        return HttpResult.error("删除失败");
    }
}

