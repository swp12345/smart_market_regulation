package com.swkj.smart.market.regulation.sysmanage.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swkj.smart.market.regulation.model.SysDept;
import com.swkj.smart.market.regulation.sysmanage.mapper.SysDeptMapper;
import com.swkj.smart.market.regulation.sysmanage.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author hy
 * @since 2019-11-07
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {
    
    @Autowired
    private SysDeptMapper sysDeptMapper;
    
    
    @Override
    public SysDept findDeptByUser(Long userId) {
        return sysDeptMapper.findDeptByUser(userId);
    }
    @Override
    public IPage<SysDept> findPage(int currentPage, int pageSize) {
        Page<SysDept> page = new Page<>(currentPage, pageSize);
        page.setRecords(sysDeptMapper.selectList(null));
        return page;
    }
    
    @Override
    public Integer deleteDept(SysDept sysDept) {
        return sysDeptMapper.deleteById(sysDept.getId());
    }
    
    @Override
    public List<SysDept> findTree() {
        List<SysDept> sysDepts = new ArrayList<>();
        List<SysDept> depts = sysDeptMapper.selectList(null);
        for (SysDept dept : depts){
            if (dept.getParentId() == null || dept.getParentId() == 0){
                dept.setLevel(0);
                sysDepts.add(dept);
            }
        }
        findChildren(sysDepts,depts);
        return sysDepts;
    }
    
    private void findChildren(List<SysDept> sysDepts, List<SysDept> depts) {
        for (SysDept sysDept : sysDepts){
            List<SysDept> children = new ArrayList<>();
            for (SysDept dept : depts){
                if (sysDept.getId() != null && dept.getParentId().equals(sysDept.getId())){
                    dept.setParentName(dept.getDeptName());
                    dept.setLevel(sysDept.getLevel() + 1);
                    children.add(dept);
                }
            }
            sysDept.setChildren(children);
            findChildren(children, depts);
        }
    }
    
    @Override
    public Integer deleteDepts(List<SysDept> records) {
        for (SysDept sysDept : records) {
            deleteDept(sysDept);
        }
        return 1;
    }
}
