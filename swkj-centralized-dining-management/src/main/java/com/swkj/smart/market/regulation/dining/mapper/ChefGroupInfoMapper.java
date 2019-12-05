package com.swkj.smart.market.regulation.dining.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.ChefGroupInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 厨师团队备案管理信息 Mapper 接口
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Component
public interface ChefGroupInfoMapper extends BaseMapper<ChefGroupInfo> {

    /**
     * 根据厨师团队名称、开始时间、结束时间
     * @param page
     * @param name
     * @param startDate
     * @param endDate
     * @return
     */
    IPage<ChefGroupInfo> selectRecordsByDate(Page<ChefGroupInfo> page, @Param("name") String name, @Param("startDate") String startDate,@Param("endDate") String endDate);

    /**
     * 用餐信息备案,根据团队名称查询团队
     * @param groupName
     * @return
     */
    @Select("SELECT group_name,manager_name,manager_id FROM chef_group_info WHERE group_name LIKE  CONCAT('%',#{groupName},'%')  ")
    List<ChefGroupInfo> selectGroup(@Param("groupName") String groupName);
}
