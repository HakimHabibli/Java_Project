package com.example.java_projectv2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ValidationException extends RuntimeException
{
    public ValidationException(){}
    public ValidationException(String message)
    {
        super(message);
    }
    public ValidationException(String message,Throwable cause)
    {
        super(message,cause);
    }
    
}
