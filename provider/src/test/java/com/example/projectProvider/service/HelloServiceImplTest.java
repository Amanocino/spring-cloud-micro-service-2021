package com.example.projectProvider.service;

import com.alibaba.fastjson2.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class HelloServiceImplTest {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Test
    public void testSend(){
        for (int i = 0; i < 5000; i++) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("datekey", 20210610);
            map.put("userid", i);
            map.put("salaryAmount", i);
            //向kafka的big_data_topic主题推送数据
            kafkaTemplate.send("big_data_topic", JSONObject.toJSONString(map));
        }
    }

}