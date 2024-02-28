package org.example.db;

import org.example.util.ConfigurationFileUtils;

import java.util.HashMap;
import java.util.Map;

public class DbConfig {
    private static final String CONFIG_FILE_PATH = "hibernate.properties";
    private static final String CONFIG_URL_KEY = "hibernate.connection.url";
    private static final String CONFIG_USER_KEY = "hibernate.connection.password";
    private static final String CONFIG_PASSWORD_KEY = "password";
    private static final Map<String, String> CONFIGURATION = new HashMap<>();

    public DbConfig() {
        CONFIGURATION.putAll(ConfigurationFileUtils.getConfigurationFromFile(CONFIG_FILE_PATH));
    }

    public String getUrl() {
        return CONFIGURATION.get(CONFIG_URL_KEY);
    }

    public String getUser() {
        return CONFIGURATION.get(CONFIG_USER_KEY);
    }

    public String getPassword() {
        return CONFIGURATION.get(CONFIG_PASSWORD_KEY);
    }
}
