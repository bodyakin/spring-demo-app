package com.bodyiakin.demoaop.runner;


import com.bodyiakin.demoaop.aop.benchmark.BenchmarkMe;
import org.springframework.stereotype.Component;

@Component
public class BusyWorker {

    @BenchmarkMe
    public void doWork() {
        double sin = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sin = Math.sin(Math.toRadians(i));
        }
        System.out.println("Я закончил! Результат: " + sin);
    }
}
