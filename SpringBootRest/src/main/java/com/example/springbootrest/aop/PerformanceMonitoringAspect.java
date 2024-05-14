package com.example.springbootrest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {
    private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);

}
