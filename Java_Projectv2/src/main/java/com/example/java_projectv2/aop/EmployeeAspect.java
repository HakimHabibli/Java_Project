package com.example.java_projectv2.aop;


import com.example.java_projectv2.dto.log.LogDto;
import com.example.java_projectv2.service.log.LogClient;
import com.example.java_projectv2.dto.log.LogLevel;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeAspect
{
    private final LogClient log;

    public EmployeeAspect(LogClient log) {
        this.log = log;
    }
    @Pointcut("execution(* com.example.java_projectv2.service.employee.EmployeeService.*(..))")
    public void employeeMethods(){
    }



    @Before("employeeMethods()")
    public void beforeEmployeeMethods(JoinPoint joinPoint)
    {
        LogDto dto = new LogDto();
        dto.setMessage("Employee methods before execution");
        dto.setLevel(LogLevel.INFO);
        log.writeLogToLogServiceAsync(dto);
    }


    @AfterReturning("employeeMethods()")
    public void afterEmployeeMethods(JoinPoint joinPoint)
    {
        LogDto dto = new LogDto()
        {
            {
                setMessage("Employee methods after execution");
                setLevel(LogLevel.INFO);
            }
        };
        log.writeLogToLogServiceAsync(dto);
    }
}
