package com.swkj.smart.market.regulation.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Created by Huyang on 2019/9/24
 * @author 81509
 */
@Getter
@Setter
public class HttpResult {
    private int code;
    private String msg;
    private Object data;

    public static HttpResult error(){
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(),"未知异常，请联系管理员");
    }

    public static HttpResult error(String msg) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

    public static HttpResult error(int code,String msg){
        HttpResult result = new HttpResult();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setCode(200);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setCode(200);
        r.setData(data);
        return r;
    }
    public static HttpResult ok() {
        return new HttpResult();
    }
}
