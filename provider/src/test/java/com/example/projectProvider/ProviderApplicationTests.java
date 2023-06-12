package com.example.projectProvider;

import com.example.projectProvider.config.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
@Slf4j
class ProviderApplicationTests {
    @Resource
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
        for(int i=0;i<2;i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Boolean result = redisUtil.tryLock("key1", 30, TimeUnit.SECONDS);

                    log.info("first lock result{} {}", finalI, result);
                }
            }).start();
        }

    }

}
