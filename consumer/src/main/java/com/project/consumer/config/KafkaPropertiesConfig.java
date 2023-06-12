package com.project.consumer.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "kafka.consumer")
@Data
@ToString
public class KafkaPropertiesConfig {
    private int limit;
}
