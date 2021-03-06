package com.sunny.task.core.config;

import org.springframework.context.annotation.Import;

/**
 * @author sunny
 * @className com.sunny.task.core.config.TaskManageConfig
 * @date 2017-10-16 10:44
 * @description:
 */
@Import({AppWebMvcConfig.class, DataSourceConfig.class, MyBatisConfig.class, TaskFilter.class, SpringBeanInstanceAccessor.class})
public class TaskManageConfig {
}
