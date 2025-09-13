package com.example.java_projectv2.aop;


import com.example.java_projectv2.aop.helper.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

@Component
@Aspect
public class EmployeeAspect
{
    private final Log log;

    public EmployeeAspect(Log log) {
        this.log = log;
    }


    @Pointcut("execution(* com.example.java_projectv2.service.EmployeeService.*(..))")
    public void employeeMethods()
    {
        log.writeLogToFile("Employee methods before execution" + new Date());
    }

    @Before("employeeMethods()")
    public void beforeEmployeeMethods(JoinPoint joinPoint)
    {
        log.writeLogToFile("Before Employee Methods" + joinPoint.getSignature().getName());
    }


    @AfterReturning("employeeMethods()")
    public void afterEmployeeMethods(JoinPoint joinPoint) {
        log.writeLogToFile("Employee method executed successfully: " + joinPoint.getSignature().getName());
    }
}
