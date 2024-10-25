package com.bodyiakin.demoaop.runner;


import com.bodyiakin.demoaop.aop.benchmark.BenchmarkMe;
import org.springframework.stereotype.Component;

@Component
public class BusyWorker implements Worker {

    @Override
    @BenchmarkMe
    public void doWork() {
        double sin = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sin = Math.sin(Math.toRadians(i));
        }
        System.out.println("I have done! Result: " + sin);
    }

}
