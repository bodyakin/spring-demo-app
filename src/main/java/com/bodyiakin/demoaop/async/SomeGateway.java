package com.bodyiakin.demoaop.async;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class SomeGateway {
    private final RestTemplate myRestTemplate;

    @SneakyThrows
    @Async("threadPoolTaskExecutor")
    public CompletableFuture<String> sendMessage() {
        log.info("Send request from thread {}", Thread.currentThread().getName());
        String result = myRestTemplate.getForObject("https://httpbin.org/headers", String.class);
        log.info("Received result [{}]", result);
        // Artificial delay
        Thread.sleep(5000L);
        return CompletableFuture.completedFuture(result);
    }

}
