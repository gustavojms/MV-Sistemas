package com.mv.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiMethodInvalidErrorMessage extends ApiErrorMessage {

    private List<ApiFieldErrorMessage> fieldErrors = new ArrayList<>();

    public ApiMethodInvalidErrorMessage(Integer status, LocalDateTime timestamp, String error, String message, List<ApiFieldErrorMessage> fieldErrors) {
        super(status, timestamp, error, message);
        this.fieldErrors = fieldErrors;
    }

    public ApiMethodInvalidErrorMessage() {}

    public List<ApiFieldErrorMessage> getFieldErrors() {
        return fieldErrors;
    }

    public void addError(String fieldName, String cause) {
        this.fieldErrors.add(new ApiFieldErrorMessage(fieldName, cause));
    }
}
