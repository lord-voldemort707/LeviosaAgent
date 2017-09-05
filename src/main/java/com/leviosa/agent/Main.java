package com.leviosa.agent;

import com.leviosa.agent.config.CommandLineArgsParser;
import com.leviosa.agent.config.Config;
import com.leviosa.apiclient.LeviosaAPIClient;

public class Main {

    public static void main(String [] args) {
        Config config = Config.fromFile("leviosaAgent.properties", new CommandLineArgsParser(args));
        LeviosaAPIClient apiClient = LeviosaAPIClient.create(config.getLeviosaApiDomain());
        System.out.println(apiClient.getDataSourcesForPlayers());
    }
}
