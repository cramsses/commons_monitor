package com.bancosabadell.monitorAmbientes.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@Configuration
public class ThreadConfig {
	
	private static final int CORE_POOL_SIZE = 8;
	private static final int MAX_POOL_SIZE  = 60;
	
    @Bean
    public TaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(CORE_POOL_SIZE);
        executor.setMaxPoolSize(MAX_POOL_SIZE);
        executor.setThreadNamePrefix("monitor_thread");
        executor.initialize();
        return executor;
    }
}