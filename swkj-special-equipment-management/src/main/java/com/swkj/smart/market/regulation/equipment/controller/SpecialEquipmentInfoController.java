package com.swkj.smart.market.regulation.equipment.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.equipment.service.SpecialEquipmentInfoService;
import com.swkj.smart.market.regulation.model.SpecialEquipmentInfo;
import com.swkj.smart.market.regulation.util.ImageUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *    特种设备基础信息 前端控制器
 * </p>
 * @author 宋伟朋
 * @date 2019/11/11
 */
@RestController
@RequestMapping("/special-equipment-info")
public class SpecialEquipmentInfoController {

    @Autowired
    private SpecialEquipmentInfoService specialEquipmentInfoService;

    @GetMapping("/selectGetAllInfo")
    @ApiOperation(value = "特种设备分布地图")
    public HttpResult selectGetAllInfo(){
        List<Map> maps = specialEquipmentInfoService.getAllEquipmentInfo();
       return HttpResult.ok(maps);
    }

    @GetMapping("/selectAllInfo")
    @ApiOperation(value = "特种设备所有备案信息查询")
    public HttpResult selectAllEquipmentInfo(int currentPage){
        IPage<SpecialEquipmentInfo> specialEquipmentInfoIPage = specialEquipmentInfoService.selectAllEquipmentInfo(currentPage);
        return HttpResult.ok(specialEquipmentInfoIPage);
    }

    @GetMapping("/selectByIdEquipmentInfo")
    @ApiOperation(value = "业主备案信息详情")
    public HttpResult selectByIdEquipmentInfo(String id){
        Map<String,Object>  specialEquipmentInfoIPage = specialEquipmentInfoService.selectByIdInfo(id);
        return HttpResult.ok(specialEquipmentInfoIPage);
    }

    @PostMapping("/addEquipmentInfo")
    @ApiOperation(value = "新增业主备案信息")

    public HttpResult addEquipmentInfo(@RequestBody SpecialEquipmentInfo specialEquipmentInfo){
        String path ="D:/images/";
        specialEquipmentInfo.setQualificationImag(path + specialEquipmentInfo.getQualificationImag());
       Integer index =specialEquipmentInfoService.insertEquipmentInfo(specialEquipmentInfo);
       if (index > 0){
           return HttpResult.ok("新增成功");
       }
        return HttpResult.error("新增失败");
    }

    @RequestMapping("/uploadFile")
    @ApiOperation(value = "合格证图片上传")
    public String uploadFile(
                              MultipartFile qualificationImag,
                              HttpServletRequest request){
        String uploadUrl = null;
        // 图片处理
        try {
            uploadUrl = ImageUtils.upload(request,qualificationImag);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uploadUrl;
    }

    @GetMapping("/selectByEidInfo")
    @ApiOperation(value = "测试设备查询")
    public HttpResult selectByEidInfo(int currentPage,String eId){
        IPage<Map<String,Object>> infos = specialEquipmentInfoService.selectByEidEquipmentInfo(currentPage,eId);
        return HttpResult.ok(infos);
    }
}
