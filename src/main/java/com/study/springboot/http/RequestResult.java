package com.study.springboot.http;

public class RequestResult {

    private boolean success;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RequestResult() {
    }

    public RequestResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
