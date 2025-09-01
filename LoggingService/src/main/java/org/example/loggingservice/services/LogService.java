package org.example.loggingservice.services;


import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.example.loggingservice.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;
    public LogService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }


    public Log createLog(Log log)
    {
        return logRepository.save(log);
    }

    public List<Log> getLogsByLevel(LogLevel level)
    {
        return logRepository.findByLevel(level);
    }

    public List<Log> getCriticalLogs() {
        return logRepository.findLogsWithCustomFilter("CRITICAL");
    }
}