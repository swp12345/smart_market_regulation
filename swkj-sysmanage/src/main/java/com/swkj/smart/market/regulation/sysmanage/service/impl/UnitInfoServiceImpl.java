package com.swkj.smart.market.regulation.sysmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.sysmanage.mapper.UnitInfoMapper;
import com.swkj.smart.market.regulation.model.UnitInfo;
import com.swkj.smart.market.regulation.sysmanage.service.IUnitInfoService;
import com.swkj.smart.market.regulation.util.Customize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 被监管单位信息表 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Service
public class UnitInfoServiceImpl extends ServiceImpl<UnitInfoMapper, UnitInfo> implements IUnitInfoService {

    @Autowired
    private UnitInfoMapper unitInfoMapper;
    /**
     *
     * @param currentPage
     * @return
     */
    @Override
    public IPage<UnitInfo> selectUnitInfos(int currentPage) {
        Page page =new Page(currentPage,Customize.PAGES_SIZE);
        IPage<UnitInfo> infoIPage = unitInfoMapper.selectUnitInfos(page);
        return infoIPage;
    }
}
