package com.yongyongwang.file.manager.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @apiNote yongyongwang
 *
 * @email 1947920597@qq.com
 *
 * @desc:配置tomcat资源映射
 *
 * @// TODO: 2021/4/16
 */
@Configuration
public class TomcatConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/smile/**").addResourceLocations("file:C:\\smile\\");
    }
}
