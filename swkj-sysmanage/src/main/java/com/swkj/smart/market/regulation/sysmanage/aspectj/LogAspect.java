package com.swkj.smart.market.regulation.sysmanage.aspectj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log;
import com.swkj.smart.market.regulation.sysmanage.aspectj.enums.BusinessStatus;
import com.swkj.smart.market.regulation.sysmanage.manager.AsyncFactory;
import com.swkj.smart.market.regulation.sysmanage.manager.AsyncManager;
import com.swkj.smart.market.regulation.model.SysOperLog;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.service.ISysDeptService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 操作日志记录处理
 *
 * @Author: Huyang
 * @Date: 2019/11/12
 */

@Aspect
@Component
public class LogAspect {
    
    @Autowired
    private ISysDeptService sysDeptService;
    
    
    public static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
    
    
    /**
     * 配置织入点
     */
    @Pointcut("@annotation(com.swkj.smart.market.regulation.sysmanage.aspectj.annotation.Log)")
    public void logPointCut() {
    }
    
    /**
     * 处理完请求后执行
     *
     * @param joinPoint  切点
     * @param jsonResult
     */
    @AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
    public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
        handleLog(joinPoint, null, jsonResult);
    }
    
    /**
     * 拦截异常操作
     *
     * @param joinPoint 切点
     * @param e         异常
     */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        handleLog(joinPoint, e, null);
    }
    
    private void handleLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
        Log controllerLog = getAnnotationLog(joinPoint);
        if (controllerLog == null) {
            return;
        }
        //获取当前登录用户
        SysUser sysUser = (SysUser) SecurityUtils.getSubject().getPrincipal();
        
        //数据库日志
        SysOperLog operLog = new SysOperLog();
        operLog.setStatus(BusinessStatus.SUCCESS.ordinal());
        //请求的地址
        String ip = SecurityUtils.getSubject().getSession().getHost();
        operLog.setOperIp(ip);
        try {
            //返回参数
            operLog.setJsonResult(StringUtils.substring(objectWriter.writeValueAsString(jsonResult),0,2000));
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            operLog.setOperUrl(request.getRequestURI());
            if (sysUser != null){
                operLog.setDeptName(sysDeptService.findDeptByUser(sysUser.getId()).getDeptName());
            }
            if (e != null){
                operLog.setStatus(BusinessStatus.FAIL.ordinal());
                operLog.setErrorMsg(StringUtils.substring(e.getMessage(),0,2000));
            }
            //方法名
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            operLog.setMethod(className+"."+methodName+"()");
            //请求方式
            operLog.setRequestMethod(request.getMethod());
            //处理设置注解上的参数
            getControllerMethodDescription(controllerLog,operLog,request);
            //保存到数据库
            AsyncManager.me().execute(AsyncFactory.recordOper(operLog));
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     * @param controllerLog
     * @param operLog
     */
    private void getControllerMethodDescription(Log controllerLog, SysOperLog operLog,HttpServletRequest request) throws JsonProcessingException {
        //设置action动作
        operLog.setBusinessType(controllerLog.businessType().ordinal());
        //设置标题
        operLog.setTitle(controllerLog.title());
        //设置操作人
        operLog.setOperatorType(controllerLog.operatorType().ordinal());
        //是否需要保存request，参数和值
        if (controllerLog.isSaveRequestData())
        {
            // 获取参数的信息，传入到数据库中。
            setRequestValue(operLog,request);
        }
    }
    
    /**
     * 获取请求的参数，放到log中
     * @param operLog
     */
    private void setRequestValue(SysOperLog operLog,HttpServletRequest request) throws JsonProcessingException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String params = objectWriter.writeValueAsString(parameterMap);
        operLog.setOperParam(StringUtils.substring(params,0,2000));
    }
    
    /**
     * 是否存在注解，如果存在就获取
     *
     * @param joinPoint
     * @return
     */
    private Log getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        if (method != null) {
            return method.getAnnotation(Log.class);
        }
        return null;
    }
}
