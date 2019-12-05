package com.swkj.smart.market.regulation.dining.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.PartyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 聚餐的基本信息表 Mapper 接口
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Component
public interface PartyInfoMapper extends BaseMapper<PartyInfo> {

    /**
     * 根据厨师团队名称、开始时间、结束时间
     * @param page
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    IPage<PartyInfo> selectRecordsByDate(Page<PartyInfo> page, String name, String startDate, String endDate);


}
