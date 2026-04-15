package com.example.java_projectv2.helper;


import com.example.java_projectv2.dto.log.LogDto;
import com.example.java_projectv2.dto.log.LogLevel;
import com.example.java_projectv2.producer.LogProducer;
import com.example.java_projectv2.service.log.LogClient;
import org.springframework.stereotype.Component;



@Component
public  class LoggingFacade
{
    private final LogClient client;
    private final LogProducer producer;

    public LoggingFacade(LogClient client, LogProducer producer) {
        this.client = client;
        this.producer = producer;
    }

    /**
     * Sends a log message synchronous to the Log Service
     * @param level      the severity level of the log (INFO, WARNING, ERROR, etc.)
     * @param message    the log message content
     */
    public void logWithClient(LogLevel level, String message){
        LogDto dto = new LogDto();
        dto.setLevel(level);
        dto.setMessage(message);
        client.writeLogToLogServiceAsync(dto);
    }

    /**
     * Sends a log message asynchronously to the RabbitMQ .
     *
     * @param level   the severity level of the log (INFO, WARNING, ERROR, etc.)
     * @param message the log message content
     *
     */
    public void logMethod(LogLevel level, String message) {
        LogDto dto = new LogDto();
        dto.setLevel(level);
        dto.setMessage(message);
        producer.sendLog(dto);
    }

}
