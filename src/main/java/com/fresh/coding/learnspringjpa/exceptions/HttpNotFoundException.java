package com.fresh.coding.learnspringjpa.exceptions;

public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException(String message) {
        super(message);
    }
}
