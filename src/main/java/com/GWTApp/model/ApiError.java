package com.GWTApp.model;


//@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
public class ApiError {

    private String error;
    private String userMessage;
    private String timestamp;

    public ApiError(String error, String userMessage, String timestamp) {
        this.error = error;
        this.userMessage = userMessage;
        this.timestamp = timestamp;
    }

    public ApiError() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
