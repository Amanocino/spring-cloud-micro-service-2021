package com.project.consumer.kafka;

import com.alibaba.fastjson2.JSONObject;
import com.example.springCloudMicroService2021.pojo.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KafkaConsumer {

    /**
     * @Title 指定topic、partition、offset消费
     * @Description 同时监听topic1和topic2，监听topic1的0号分区、topic2的 "0号和1号" 分区，指向1号分区的offset初始值为8
     * @Param [record]
     * @return void
     * 重要：批量与单个消费不可同时
     **/
    @KafkaListener(id = "consumer1",groupId = "felix-group",topics = "big_data_topic1"
//            topicPartitions = {
//            @TopicPartition(topic = "big_data_topic", partitions = { "0" }),
//            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
//    }
    )
    public void onMessage2(ConsumerRecord<?, ?> record) {
        System.out.println("topic:"+record.topic()+"|partition:"+record.partition()+"|offset:"+record.offset()+"|value:"+record.value());
    }

    private long time = 0;

    @KafkaListener(id = "consumer2",groupId = "felix-group", topics = "big_data_topic")
    public void onMessage3(List<ConsumerRecord<?, ?>> records) {
        long starttime = System.nanoTime();
        System.out.println(">>>批量消费一次，records.size()="+records.size());
        for (ConsumerRecord<?, ?> record : records) {
            User user = JSONObject.parseObject(record.value().toString(), User.class);
            System.out.println(user.toString());
        }
        long endtime = System.nanoTime();
        time = time+endtime-starttime;
        System.out.println("累计到当前耗时："+ time + " ns");
    }

    //直接使用对象的用法，同时需要修改生产者及消费者的nacos里的yml配置文件配置的序列化方式
//    @KafkaListener(id = "consumer2",groupId = "felix-group", topics = "big_data_topic")
//    public void onMessage3(List<User> records) {
//        long starttime = System.nanoTime();
//        System.out.println(">>>批量消费一次，records.size()="+records.size());
//        for (User record : records) {
////            User user = record.value();
//            System.out.println(record.toString());
//        }
//        long endtime = System.nanoTime();
//        time = time+endtime-starttime;
//        System.out.println("累计到当前耗时："+ time + " ns");
//    }

}
