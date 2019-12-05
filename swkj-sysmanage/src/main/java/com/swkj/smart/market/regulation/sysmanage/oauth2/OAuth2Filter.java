package com.swkj.smart.market.regulation.sysmanage.oauth2;

import com.alibaba.fastjson.JSONObject;
import com.swkj.smart.market.regulation.dto.HttpResult;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *@author  Huyang
 * on 2019/9/24
 */
public class OAuth2Filter extends AuthenticatingFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        String token = getRequestToken((HttpServletRequest) servletRequest);
        if(StringUtils.isEmpty(token)){
            return null;
        }
        return new OAuth2Token(token);
    }

    private String getRequestToken(HttpServletRequest servletRequest) {
        // 从header中获取token
        String authorization = servletRequest.getHeader("Authorization");
        String token = null;
        // 如果header中不存在token，则从参数中获取token
        if(StringUtils.isEmpty(authorization)){
            authorization = servletRequest.getParameter("Authorization");
        }
        if (authorization.startsWith("Bearer ")) {
            token = authorization.substring(7);
        }
        return token;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        if ("OPTIONS".equals(request.getMethod())){
            //如果跨域中复杂请求的预检请求（OPTIONS类型），因为预检不带token,所以不需要验证token
            return true;
        }
        // 获取请求token，如果token不存在，直接返回401
        String token = getRequestToken(request);
        if(StringUtils.isEmpty(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            HttpResult result = HttpResult.error(HttpStatus.UNAUTHORIZED.value(), "invalid token");
            String json = JSONObject.toJSONString(result);
            httpResponse.getWriter().print(json);
            return false;
        }
        return executeLogin(servletRequest,servletResponse);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json; charset=utf-8");
        Throwable throwable = e.getCause() == null? e: e.getCause();
        HttpResult result = HttpResult.error(HttpStatus.UNAUTHORIZED.value(), throwable.getMessage());
        String json = JSONObject.toJSONString(result);
        try {
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return false;
    }
}
