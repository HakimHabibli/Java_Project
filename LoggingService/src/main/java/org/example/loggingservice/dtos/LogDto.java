package org.example.loggingservice.dtos;

import org.example.loggingservice.enums.LogLevel;

import java.time.LocalDateTime;

public record LogDto (
     LogLevel level,
     String message,
     LocalDateTime timestamp
){}
