package com.example.java_projectv2.aop;


import com.example.java_projectv2.aop.helper.Log;
import com.example.java_projectv2.aop.helper.LogDto;
import com.example.java_projectv2.aop.helper.LogLevel;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class DepartmentAspect
{
    private final Log _log;

    public DepartmentAspect(Log log) {
        _log = log;
    }

    @Pointcut("execution(* com.example.java_projectv2.service.DepartmentServiceImpl.*(..))")
    public void pointCut()
    {}

    @After("pointCut()")
    public void DepartmentAspectAfter()
    {
        LogDto dto = new LogDto();
        dto.setLevel(LogLevel.INFO);
        dto.setMessage("Department Service has been executed successfully");
//        dto.setTimestamp(new Date());
        _log.writeLogToLogService(dto);
    }

    @Before("pointCut()")
    public void DepartmentAspectBefore()
    {
        _log.writeLogToFile("Department methods before execution" + new Date());
    }

}
