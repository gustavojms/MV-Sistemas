package com.mv.exceptions;

public class ApiFieldErrorMessage {

    private String fieldName;
    private String cause;

    public ApiFieldErrorMessage(String fieldName, String cause) {
        this.fieldName = fieldName;
        this.cause = cause;
    }

    public ApiFieldErrorMessage() {}

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}
