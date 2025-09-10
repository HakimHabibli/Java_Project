package com.example.java_projectv2.exception;

public class BusinessException extends RuntimeException
{
    public BusinessException(){}
    public BusinessException(String message)
    {
        super(message);
    }
    public BusinessException(Throwable cause)
    {
        super(cause);
    }
}
