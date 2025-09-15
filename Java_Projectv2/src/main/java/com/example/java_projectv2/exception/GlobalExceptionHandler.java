    package com.example.java_projectv2.exception;

    import com.example.java_projectv2.dto.log.LogDto;
    import com.example.java_projectv2.helper.LogHelper;
    import com.example.java_projectv2.service.log.LogClient;
    import com.example.java_projectv2.dto.log.LogLevel;
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
        private final LogHelper logHelper;

        public GlobalExceptionHandler(LogHelper logHelper) {
            this.logHelper = logHelper;
        }

        @ExceptionHandler(value = ResourceNotFoundException.class)
        public ResponseEntity<?> handleResourceNotFoundException
                (ResourceNotFoundException ex, WebRequest request)
        {
            Map<String,Object> map = buildResponse(ex, request);
            logHelper.logMethod(LogLevel.WARNING, ex.getMessage());
            return  new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(value = NotNullException.class)
        public ResponseEntity<?> handleNotNullException
                (NotNullException ex, WebRequest request)
        {
            Map<String,Object> map = buildResponse(ex, request);
            logHelper.logMethod(LogLevel.WARNING, ex.getMessage());
            return  new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = DuplicateResourceException.class)
        public ResponseEntity<?> handleDuplicateResourceException
                (DuplicateResourceException ex, WebRequest request)
        {
            Map<String,Object> map =  buildResponse(ex,request);
            logHelper.logMethod(LogLevel.WARNING, ex.getMessage());
            return  new ResponseEntity<>(map, HttpStatus.CONFLICT);
        }

        @ExceptionHandler(value = BusinessException.class)
        public ResponseEntity<?> handleBusinessException
                (BusinessException ex, WebRequest request)
        {
            Map<String,Object> map =  buildResponse(ex,request);
            logHelper.logMethod(LogLevel.WARNING, ex.getMessage());
            return  new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(value = ValidationException.class)
        public ResponseEntity<?> handleValidationException
                (ValidationException ex, WebRequest request)
        {
            Map<String,Object> map = buildResponse(ex, request);
            logHelper.logMethod(LogLevel.ERROR, ex.getMessage());

            return  new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<?> handleAllExceptions(Exception ex, WebRequest request)
        {
            Map<String,Object> map = buildResponse(ex, request);
            logHelper.logMethod(LogLevel.CRITICAL, ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
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

            logHelper.logMethod(LogLevel.WARNING, ex.getMessage());
            return new ResponseEntity<>(map, HttpStatus.UNPROCESSABLE_ENTITY);
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
