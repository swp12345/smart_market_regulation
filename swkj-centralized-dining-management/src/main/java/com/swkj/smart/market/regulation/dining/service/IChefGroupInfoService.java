package com.swkj.smart.market.regulation.dining.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.swkj.smart.market.regulation.model.HealthCertificate;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 厨师团队备案管理信息 服务类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
public interface IChefGroupInfoService extends IService<ChefGroupInfo> {
    /**
     * 今日新增团队
     * @param pn
     * @return
     */
    IPage<ChefGroupInfo> selectChefRecords(Long pn);

    /**
     * 团队信息查询
     * @param datedto
     * @param pn
     * @return
     */
    IPage<ChefGroupInfo> selectRecordsByDate(DateDTO datedto, Long pn);

    /**
     * 团队信息详情
     * @param id
     * @return
     */
    List<Map> selectTeamById(Long id);

    /**
     * 团队信息录入
     * @param chefGroupInfo
     * @return
     */
    int insertTeam(ChefGroupInfo chefGroupInfo);

    /**
     * 团队信息修改
     * @param chefGroupInfo
     * @return
     */
    int updateTeamById(ChefGroupInfo chefGroupInfo);

    /**
     * 团队信息删除
     * @param id
     * @return
     */
    int deleteTeamById(Long id);

    /**
     * 根据管理者名称模糊查询管理者信息，用于团队信息备案
     * @param managerName
     * @return
     */
    List<HealthCertificate> selectTeamByManagerName(String managerName);

    /**
     * 根据团队id获取团队成员
     * @param pn
     * @param chefTeamId
     * @return
     */
    IPage<ChefInfo> getChefTeamInfo(Long pn, String chefTeamId);
}
