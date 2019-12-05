package com.swkj.smart.market.regulation.license.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.license.mapper.CertificateInfoMapper;
import com.swkj.smart.market.regulation.license.service.ICertificateInfoService;
import com.swkj.smart.market.regulation.model.CertificateInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 证照信息表 服务实现类
 * </p>
 *
 * @author 杨路遥
 * @since 2019-11-13
 */
@Service
public class CertificateInfoServiceImpl extends ServiceImpl<CertificateInfoMapper, CertificateInfo> implements ICertificateInfoService {
    
    @Autowired
    private CertificateInfoMapper certificateInfoMapper;
    
    @Override
    public IPage findPage( String certificateTypeIdStr,String unitName,int currentPage, int pageSize) {
        String[]  certificateTypeIds = null;
        if(StringUtils.isNotEmpty(certificateTypeIdStr)){
            certificateTypeIds = StringUtils.split(certificateTypeIdStr, ",");
        }
        Page page = new Page(currentPage, pageSize);
        IPage<List<Map<String,Object>>> data = certificateInfoMapper.findAll(page,certificateTypeIds,unitName);
        
        return data;
    }
    
    @Override
    public IPage findWarningPage(int expireDays, int currentPage, int pageSize) {
        Page page = new Page(currentPage, pageSize);
        IPage<List<Map<String,Object>>> data = certificateInfoMapper.findWarningPage(page,expireDays);
        return data;
    }
    
    @Override
    public IPage findNoLicensePage(int currentPage, int pageSize) {
        Page page = new Page(currentPage, pageSize);
        IPage<List<Map<String,Object>>> data = certificateInfoMapper.findNoLicensePage(page);
        return data;
    }
    
    @Override
    public IPage findLicenseExpire(int currentPage, int pageSize) {
        Page page = new Page(currentPage, pageSize);
        IPage<List<Map<String,Object>>> data = certificateInfoMapper.findLicenseExpire(page);
        return data;
    }
    
    @Override
    public IPage findPunish(int currentPage, int pageSize) {
        Page page = new Page(currentPage, pageSize);
        IPage<List<Map<String,Object>>> data = certificateInfoMapper.findPunish(page);
        return data;
    }
}
