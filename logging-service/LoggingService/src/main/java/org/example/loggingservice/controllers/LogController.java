package org.example.loggingservice.controllers;

import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.example.loggingservice.repositories.LogRepository;
import org.example.loggingservice.services.LogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController
{
    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping("/logs/byLevel")
    public List<Log> getLogsByLevel(@RequestParam LogLevel level) {
        return logService.getLogsByLevel(level);
    }
}
