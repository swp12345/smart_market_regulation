package com.swkj.smart.market.regulation.sysmanage.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.swkj.smart.market.regulation.model.SysDept;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
public interface ISysDeptService extends IService<SysDept> {
    /**
     * 通过用户查询部门
     * @param userId
     * @return
     */
    SysDept findDeptByUser(Long userId);
    
    /**
     * 查找部门（分页）
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<SysDept> findPage(int currentPage, int pageSize);
    
    /**
     * 批量删除部门
     * @param records
     * @return
     */
    Integer deleteDepts(List<SysDept> records);
    
    /**
     * 删除单个部门
     * @param sysDept
     * @return
     */
    Integer deleteDept(SysDept sysDept);
    
    /**
     * 查找部门树
     * @return
     */
    List<SysDept> findTree();
}
