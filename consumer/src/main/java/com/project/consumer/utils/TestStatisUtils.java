package com.project.consumer.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TestStatisUtils {
    private static int index;

    public static int getSum() throws InterruptedException {
        int sum = 0;
        for (int i=0;i<10;i++){
            sum += i;
            log.info("{}:{}", Thread.currentThread().getName(), i);
            if (Thread.currentThread().getName().equals("test_Thread_1")){
                Thread.sleep(10);
            }
        }
        return sum;
    }
}
