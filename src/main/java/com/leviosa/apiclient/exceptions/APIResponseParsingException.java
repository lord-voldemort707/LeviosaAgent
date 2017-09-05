package com.leviosa.apiclient.exceptions;

public class APIResponseParsingException extends APICallException {

    public APIResponseParsingException(String message, Throwable t) {
        super(message, t);
    }
}
