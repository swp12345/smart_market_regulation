package com.swkj.smart.market.regulation.dining.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.swkj.smart.market.regulation.model.PartyInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聚餐的基本信息表 服务类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
public interface IPartyInfoService extends IService<PartyInfo> {

    /**
     * 今日正在进行的聚餐
     * @param pn
     * @return
     */
    IPage<PartyInfo> selectTodayDinner(Long pn);

    /**
     * 今日提交备案的聚餐信息
     * @param pn
     * @return
     */
    IPage<PartyInfo> submitDineTogether(Long pn);

    /**
     * 用餐信息查询全部
     * @param pn
     * @return
     */
    IPage<PartyInfo> selectRecords(Long pn);

    /**
     * 用餐信息查询根据条件
     * @param datedto
     * @param pn
     * @return
     */
    IPage<PartyInfo> selectRecordsByDate(DateDTO datedto, Long pn);

    /**
     * 用餐信息备案
     * @param partyInfo
     * @return
     */
    int insertRecords(PartyInfo partyInfo);

    /**
     * 用餐信息详情
     * @param id
     * @param chefGroupId
     * @return
     */
    List<Map> selectRecordsById(Long id, Long chefGroupId);

    /**
     * 用餐信息删除
     * @param id
     * @return
     */
    int deleteRecordsById(Long id);

    /**
     * 用餐信息修改
     * @param partyInfo
     * @return
     */
    int updateRecordsById(PartyInfo partyInfo);

    /**
     * 用餐信息备案,根据团队名称查询团队
     * @param groupName
     * @return
     */
    List<ChefGroupInfo> selectGroup(String groupName);
}
