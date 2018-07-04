package com.imao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
@EnableScheduling
@EnableAsync
@MapperScan({"com.imao.modules.dao"})
public class ImaoApplication{

	public static void main(String[] args) {
		SpringApplication.run(ImaoApplication.class, args);
	}
}
