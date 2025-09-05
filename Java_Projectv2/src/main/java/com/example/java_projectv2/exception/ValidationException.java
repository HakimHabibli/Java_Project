package com.example.java_projectv2.exception;

//TODO BUSINESS Logic write in department entity
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
