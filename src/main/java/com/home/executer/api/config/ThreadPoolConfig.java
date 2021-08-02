package com.home.executer.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


@Configuration
public class ThreadPoolConfig {

    @Bean
    public Executor taskExcuter(){
        ThreadPoolTaskExecutor executor= new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(3);
        executor.setQueueCapacity(100);
        executor.setThreadNamePrefix("multithreading-");
        executor.initialize();
        return executor;
    }
}
