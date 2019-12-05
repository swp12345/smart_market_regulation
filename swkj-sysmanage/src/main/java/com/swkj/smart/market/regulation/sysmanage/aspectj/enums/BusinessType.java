package com.swkj.smart.market.regulation.sysmanage.aspectj.enums;

/**
 * 操作类型
 *
 * @Author: Huyang
 * @Date: 2019/11/12
 */
public enum BusinessType {
    /**
     * 其他
     */
    OTHER,
    /**
     * 新增
     */
    INSERT,
    /**
     *修改
     */
    UPDATE,
    /**
     * 删除
     */
    DELETE,
    /**
     * 授权
     */
    GRANT,
    /**
     *导出
     */
    EXPORT,
    /**
     * 导入
     */
    IMPORT,
    /**
     * 强退
     */
    FORCE,
    
    /**
     * 生成代码
     */
    GENCODE,
    
    /**
     * 清空数据
     */
    CLEAN
}
