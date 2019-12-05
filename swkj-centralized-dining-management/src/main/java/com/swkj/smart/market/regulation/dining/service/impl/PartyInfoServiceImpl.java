package com.swkj.smart.market.regulation.dining.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dining.mapper.ChefGroupInfoMapper;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dining.mapper.ChefInfoMapper;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.swkj.smart.market.regulation.model.PartyInfo;
import com.swkj.smart.market.regulation.dining.mapper.PartyInfoMapper;
import com.swkj.smart.market.regulation.dining.service.IPartyInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 * 聚餐的基本信息表 服务实现类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Service
public class PartyInfoServiceImpl extends ServiceImpl<PartyInfoMapper, PartyInfo> implements IPartyInfoService {

    @Autowired
    private PartyInfoMapper partyInfoMapper;


    @Autowired
    private ChefGroupInfoMapper chefGroupInfoMapper;

    @Autowired
    private ChefInfoMapper chefInfoMapper;

    /**
     * 今日正在进行的聚餐
     * @param pn
     * @return
     */
    @Override
    public IPage<PartyInfo> selectTodayDinner(Long pn) {
        QueryWrapper<PartyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("party_date", DateFormatUtil.formatDate(new Date()));
        Page<PartyInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<PartyInfo> iPage = partyInfoMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    /**
     * 今日提交备案的聚餐信息
     * @param pn
     * @return
     */
    @Override
    public IPage<PartyInfo> submitDineTogether(Long pn) {
        QueryWrapper<PartyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("register_date", DateFormatUtil.formatDate(new Date()));
        Page<PartyInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<PartyInfo> iPage = partyInfoMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    /**
     * 用餐信息查询全部
     * @param pn
     * @return
     */
    @Override
    public IPage<PartyInfo> selectRecords(Long pn) {
        IPage<PartyInfo> iPage = partyInfoMapper.selectPage(new Page<>(pn, Customize.PAGES_SIZE), null);
        return iPage;
    }

    /**
     * 用餐信息查询根据条件
     * @param datedto
     * @param pn
     * @return
     */
    @Override
    public IPage<PartyInfo> selectRecordsByDate(DateDTO datedto, Long pn) {
        String start = null;
        String end = null;
        if (datedto.getStartDate() != null) {
            start = DateFormatUtil.formatDate(datedto.getStartDate());
        }
        if (datedto.getEndDate() != null) {

            end = DateFormatUtil.formatDate(datedto.getEndDate());
        }
        Page<PartyInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<PartyInfo> partyInfoIPage = partyInfoMapper.selectRecordsByDate(page, datedto.getName(), start, end);
        return partyInfoIPage;

    }

    /**
     * 用餐信息备案
     * @param partyInfo
     * @return
     */
    @Override
    public int insertRecords(PartyInfo partyInfo) {
        return partyInfoMapper.insert(partyInfo);
    }

    /**
     * 用餐信息备案,根据团队名称查询团队
     *
     * @param groupName
     * @return
     */
    @Override
    public List<ChefGroupInfo> selectGroup(String groupName) {
        List<ChefGroupInfo> chefGroupInfos = chefGroupInfoMapper.selectGroup(groupName);
        return chefGroupInfos;
    }

    /**
     * 用餐信息详情
     * @param id
     * @param chefGroupId
     * @return
     */
    @Override
    public List<Map> selectRecordsById(Long id, Long chefGroupId) {
        QueryWrapper<PartyInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        PartyInfo partyInfo = partyInfoMapper.selectOne(queryWrapper);

        QueryWrapper<ChefInfo> query = new QueryWrapper<>();
        query.eq("chef_group_id",chefGroupId);
        List<ChefInfo> chefInfo = chefInfoMapper.selectList(query);

        HashMap<String, Object> map = new HashMap<>();
        map.put("partyInfo", partyInfo);
        map.put("chefInfo", chefInfo);
        return Arrays.asList(map);
    }

    /**
     * 用餐信息删除
     * @param id
     * @return
     */
    @Override
    public int deleteRecordsById(Long id) {
        return partyInfoMapper.deleteById(id);
    }

    /**
     * 用餐信息修改
     * @param partyInfo
     * @return
     */
    @Override
    public int updateRecordsById(PartyInfo partyInfo) {
        return partyInfoMapper.updateById(partyInfo);
    }
}
