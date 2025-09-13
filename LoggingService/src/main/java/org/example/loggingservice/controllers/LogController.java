package org.example.loggingservice.controllers;

import org.example.loggingservice.dtos.LogDto;
import org.example.loggingservice.entites.Log;
import org.example.loggingservice.enums.LogLevel;
import org.example.loggingservice.services.LogService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<LogDto>> getLogsByLevel(@RequestParam LogLevel level) {
        return ResponseEntity.ok(logService.getLogsByLevel(level));
    }

    @GetMapping("/logs/getall")
    public ResponseEntity<List<LogDto>> getAllLogs()
    {

        return ResponseEntity.ok(logService.getAllLogs());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Log>> getLogsWithFilter(@RequestParam String filter) {
        return ResponseEntity.ok(logService.getLogsWithCustomFilter(filter));
    }

    @PostMapping("/logs/create")
    public ResponseEntity<Log> createLog(@RequestBody Log log)
    {
        return ResponseEntity.ok(logService.createLog(log));
    }


}
