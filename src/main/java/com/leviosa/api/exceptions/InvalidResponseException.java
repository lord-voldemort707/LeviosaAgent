package com.leviosa.api.exceptions;

public class InvalidResponseException extends APICallException {

    public InvalidResponseException(String message) {
        super(message);
    }
}
