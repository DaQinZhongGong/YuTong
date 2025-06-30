package com.yutongvuefast.project.system.controller;

import com.yutongvuefast.common.utils.StringUtils;
import com.yutongvuefast.framework.security.RegisterBody;
import com.yutongvuefast.framework.security.service.SysRegisterService;
import com.yutongvuefast.framework.web.controller.BaseController;
import com.yutongvuefast.framework.web.domain.AjaxResult;
import com.yutongvuefast.project.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 注册验证
 */
@RestController
public class SysRegisterController extends BaseController {
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user) {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser")))) {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
