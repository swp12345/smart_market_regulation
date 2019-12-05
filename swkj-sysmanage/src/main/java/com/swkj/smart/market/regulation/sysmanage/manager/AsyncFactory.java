package com.swkj.smart.market.regulation.sysmanage.manager;

import com.swkj.smart.market.regulation.model.SysLogininfor;
import com.swkj.smart.market.regulation.model.SysOperLog;
import com.swkj.smart.market.regulation.sysmanage.service.ISysLogininforService;
import com.swkj.smart.market.regulation.sysmanage.service.ISysOperLogService;
import com.swkj.smart.market.regulation.sysmanage.utils.AddressUtils;
import com.swkj.smart.market.regulation.sysmanage.utils.LogUtils;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.sysmanage.utils.SpringUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 *
 * @author huyang
 */
@Component
public class AsyncFactory {
    
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");
    
    /**
     * 操作日志记录
     *
     * @param operLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final SysOperLog operLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                operLog.setOperLocation(AddressUtils.getRealAddressByIP(operLog.getOperIp()));
                SpringUtils.getBean(ISysOperLogService.class).save(operLog);
            }
        };
    }
    
    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message, final Object... args) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        final UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        final String ip = SecurityUtils.getSubject().getSession().getHost();
        return new TimerTask() {
            @Override
            public void run() {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setLoginName(username);
                logininfor.setIpaddr(ip.equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : ip);
                logininfor.setMsg(message);
                logininfor.setLoginLocation(address);
                logininfor.setLoginTime(new Date());
                // 日志状态
                if (Customize.LOGIN_SUCCESS.equals(status) || Customize.LOGOUT.equals(status)) {
                    logininfor.setStatus(Customize.SUCCESS);
                } else if (Customize.LOGIN_FAIL.equals(status)) {
                    logininfor.setStatus(Customize.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(ISysLogininforService.class).save(logininfor);
            }
        };
    }
    
}
