package com.bodyiakin.demoaop.runner;

import com.bodyiakin.demoaop.async.SomeGateway;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringRunner implements ApplicationRunner {
    private final BusyWorker busyWorker;
    private final SomeGateway gateway;

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        final CompletableFuture<String> future = gateway.sendMessage();

        final String response = future.get();
        log.info("Got {}", response);

        busyWorker.doWork();
    }
}
