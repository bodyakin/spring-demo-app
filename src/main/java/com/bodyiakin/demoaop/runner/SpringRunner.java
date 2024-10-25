package com.bodyiakin.demoaop.runner;

import com.bodyiakin.demoaop.async.SomeGateway;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
@RequiredArgsConstructor
public class SpringRunner implements ApplicationRunner {
    private final Worker busyWorker;
    private final SomeGateway gateway;

    @SneakyThrows
    @Override
    public void run(ApplicationArguments args) {
        final CompletableFuture<String> future1 = gateway.sendMessage();
        final CompletableFuture<String> future2 = gateway.sendMessage();
        final CompletableFuture<String> future3 = gateway.sendMessage();
        final CompletableFuture<String> future4 = gateway.sendMessage();
        final CompletableFuture<String> future5 = gateway.sendMessage();

        final List<String> collect = Stream.of(future1, future2, future3, future4, future5)
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        log.info("Final result {}", collect);

        busyWorker.doWork();
    }
}
