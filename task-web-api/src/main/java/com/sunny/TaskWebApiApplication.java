package com.sunny;

import com.sunny.task.config.TaskManageConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAutoConfiguration //开启自动注入bean
@MapperScan("com.sunny.task.mapper")
@Import(TaskManageConfig.class)
@EnableAsync  //开启异步执行
public class TaskWebApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskWebApiApplication.class, args);
	}
}
