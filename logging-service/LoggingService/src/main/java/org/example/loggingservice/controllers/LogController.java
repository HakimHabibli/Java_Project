package org.example.loggingservice.controllers;

import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.example.loggingservice.services.LogService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/logs/create")
    public Log createLog(@RequestBody Log log)
    {
        return logService.createLog(log);
    }
}
