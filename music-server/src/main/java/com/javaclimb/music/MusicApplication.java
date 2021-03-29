package com.javaclimb.music;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
* 热更新、热加载
* 1、Ctrl+Shift+A -->搜索registry,找到Registry...,注意是带三个点的那个，然后找到compiler.automake.allow.when.app.running，勾选
* 2、执行快捷键Ctrl+F9才进行热加载
*
* */
@SpringBootApplication
@MapperScan("com.javaclimb.music.dao")
public class MusicApplication extends SpringBootServletInitializer implements WebMvcConfigurer{

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MusicApplication.class);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }

}
