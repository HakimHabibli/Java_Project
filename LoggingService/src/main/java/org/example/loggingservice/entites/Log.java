package org.example.loggingservice.entites;


import lombok.Getter;
import lombok.Setter;
import org.example.loggingservice.enums.LogLevel;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Getter
@Setter
public class Log {

    @Id
    private String id;

    private LogLevel level;
    private String message;
    private LocalDateTime timestamp;

    public Log() {
        this.timestamp = LocalDateTime.now();
    }
    public Log(LogLevel level, String message)
    {
     this.level = level;
     this.message = message;
     this.timestamp = LocalDateTime.now();
    }
}
