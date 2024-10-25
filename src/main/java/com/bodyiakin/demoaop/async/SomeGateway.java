package com.bodyiakin.demoaop.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class SomeGateway {
    private final RestTemplate restTemplate;

    public SomeGateway(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @SneakyThrows
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> sendMessage() {
        log.info("Send request from thread {}", Thread.currentThread().getName());
        String results = restTemplate.getForObject("https://httpbin.org/headers", String.class);

        // Artificial delay
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }
}
