package com.sunny.task.core.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

/**
 * @author sunny
 * @className com.sunny.task.core.common.utils.SpringBeanInstanceAccessor
 * @date 2017-12-27 19:32
 * @description: spring 外包容器获取bean
 */
public class SpringBeanInstanceAccessor implements BeanFactoryAware {

    private static BeanFactory factory;

    /**
     * 获取指定名称的Bean
     *
     * @param beanName
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Object getBean(String beanName, Class<T> clazz) {
        return factory.getBean(beanName, clazz);
    }

    /**
     * 获取指定类型的Bean
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Object getBean(Class<T> clazz) {
        return factory.getBean(clazz);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        factory = beanFactory;

    }
}
