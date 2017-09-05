package com.leviosa.agent;

import com.leviosa.agent.config.CommandLineArgsParser;
import com.leviosa.agent.config.Config;
import com.leviosa.api.LeviosaAPIClient;

import java.util.Arrays;

public class Main {

    public static void main(String [] args) {
        Config config = Config.fromFile("leviosaAgent.properties", new CommandLineArgsParser(args));
        System.out.println(config.toString());
    }
}
