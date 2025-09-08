package com.example.java_projectv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException
            (ResourceNotFoundException ex, WebRequest request)
    {
        Map<String,Object> map = buildResponse(ex, request);
        return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicateResourceException.class)
    public ResponseEntity<?> handleDuplicateResourceException
            (DuplicateResourceException ex, WebRequest request)
    {
        Map<String,Object> map =  buildResponse(ex,request);
        return  new ResponseEntity<>(map, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException
            (
                    MethodArgumentNotValidException ex , WebRequest request
            )
    {
        Map<String, Object> map = new HashMap<>();
        map.put("timestamp", new Date());
        map.put("path", request.getDescription(false).replace("uri=", ""));

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        map.put("message", "Validation failed");
        map.put("errors", errors);

        return new ResponseEntity<>(map, HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ResponseEntity<?> handleValidationException
            (ValidationException ex, WebRequest request)
    {
        Map<String,Object> map = buildResponse(ex, request);
        return  new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request)
    {
        Map<String,Object> map = buildResponse(ex, request);
        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private Map<String,Object> buildResponse(Exception ex,WebRequest request)
    {
        Map<String,Object> map = new HashMap<>();
        map.put("message", ex.getMessage());
        map.put("timestamp", new Date());
        map.put("path", request.getDescription(false));
        return  map;
    }
}
