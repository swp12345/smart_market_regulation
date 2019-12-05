package com.swkj.smart.market.regulation.dining.mapper;

import com.swkj.smart.market.regulation.model.HealthCertificate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-11
 */
@Component
public interface HealthCertificateMapper extends BaseMapper<HealthCertificate> {
    /**
     * 根据管理者名称模糊查询管理者信息，用于团队信息备案
     * @param managerName
     * @return
     */
    @Select("SELECT people_name,people_id FROM health_certificate WHERE people_name LIKE  CONCAT('%',#{managerName},'%')  ")
    List<HealthCertificate> selectTeamByManagerName(@Param("managerName") String managerName);
}
