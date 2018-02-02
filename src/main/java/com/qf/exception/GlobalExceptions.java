package com.qf.exception;

import java.util.Map;

public class GlobalExceptions extends RuntimeException {

    private String message;

    public GlobalExceptions(Map<String,String> map) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
