package com.bodyiakin.demoaop.aop.benchmark;

import lombok.SneakyThrows;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class BenchmarkAspect {

    @SneakyThrows
    @Around(value = "@annotation(benchmark)")
    public Object callMethod(ProceedingJoinPoint joinPoint, BenchmarkMe benchmark) {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println(String.format("Time to execution %dms", end - start));
        return result;
    }
}
