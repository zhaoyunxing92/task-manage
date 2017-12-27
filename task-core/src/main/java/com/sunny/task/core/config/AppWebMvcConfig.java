package com.sunny.task.core.config;

import com.google.gson.GsonBuilder;
import com.sunny.task.core.interceptor.TaskInterceptor;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.WebContentInterceptor;

import java.util.List;

/**
 * @author sunny
 * @className com.sunny.bugmanage.common.config.AppWebMvcConfig
 * @date 2017-07-04 16:27
 * @description: AppWebMvcConfig
 */
//@EnableWebMvc
public class AppWebMvcConfig extends WebMvcConfigurerAdapter {
    
    /**
     * 跨域配置
     *
     * @param registry
     */
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("http://192.168.1.105:8701")
//                .allowCredentials(true)
//                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
//                .maxAge(3600);
//
//    }

    /**
     * 拦截器配置
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebContentInterceptor webContentInterceptor = new WebContentInterceptor();
        CacheControl nocache = CacheControl.noCache();
        webContentInterceptor.addCacheMapping(nocache, "/**");
        registry.addInterceptor(webContentInterceptor);
        //添加拦截器
        registry.addInterceptor(new TaskInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);

    }

    /**
     * url 参数配置
     *
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        //url支持 sunny.com 参数
        configurer.setUseSuffixPatternMatch(false);
    }

    /**
     * 添加gson解析器（过滤返回的数据排除为null的）
     * <a href="http://blog.gelu.me/2017/spring-boot-uses-gson-to-replace-jackson/">参考地址</a>
     *
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        String unifiedDateFormat = "yyyy-MM-dd HH:mm:ss";
        // 删除MappingJackson2HttpMessageConverter
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(unifiedDateFormat);
        gsonHttpMessageConverter.setGson(gsonBuilder.create());
        // 添加GsonHttpMessageConverter
        converters.add(gsonHttpMessageConverter);
    }
}
