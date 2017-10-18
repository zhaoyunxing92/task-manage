package com.sunny.task;

import com.sunny.task.core.config.TaskManageConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableAutoConfiguration //开启自动注入bean
@MapperScan("com.sunny.task.**.mapper")
@Import({/*Swagger2.class,*/ TaskManageConfig.class})
@EnableWebSecurity  //开启spring security
public class TaskManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskManageApplication.class, args);
    }
}
