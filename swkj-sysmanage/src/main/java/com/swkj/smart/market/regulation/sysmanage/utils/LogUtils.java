package com.swkj.smart.market.regulation.sysmanage.utils;

/**
 * 处理并记录日志文件
 * 
 * @author huyang
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
