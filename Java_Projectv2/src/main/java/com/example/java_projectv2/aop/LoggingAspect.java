package com.example.java_projectv2.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect
{
    @Pointcut("execution(* com.example.java_projectv2.service.EmployeeService.*(..))")
    public void employeeMethods()
    {
    }

    @Before("employeeMethods()")
    public void beforeEmployeeMethods(JoinPoint joinPoint)
    {
        System.out.println("Before Employee Methods" + joinPoint.getSignature().getName());
    }


    @AfterReturning("employeeMethods()")
    public void afterEmployeeMethods(JoinPoint joinPoint) {
        System.out.println("Employee method executed successfully: " + joinPoint.getSignature().getName());
    }
}
