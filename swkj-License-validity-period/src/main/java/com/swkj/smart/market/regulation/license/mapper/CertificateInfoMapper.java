package com.swkj.smart.market.regulation.license.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.CertificateInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 证照信息表 Mapper 接口
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
public interface CertificateInfoMapper extends BaseMapper<CertificateInfo> {
    /**
     * 证照查询
     * @param certificateTypeIds
     * @param unitName
     * @param page
     * @return
     */
    IPage findAll(Page page, String[] certificateTypeIds, String unitName);
    
    /**
     * 预警体现查询
     * @param expireDays
     * @param page
     * @return
     */
    IPage findWarningPage(Page page,int expireDays);
    
    /**
     * 查询有照无证
     * @return
     */
    IPage findNoLicensePage(Page page);
    
    /**
     * 查询许可证超期
     * @return
     */
    IPage findLicenseExpire(Page page);
    
    /**
     * 查询行政处罚
     * @return
     */
    IPage findPunish(Page page);
}
