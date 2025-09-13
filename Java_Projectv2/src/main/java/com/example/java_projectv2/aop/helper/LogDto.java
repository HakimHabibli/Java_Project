package com.example.java_projectv2.aop.helper;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Getter
@Setter
public class LogDto
{
        @Id
        private String id;

        private LogLevel level;
        private String message;
}

