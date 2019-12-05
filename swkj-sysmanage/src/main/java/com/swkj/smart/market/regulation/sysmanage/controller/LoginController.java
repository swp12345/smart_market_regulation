package com.swkj.smart.market.regulation.sysmanage.controller;

import com.swkj.smart.market.regulation.dto.HttpResult;
import com.swkj.smart.market.regulation.dto.LoginBean;
import com.swkj.smart.market.regulation.model.SysRole;
import com.swkj.smart.market.regulation.model.SysUser;
import com.swkj.smart.market.regulation.sysmanage.manager.AsyncFactory;
import com.swkj.smart.market.regulation.sysmanage.manager.AsyncManager;
import com.swkj.smart.market.regulation.sysmanage.service.ISysRoleService;
import com.swkj.smart.market.regulation.sysmanage.service.ISysUserService;
import com.swkj.smart.market.regulation.sysmanage.utils.JwtUtil;
import com.swkj.smart.market.regulation.util.Customize;
import com.swkj.smart.market.regulation.util.SendSmsUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author  Huyang on 2019/9/24
 */
@RestController
public class LoginController {

    @Autowired
    private ISysUserService sysUserService;

    @Autowired
    private ISysRoleService sysRoleService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private SendSmsUtil sendSmsUtil;

    @Autowired
    private JwtUtil jwtUtil;

    private static final long TOKEN_EXPIRE = 15;

    private static final long CAPTCHA_EXPIRE = 10;

    @PostMapping("/login")
    @ApiOperation(value = "登录")
    public HttpResult login(@RequestBody LoginBean loginBean) {
        String mobile = loginBean.getMobile();
        String captcha = loginBean.getCaptcha();
        // 用户信息
        SysUser user = sysUserService.findUserByMobile(mobile);
        // 账号不存在、密码错误
        if (user == null) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(mobile, Customize.FAIL,"账号不存在"));
            return HttpResult.error("账号不存在");
        }
        String redisCaptcha = (String) redisTemplate.opsForValue().get("loginCaptcha_" + mobile);
        if (!captcha.equals(redisCaptcha)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(mobile, Customize.FAIL,"验证码错误"));
            return HttpResult.error("验证码错误");
        }
        SysRole role = sysRoleService.findUserByMobile(mobile);
        // 生成token，并保存到数据库
        String token = jwtUtil.createJWT(user.getId(), mobile, role.getRoleName());
        redisTemplate.opsForValue().set("token_" + mobile, token, TOKEN_EXPIRE, TimeUnit.MINUTES);
        Map<String, Object> map = new HashMap<>(16);
        map.put("role", role.getRoleName());
        map.put("token", token);
        AsyncManager.me().execute(AsyncFactory.recordLogininfor(mobile, Customize.SUCCESS,"登录成功"));
        return HttpResult.ok(map);
    }

    @PostMapping("/sendSms/{mobile}")
    @ApiOperation(value = "发送短信")
    public HttpResult sendSms(@PathVariable String mobile) {
        //生产6位随机数
        String captcha = RandomStringUtils.randomNumeric(6);
        //缓存中放一份
        redisTemplate.opsForValue().set("loginCaptcha_" + mobile, captcha, CAPTCHA_EXPIRE, TimeUnit.MINUTES);
        //给用户发一份
        Map<String, String> map = new HashMap<>();
        map.put("mobile", mobile);
        map.put("captcha", captcha);
        System.out.println(captcha);
        //发送短信
        SysUser user = sysUserService.findUserByMobile(mobile);
        if (user == null) {
            return HttpResult.error("手机号有误，请确认手机号");
        }
        sendSmsUtil.sendSms(mobile, captcha);
        
        return HttpResult.ok(captcha);
    }

    @GetMapping("/logout")
    @ApiOperation(value = "登出")
    public HttpResult logout() {
        SecurityUtils.getSubject().logout();
        return HttpResult.ok();
    }
}
