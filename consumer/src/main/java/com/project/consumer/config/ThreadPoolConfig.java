package com.project.consumer.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
@ConfigurationProperties(prefix = "testthread.pool")
@Data
public class ThreadPoolConfig {
    private int corePoolSize;
    private int maxPoolSize;
    private int keepAliveTime;

    @Bean("TestThreadPoolExecutor")
    public Executor testThreadPoolExecutor(){
//        ThreadPoolExecutor();
//        ThreadPoolExecutor threadPoolTaskExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime,
//               TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(corePoolSize);
        threadPoolTaskExecutor.setMaxPoolSize(maxPoolSize);
        threadPoolTaskExecutor.setKeepAliveSeconds(keepAliveTime);
        threadPoolTaskExecutor.setThreadNamePrefix("test_Thread_");
        threadPoolTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        threadPoolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

}
