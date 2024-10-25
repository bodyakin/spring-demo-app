package com.bodyiakin.demoaop.configuration.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("async")
public class AsyncConfigProperties {
    private int poolSize;
    private int maxPoolSize;
    private int queueCapacity;
    private String threadNamePrefix;
}
