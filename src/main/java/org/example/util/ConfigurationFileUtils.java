package org.example.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public final class ConfigurationFileUtils {
    private static final String URL = "db.url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static Map<String, String> getConfigurationFromFile(String filePath) {
        Map<String, String> configuration = new HashMap<>();
        ClassLoader classLoader = ConfigurationFileUtils.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource(filePath)).getFile());
        try (FileInputStream fis = new FileInputStream(file)){

                Properties properties = new Properties();
                properties.load(fis);
                String url = properties.getProperty(URL);
                String user = properties.getProperty(USER);
                String password = properties.getProperty(PASSWORD);
                configuration.put(URL, url);
                configuration.put(USER, user);
                configuration.put(PASSWORD, password);

        } catch (IOException e) {
            System.err.println("Config file is not exist");
        }
        return configuration;
    }
}
