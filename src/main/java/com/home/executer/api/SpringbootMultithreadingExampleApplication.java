package com.home.executer.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringbootMultithreadingExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMultithreadingExampleApplication.class, args);
	}


}
