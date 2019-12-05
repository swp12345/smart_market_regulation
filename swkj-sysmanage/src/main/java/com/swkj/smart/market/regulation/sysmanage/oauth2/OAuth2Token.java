package com.swkj.smart.market.regulation.sysmanage.oauth2;

import lombok.AllArgsConstructor;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by Huyang on 2019/9/24
 */
@AllArgsConstructor
public class OAuth2Token implements AuthenticationToken {
    private static final long serialVersionUID = 1L;
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
