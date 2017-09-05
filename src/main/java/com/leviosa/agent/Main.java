package com.leviosa.agent;

import com.leviosa.api.LeviosaAPIClient;

import java.util.Arrays;

public class Main {

    public static void main(String [] args) {
        Arrays.stream(args).forEach(arg -> {
            System.out.println(arg);
        });
    }
}
