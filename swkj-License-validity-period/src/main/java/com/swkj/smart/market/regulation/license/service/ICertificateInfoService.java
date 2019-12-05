package com.swkj.smart.market.regulation.license.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.CertificateInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 证照信息表 服务类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
public interface ICertificateInfoService extends IService<CertificateInfo> {
    
    /**
     * 证照查询
     * @param currentPage
     * @param pageSize
     * @param certificateTypeIdStr
     * @return
     */
    IPage findPage(String certificateTypeIdStr, String unitName,int currentPage, int pageSize);
    
    /**
     * 预警提醒查询
     * @param expireDays
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage findWarningPage(int expireDays,int currentPage,int pageSize);
    
    /**
     * 查询有照无证
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage findNoLicensePage(int currentPage, int pageSize);
    
    /**
     * 许可证超期
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage findLicenseExpire(int currentPage, int pageSize);
    
    /**
     * 查询行政处罚
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage findPunish(int currentPage, int pageSize);
}
