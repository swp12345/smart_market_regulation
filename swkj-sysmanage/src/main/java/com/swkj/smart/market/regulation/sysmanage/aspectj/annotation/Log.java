package com.swkj.smart.market.regulation.sysmanage.aspectj.annotation;

import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.BusinessType;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * @Author: Huyang
 * @Date: 2019/11/11
 */
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     * @return
     */
    public String title() default "";
    
    /**
     *功能
     * @return
     */
    public BusinessType businessType() default BusinessType.OTHER;
    
    /**
     *操作人类别
     * @return
     */
    public OperatorType operatorType() default OperatorType.MANAGE;
    
    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;
}
