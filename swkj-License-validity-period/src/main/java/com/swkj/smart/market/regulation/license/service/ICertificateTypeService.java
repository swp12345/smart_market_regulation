package com.swkj.smart.market.regulation.license.service;

import com.swkj.smart.market.regulation.model.CertificateType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.UnitMonitorType;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
public interface ICertificateTypeService extends IService<CertificateType> {
   
   Integer delete(List<CertificateType> records);
   
   Integer delete(CertificateType certificateType);
}
