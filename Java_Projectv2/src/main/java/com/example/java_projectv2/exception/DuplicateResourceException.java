package com.example.java_projectv2.exception;


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

