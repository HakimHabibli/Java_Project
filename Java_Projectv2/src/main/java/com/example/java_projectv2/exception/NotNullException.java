package com.example.java_projectv2.exception;

public class NotNullException extends RuntimeException
{
    public NotNullException(){}
    public NotNullException(String message)
    {
        super(message);
    }
    public NotNullException(Throwable cause)
    {
        super(cause);
    }
    public NotNullException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
