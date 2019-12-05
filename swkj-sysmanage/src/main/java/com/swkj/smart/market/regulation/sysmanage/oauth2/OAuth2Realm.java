package com.swkj.smart.market.regulation.sysmanage.oauth2;

import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.service.ISysUserService;
import com.swkj.smart.market.regulation.sysmanage.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Set;

/**
 * @author  Huyang on 2019/9/24
 */
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        // 用户权限列表，根据用户拥有的权限标识与如 @permission标注的接口对比，决定是否可以调用接口
        Set<String> permsSet = sysUserService.findPermissions(user.getId());
        List<SysRole> userRoles = sysUserService.findUserRoles(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole sysRole : userRoles) {
            info.addRole(sysRole.getRoleName());
        }
        info.setStringPermissions(permsSet);
        return info;
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getPrincipal();
        Claims claims = jwtUtil.parseJWT(token);
        String mobile = claims.getSubject();
        String redisToken = (String) redisTemplate.opsForValue().get("token_" + mobile);
        if (!redisToken.equals(token)) {
            throw new UnsupportedTokenException("令牌验证失败,请重新登录");
        }
        SysUser user = sysUserService.findUserByMobile(mobile);
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, token, getName());
        return info;
    }
}
