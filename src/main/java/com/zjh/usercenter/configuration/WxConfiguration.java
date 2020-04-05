package com.zjh.usercenter.configuration;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author zhaojh
 * @CreateTime 2020/3/11 15:52
 * @Version 1.0
 * @Desc 配置类
 **/
@Configuration
public class WxConfiguration {
    @Bean
    public WxMaConfig wxMaConfig() {
        WxMaDefaultConfigImpl config = new WxMaDefaultConfigImpl();
        config.setAppid("wx9d79ffd01c6b37f2");
        config.setSecret("72834ee685d97d5fd37b78567ec7c923");
        return config;
    }

    @Bean
    public WxMaService wxMaService(WxMaConfig config) {
        WxMaServiceImpl service = new WxMaServiceImpl();
        service.setWxMaConfig(config);
        return service;
    }
}

