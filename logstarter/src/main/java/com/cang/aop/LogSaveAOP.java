package com.cang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogSaveAOP {

    @Pointcut("@annotation(com.cang.annotation.SaveLog)")
    void log(){}

    @Around("log()")
    public Object doAround(ProceedingJoinPoint joinPoint){
        try {
            System.out.println("log test...");
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "test";
    }
}
