package com.sunny.task.core.config;

import com.sunny.task.core.handle.EntryPointUnauthorizedHandler;
import com.sunny.task.core.handle.TaskAccessDeniedHandler;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author sunny
 * @className com.sunny.task.core.config.WebSecurityConfig
 * @date 2017-10-18 09:45
 * @description:
 */
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //.antMatchers("/auth/login").authenticated()
                .anyRequest().permitAll()       // 允许所有请求通过
                .and()
                .csrf()
                .disable()                      // 禁用 Spring Security 自带的跨域处理
                .exceptionHandling()
                .accessDeniedHandler(new TaskAccessDeniedHandler())   //权限不足
                .authenticationEntryPoint(new EntryPointUnauthorizedHandler());   //没有token

    }

}
