package com.bodyiakin.demoaop.aop;

import com.bodyiakin.demoaop.aop.benchmark.BenchmarkAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AopConfiguration {

    @Bean
    public BenchmarkAspect benchmarkAspect() {
        return new BenchmarkAspect();
    }
}
