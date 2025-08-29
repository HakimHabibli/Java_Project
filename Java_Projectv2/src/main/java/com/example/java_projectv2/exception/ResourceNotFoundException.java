package com.example.java_projectv2.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(){}
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
    public ResourceNotFoundException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
