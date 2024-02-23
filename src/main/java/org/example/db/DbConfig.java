package org.example.db;

import org.example.util.ConfigurationFileUtils;

import java.util.HashMap;
import java.util.Map;

public class DbConfig {
    private static final String CONFIG_FILE_PATH = "application.properties";
    private static final String CONFIG_URL_KEY = "db.url";
    private static final String CONFIG_USER_KEY = "user";
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
