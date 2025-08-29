package com.example.java_projectv2.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public  class  DuplicateResourceException extends RuntimeException
{
    public  DuplicateResourceException(){}
    public  DuplicateResourceException(String message)
    {
        super(message);
    }
    public  DuplicateResourceException(String message,Throwable cause)
    {
        super(message,cause);
    }
}
