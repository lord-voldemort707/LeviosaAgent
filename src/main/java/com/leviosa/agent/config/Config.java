package com.leviosa.agent.config;

import lombok.Getter;
import lombok.ToString;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;

@ToString(exclude = "properties")
public class Config {

    private final Properties properties;

    private static final String LEVIOSA_API_DOMAIN_KEY = "LeviosaApiDomain";

    private static final String CONFIG_DELIMITER = ".";

    private static final String GLOBAL_IDENTIFIER = "*";

    private static final String DEFAULT_STAGE = "development";

    @Getter
    private final String leviosaApiDomain;

    @Getter
    private final String stage;

    private Config(Properties properties, CommandLineArgsParser cmdArgs) {
        this.properties = Objects.requireNonNull(properties);
        this.stage = cmdArgs.get("stage").orElse(DEFAULT_STAGE);
        this.leviosaApiDomain = getRequiredValue(LEVIOSA_API_DOMAIN_KEY);
    }

    private String getRequiredValue(String key) {
        return getValueForKey(key).orElseThrow(() -> new ConfigException("Unable to find required key: " + key));
    }

    private Optional<String> getValueForKey(String key) {
        String value = properties.getProperty(getStageQualifiedKey(key));
        if(value == null) {
            value = properties.getProperty(getGlobalKey(key));
        }
        return Optional.ofNullable(value);
    }

    private String getGlobalKey(String key) {
        return GLOBAL_IDENTIFIER + CONFIG_DELIMITER + key;
    }

    private String getStageQualifiedKey(String key) {
        return stage + CONFIG_DELIMITER + key;
    }

    private static Properties loadProperties(String filepath) {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(filepath));
            return properties;
        } catch (IOException e) {
            throw new ConfigException(e);
        }
    }

    public static Config fromFile(String file, CommandLineArgsParser cmdArgs) {
        return new Config(loadProperties(file), cmdArgs);
    }

}
