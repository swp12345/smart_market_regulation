package com.swkj.smart.market.regulation.sysmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.UnitInfo;

/**
 * <p>
 * 被监管单位信息表 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface UnitInfoMapper extends BaseMapper<UnitInfo> {

    /**
     * 查询所有的单位信息
     * @param pageNumber
     * @return
     */
    IPage<UnitInfo> selectUnitInfos(Page pageNumber);

}
