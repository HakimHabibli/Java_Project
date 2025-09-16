package org.example.loggingservice.services;


import org.example.loggingservice.dtos.LogDto;
import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.example.loggingservice.mapper.LogMapper;
import org.example.loggingservice.repositories.LogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {
    private final LogRepository logRepository;
    private   final LogMapper logMapper;

    public LogService(LogRepository logRepository, LogMapper logMapper) {
        this.logRepository = logRepository;
        this.logMapper = logMapper;
    }

    public List<LogDto> getAllLogs()
    {
        var result = logRepository.findAll();

        return logMapper.toLogDto(result);
    }

    public Log createLog(Log log)
    {
        return logRepository.save(log);
    }

    public List<LogDto> getLogsByLevel(LogLevel level)
    {
        var entity = logRepository.findByLevel(level);
        return logMapper.toLogDto(entity);
    }

    public List<Log> getCriticalLogs() {
        return logRepository.findLogsWithCustomFilter("CRITICAL");
    }

    public List<Log> getLogsWithCustomFilter(String filter) {
        return logRepository.findLogsWithCustomFilter(filter);
    }
}