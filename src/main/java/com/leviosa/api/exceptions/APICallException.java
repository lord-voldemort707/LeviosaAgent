package com.leviosa.api.exceptions;

public class APICallException extends RuntimeException {

    public APICallException(String message, Throwable t) {
        super(message, t);
    }

    public APICallException(String message) {
        super(message);
    }
}
