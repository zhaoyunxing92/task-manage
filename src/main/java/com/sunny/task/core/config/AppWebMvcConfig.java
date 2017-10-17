package com.sunny.task.core.config;

import com.google.gson.GsonBuilder;
import com.sunny.task.core.interceptor.TaskInterceptor;
import org.springframework.http.CacheControl;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
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
public class AppWebMvcConfig extends WebMvcConfigurerAdapter {
    private static String UNIFIED_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    /**
     * 跨域配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .maxAge(3600);

    }

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
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter); // 删除MappingJackson2HttpMessageConverter
        GsonHttpMessageConverter gsonHttpMessageConverter = new GsonHttpMessageConverter();
        GsonBuilder gsonBuilder = new GsonBuilder();
       // gsonBuilder.registerTypeAdapter(BigDecimal.class, BIG_DECIMAL);
        gsonBuilder.setDateFormat(UNIFIED_DATE_FORMAT);
       // gsonBuilder.excludeFieldsWithModifiers(Modifier.PROTECTED);
        gsonHttpMessageConverter.setGson(gsonBuilder.create());
        converters.add(gsonHttpMessageConverter); // 添加GsonHttpMessageConverter
    }
}
