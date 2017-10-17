package com.sunny.task;

import com.sunny.task.core.config.TaskConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration //开启自动注入bean
@MapperScan("com.sunny.task.**.mapper")
@Import({/*Swagger2.class,*/ TaskConfig.class})
public class TaskManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManageApplication.class, args);
	}
}
