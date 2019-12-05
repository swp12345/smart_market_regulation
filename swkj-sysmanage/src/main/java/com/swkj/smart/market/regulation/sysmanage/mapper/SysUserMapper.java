package com.swkj.smart.market.regulation.sysmanage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swkj.smart.market.regulation.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * <p>
 * 系统用户 Mapper 接口
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    
    /**
     * 通过用户编号查询用户
     * @param userNo 用户编号
     * @return
     */
    SysUser findUserByNo(@Param("userNo") String userNo);
    
    /**
     * 通过手机号查询用户
     * @param mobile
     * @return
     */
    SysUser findUserByMobile(@Param("mobile") String mobile);
    
    /**
     * 查询所有(分页)
     * @param page
     * @return
     */
    IPage findAll(Page page,String username, String userNo, Integer status, Date startCreateTime, Date endCreateTime);
}
