package com.swkj.smart.market.regulation.sysmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.UnitInfo;

/**
 * <p>
 * 被监管单位信息表 服务类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface IUnitInfoService extends IService<UnitInfo> {

    /**
     * 查询所有的单位信息
     * @param currentPage
     * @return
     */
    IPage<UnitInfo> selectUnitInfos(int currentPage);

}
