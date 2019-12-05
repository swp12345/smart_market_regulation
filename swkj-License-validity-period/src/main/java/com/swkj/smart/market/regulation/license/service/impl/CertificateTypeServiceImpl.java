package com.swkj.smart.market.regulation.license.service.impl;

import com.swkj.smart.market.regulation.license.mapper.CertificateTypeMapper;
import com.swkj.smart.market.regulation.license.service.ICertificateTypeService;
import com.swkj.smart.market.regulation.model.CertificateType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
@Service
public class CertificateTypeServiceImpl extends ServiceImpl<CertificateTypeMapper, CertificateType> implements ICertificateTypeService {
    
    @Autowired
    private CertificateTypeMapper certificateTypeMapper;
    
    @Override
    public Integer delete(List<CertificateType> records) {
        for (CertificateType record : records) {
            delete(record);
        }
        return 1;
    }
    
    @Override
    public Integer delete(CertificateType certificateType) {
        return certificateTypeMapper.deleteById(certificateType.getId());
    }
}
