package com.imao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class ImaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImaoApplication.class, args);
	}
}
