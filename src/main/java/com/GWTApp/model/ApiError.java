package com.GWTApp.model;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;


import java.util.List;

//@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ApiError {

    private String status;
    private String message;
    private List<String> errors;
    private String timestamp;

    public ApiError(String status, String message, List<String> errors, String timestamp) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.timestamp = timestamp;
    }

    public ApiError() {

    }


    public String getStatus() {
        return this.status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ApiError{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}
