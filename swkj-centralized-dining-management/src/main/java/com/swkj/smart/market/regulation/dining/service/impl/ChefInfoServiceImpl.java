package com.swkj.smart.market.regulation.dining.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.dto.DateDTO;
import com.swkj.smart.market.regulation.dining.mapper.HealthCertificateMapper;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.swkj.smart.market.regulation.dining.mapper.ChefInfoMapper;
import com.swkj.smart.market.regulation.model.HealthCertificate;
import com.swkj.smart.market.regulation.dining.service.IChefInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.util.DateFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 备案厨师信息表 服务实现类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Service
public class ChefInfoServiceImpl extends ServiceImpl<ChefInfoMapper, ChefInfo> implements IChefInfoService {

    @Autowired
    private ChefInfoMapper chefInfoMapper;

    @Autowired
    private HealthCertificateMapper healthCertificateMapper;



    @Override
    public int insertChef(ChefInfo chefInfo) {
        QueryWrapper<HealthCertificate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("people_id", chefInfo.getChefId()).eq("people_name", chefInfo.getChefName()).eq("health_id",chefInfo.getHealthCode());
        HealthCertificate healthCertificate = healthCertificateMapper.selectOne(queryWrapper);
        if (healthCertificate==null){
            return Customize.NUMBER_OF_JUDGE_0;
        }
        if (chefInfo.getChefGroupId()!=null){
            //团队新增成员
            QueryWrapper<ChefInfo> query= new QueryWrapper<>();
            query.eq("chef_name",chefInfo.getChefName()).eq("chef_id",chefInfo.getChefId());
                return chefInfoMapper.update(chefInfo,query);
        }else {
            //新增厨师备案
                return chefInfoMapper.insert(chefInfo);
        }
    }


    @Override
    public IPage<ChefInfo> selectTodayChef(Long pn) {
        QueryWrapper<ChefInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("register_date", DateFormatUtil.formatDate(new Date()));
        // 查询第1页，每页返回5条
        Page<ChefInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<ChefInfo> iPage = chefInfoMapper.selectPage(page, queryWrapper);
        return iPage;
    }

    @Override
    public IPage<ChefInfo> selectChef(DateDTO datedto, Long pn) {
        String start = null;
        String end = null;
        if (datedto.getStartDate() != null) {
            start = DateFormatUtil.formatDate(datedto.getStartDate());
        }
        if (datedto.getEndDate() != null) {

            end = DateFormatUtil.formatDate(datedto.getEndDate());
        }
        Page<ChefInfo> page = new Page<>(pn, Customize.PAGES_SIZE);
        IPage<ChefInfo> partyInfoIPage = chefInfoMapper.selectRecordsByDate(page, datedto.getName(), start, end);
        return partyInfoIPage;
    }

    @Override
    public int updateChefById(ChefInfo chefInfo) {
        return chefInfoMapper.updateById(chefInfo);
    }

    @Override
    public int deleteChefById(Long id) {
        return chefInfoMapper.deleteById(id);
    }
}
