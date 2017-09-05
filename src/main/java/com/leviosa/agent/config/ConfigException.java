package com.leviosa.agent.config;

public class ConfigException extends RuntimeException {

    public ConfigException(String message) {
        super(message);
    }

    public ConfigException(Throwable t) {
        super(t);
    }

    public ConfigException(String message, Throwable t) {
        super(message, t);
    }
}
