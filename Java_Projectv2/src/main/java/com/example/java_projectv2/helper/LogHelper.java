package com.example.java_projectv2.helper;


import com.example.java_projectv2.dto.log.LogDto;
import com.example.java_projectv2.dto.log.LogLevel;
import com.example.java_projectv2.service.log.LogClient;
import org.springframework.stereotype.Component;



@Component

public  class LogHelper
{
    private final LogClient client;

    public LogHelper(LogClient client) {
        this.client = client;
    }

    /**
     * Sends a log message asynchronously to the Log service.
     *
     * @param level   the severity level of the log (INFO, WARNING, ERROR, etc.)
     * @param message the log message content
     *
     */
    public void logMethod(LogLevel level, String message) {
        LogDto dto = new LogDto();
        dto.setLevel(level);
        dto.setMessage(message);
        client.writeLogToLogServiceAsync(dto);
    }
}
