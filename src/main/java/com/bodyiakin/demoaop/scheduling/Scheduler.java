package com.bodyiakin.demoaop.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 15000)
    @Scheduled(cron = "0 * * * * MON-FRI")
    public void schedule() {
        System.out.println("Oh hi!");
    }
}
