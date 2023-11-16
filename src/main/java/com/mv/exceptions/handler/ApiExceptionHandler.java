package com.mv.exceptions.handler;

import com.mv.exceptions.ApiErrorMessage;
import com.mv.exceptions.ApiMethodInvalidErrorMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrorMessage> handleRuntimeException(RuntimeException exception) {
        ApiErrorMessage apiErrorMessage = new ApiErrorMessage();
        apiErrorMessage.setStatus(500);
        apiErrorMessage.setTimestamp(LocalDateTime.now());
        apiErrorMessage.setMessage(exception.getMessage());
        apiErrorMessage.setError("Internal Server Error");
        return ResponseEntity.status(500).body(apiErrorMessage);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorMessage> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ApiMethodInvalidErrorMessage apiErrorMessage = new ApiMethodInvalidErrorMessage();
        apiErrorMessage.setStatus(400);
        apiErrorMessage.setTimestamp(LocalDateTime.now());
        apiErrorMessage.setMessage(exception.getMessage());
        apiErrorMessage.setError("Internal Server Error");
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            apiErrorMessage.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(500).body(apiErrorMessage);
    }
}
