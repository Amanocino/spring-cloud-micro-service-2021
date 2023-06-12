package com.project.consumer.utils;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Callable;


@SpringBootTest
class TestStatisUtilsTest {
    @Resource
    private ThreadPoolTaskExecutor testPoolTaskExecutor;

    @Test
    public void test() throws InterruptedException {
        for (int i=0;i<10;i++) {
            testPoolTaskExecutor.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    TestStatisUtils.getSum();
                    return null;
                }

            });
        }
        Thread.sleep(130);
    }
}