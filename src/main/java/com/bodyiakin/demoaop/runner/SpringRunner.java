package com.bodyiakin.demoaop.runner;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpringRunner implements ApplicationRunner {
    private final BusyWorker busyWorker;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        busyWorker.doWork();
    }
}