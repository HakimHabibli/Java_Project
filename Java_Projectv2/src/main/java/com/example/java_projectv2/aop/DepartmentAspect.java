package com.example.java_projectv2.aop;



import com.example.java_projectv2.dto.log.LogDto;
import com.example.java_projectv2.producer.LogProducer;
import com.example.java_projectv2.service.log.LogClient;
import com.example.java_projectv2.dto.log.LogLevel;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DepartmentAspect
{
    private final LogClient _log;

    private final LogProducer _logProducer;

    public DepartmentAspect(LogClient log, LogProducer logProducer) {
        _log = log;
        _logProducer = logProducer;
    }

    @Pointcut("execution(* com.example.java_projectv2.service.department.DepartmentServiceImpl.*(..))")
    public void pointCut()
    {}

    @After("pointCut()")
    public void DepartmentAspectAfter()
    {
        LogDto dto = new LogDto();
        dto.setLevel(LogLevel.INFO);
        dto.setMessage("Department Service has been executed successfully");
//        _log.writeLogToLogServiceAsync(dto);
        _logProducer.sendLog(dto);
    }

    @Before("pointCut()")
    public void DepartmentAspectBefore()
    {
        LogDto dto = new LogDto();
        dto.setMessage("Department methods before execution" );
        dto.setLevel(LogLevel.INFO);
        _log.writeLogToLogServiceAsync(dto);
    }

}
