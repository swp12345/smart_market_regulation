package com.swkj.smart.market.regulation.dining.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dining.mapper.ChefInfoMapper;
import com.swkj.smart.market.regulation.dining.mapper.HealthCertificateMapper;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.swkj.smart.market.regulation.dining.mapper.ChefGroupInfoMapper;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.swkj.smart.market.regulation.model.HealthCertificate;
import com.swkj.smart.market.regulation.dining.service.IChefGroupInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 厨师团队备案管理信息 服务实现类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Service
public class ChefGroupInfoServiceImpl extends ServiceImpl<ChefGroupInfoMapper, ChefGroupInfo> implements IChefGroupInfoService {

    @Autowired
    private ChefGroupInfoMapper chefGroupInfoMapper;

    @Autowired
    private HealthCertificateMapper healthCertificateMapper;

    @Autowired
    private ChefInfoMapper chefInfoMapper;
    /**
     * 今日新增的厨师团队
     * @param pn
     * @return
     */
    @Override
    public IPage<ChefGroupInfo> selectChefRecords(Long pn) {
        QueryWrapper<ChefGroupInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("register_time", DateFormatUtil.formatDate(new Date()));
        // 查询第1页，每页返回5条
        Page<ChefGroupInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<ChefGroupInfo> iPage = chefGroupInfoMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    /**
     * 根据团队id获取团队成员
     * @param pn
     * @param chefTeamId
     * @return
     */
    @Override
    public IPage<ChefInfo> getChefTeamInfo(Long pn, String chefTeamId) {
        QueryWrapper<ChefInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("chef_group_id",chefTeamId);
        Page<ChefInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<ChefInfo> chefInfoIPage = chefInfoMapper.selectPage(page, queryWrapper);
        return chefInfoIPage;
    }

    /**
     * 根据厨师姓名、开始时间、结束时间查询
     * @param datedto
     * @param pn
     * @return
     */
    @Override
    public IPage<ChefGroupInfo> selectRecordsByDate(DateDTO datedto, Long pn) {
        String start = null;
        String end = null;
        if (datedto.getStartDate() != null) {
            start = DateFormatUtil.formatDate(datedto.getStartDate());
        }
        if (datedto.getEndDate() != null) {

            end = DateFormatUtil.formatDate(datedto.getEndDate());
        }
        Page<ChefGroupInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<ChefGroupInfo> partyInfoIPage = chefGroupInfoMapper.selectRecordsByDate(page, datedto.getName(),start,end);
        return partyInfoIPage;
    }

    /**
     * 团队信息详情
     * @param id
     * @return
     */
    @Override
    public List<Map> selectTeamById(Long id) {
        QueryWrapper<ChefGroupInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        ChefGroupInfo chefGroupInfo = chefGroupInfoMapper.selectOne(queryWrapper);


        QueryWrapper<ChefInfo> query = new QueryWrapper<>();
        queryWrapper.eq("chef_group_id",id);
        List<ChefInfo> chefInfo = chefInfoMapper.selectList(query);

        HashMap<String, Object> map = new HashMap<>();
        map.put("chefGroupInfo", chefGroupInfo);
        map.put("chefInfo", chefInfo);
        return Arrays.asList(map);
    }

    /**
     * 厨师团队录入
     * @param chefGroupInfo
     * @return
     */
    @Override
    public int insertTeam(ChefGroupInfo chefGroupInfo) {
        return chefGroupInfoMapper.insert(chefGroupInfo);
    }

    /**
     * 根据管理者名称模糊查询管理者信息，用于团队信息备案
     * @param managerName
     * @return
     */
    @Override
    public List<HealthCertificate> selectTeamByManagerName(String managerName) {
        List<HealthCertificate> healthCertificate =  healthCertificateMapper.selectTeamByManagerName(managerName);
        return healthCertificate;
    }

    /**
     * 厨师团队修改
     * @param chefGroupInfo
     * @return
     */
    @Override
    public int updateTeamById(ChefGroupInfo chefGroupInfo) {
        return chefGroupInfoMapper.updateById(chefGroupInfo);
    }

    /**
     * 厨师团队删除
     * @param id
     * @return
     */
    @Override
    public int deleteTeamById(Long id) {
        return chefGroupInfoMapper.deleteById(id);
    }
}
