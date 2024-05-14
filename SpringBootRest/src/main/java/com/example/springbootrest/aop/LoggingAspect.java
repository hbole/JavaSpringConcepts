package com.example.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // return type, class-name.method-name(args)
    @Before("execution(* com.example.springbootrest.services.JobService.getJob(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logger.info("Method Called " + joinPoint.getSignature());
    }

    @After("execution (* com.example.springbootrest.services.JobService.getJob(..)) || execution(* com.example.springbootrest.services.JobService.updateJob(..))")
    public void logMethodExecuted(JoinPoint jp) {
        logger.info("Method Executed "+jp.getSignature().getName());
    }


    @AfterThrowing("execution (* com.example.springbootrest.services.JobService.getJob(..)) || execution(* com.example.springbootrest.services.JobService.updateJob(..))")
    public void logMethodCrashed(JoinPoint jp) {
        logger.info("Method has some issues "+jp.getSignature().getName());
    }



    @AfterReturning("execution (* com.example.springbootrest.services.JobService.getJob(..)) || execution(* com.example.springbootrest.services.JobService.updateJob(..))")
    public void logMethodExecutedSuccess(JoinPoint jp) {
        logger.info("Method Executed Successfully "+jp.getSignature().getName());
    }
}
