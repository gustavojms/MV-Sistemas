package com.mv.exceptions;

import java.time.LocalDateTime;

public class ApiErrorMessage {

    private Integer status;
    private LocalDateTime timestamp;
    private String error;
    private String message;

    public ApiErrorMessage(Integer status, LocalDateTime timestamp, String error, String message) {
        this.status = status;
        this.timestamp = timestamp;
        this.error = error;
        this.message = message;
    }

    public ApiErrorMessage() {}

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
