package com.yutongvuefast.project.system.controller;

import com.yutongvuefast.common.utils.StringUtils;
import com.yutongvuefast.framework.config.YuTongVueFastConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 */
@RestController
public class SysIndexController {
    /**
     * 系统基础配置
     */
    @Autowired
    private YuTongVueFastConfig yuTongVueFastConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index() {
        return StringUtils.format("欢迎使用 {} 后台管理框架，当前版本：v{}，请通过前端地址访问。", yuTongVueFastConfig.getName(), yuTongVueFastConfig.getVersion());
    }
}
