package com.leviosa.agent.config;

import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;

public class CommandLineArgsParser {

    private static final String ARGUMENT_PREFIX = "--";

    private Map<String, String> commandLineArgs = new HashMap<>();

    public CommandLineArgsParser(String [] args) {
        parse(args);
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(commandLineArgs.get(key));
    }

    private void parse(String[] args) {
        if(args == null) {
            return;
        }
        Arrays.stream(args).forEach((arg) -> {
            String [] keyValue = arg.split("=");
            if(isValidArg(keyValue)) {
                String key = extractKey(keyValue[0]);
                commandLineArgs.put(key, keyValue[1]);
            }
        });
    }

    private boolean isValidArg(String[] keyValue) {
        if(keyValue == null || keyValue.length != 2 || keyValue[0] == null || keyValue[1] == null) {
            return false;
        }
        if(!keyValue[0].startsWith(ARGUMENT_PREFIX)) {
            return false;
        }
        return true;
    }

    private String extractKey(String str) {
        return str.split(ARGUMENT_PREFIX)[1];
    }
}
