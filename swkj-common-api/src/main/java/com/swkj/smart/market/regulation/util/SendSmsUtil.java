package com.swkj.smart.market.regulation.util;

import com.cloopen.rest.sdk.CCPRestSDK;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Set;

/**
 * @author  by huyang on 2019/10/11
 */
@Component
public class SendSmsUtil {
    @Value("${accountSid}")
    private String accountSid;

    @Value("${accountToken}")
    private String accountToken;
    
    @Value("${appId}")
    private String appId;
    
    @Value("${templateId}")
    private String templateId;
    
    private static final String STATUSCODE = "000000";

    private static final String RESULT_GET = "statusCode";
    public void sendSms(String mobile,String captcha) {
        HashMap<String, Object> result = null;
        // 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
        CCPRestSDK restAPI = new CCPRestSDK();
        restAPI.init("app.cloopen.com", "8883");
        // 初始化主帐号和主帐号TOKEN
        restAPI.setAccount(accountSid, accountToken);
        // 初始化应用ID
        restAPI.setAppId(appId);
        result = restAPI.sendTemplateSMS(mobile,templateId ,new String[]{captcha,"10"});
    
        System.out.println("SDKTestSendTemplateSMS result=" + result);
     
        if(STATUSCODE.equals(result.get(RESULT_GET))){
            //正常返回输出data包体信息（map）
            HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
            Set<String> keySet = data.keySet();
            for(String key:keySet){
                Object object = data.get(key);
                System.out.println(key +" = "+object);
            }
        }else{
            //异常返回输出错误码和错误信息
            System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
        }
    }
}
