package com.swkj.smart.market.regulation.dining.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.swkj.smart.market.regulation.model.ChefInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 备案厨师信息表 Mapper 接口
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Component
public interface ChefInfoMapper extends BaseMapper<ChefInfo> {
    /**
     * 根据厨师团队名称、开始时间、结束时间
     * @param page
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    IPage<ChefInfo> selectRecordsByDate(Page<ChefInfo> page, @Param("name") String name, @Param("startDate") String startDate, @Param("endDate") String endDate);

}
