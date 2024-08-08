package com.fresh.coding.learnspringjpa.exceptions;

public class HttpInternalServerException extends RuntimeException {
    public HttpInternalServerException(String message) {
        super(message);
    }
}
