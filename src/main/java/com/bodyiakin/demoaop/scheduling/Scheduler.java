package com.bodyiakin.demoaop.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 1000)
    public void schedule() {
        System.out.println("Oh hi!");
    }
}
