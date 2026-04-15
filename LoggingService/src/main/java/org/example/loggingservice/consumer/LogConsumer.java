package org.example.loggingservice.consumer;


import org.example.loggingservice.config.RabbitMQConfig;
import org.example.loggingservice.dtos.LogDto;
import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.example.loggingservice.services.EmailService;
import org.example.loggingservice.services.LogService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class LogConsumer
{
    private final LogService logService;
    private final EmailService emailService;

    public LogConsumer(LogService logService, EmailService emailService) {
        this.logService = logService;
        this.emailService = emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.LOG_QUEUE)
    public void receiveLogMessage(LogDto dto) {
        Log log = new Log();
        log.setMessage(dto.message());
        log.setLevel(dto.level());
        logService.createLog(log);
        System.out.println("Received Log Message: " + dto.message());
    }
}
