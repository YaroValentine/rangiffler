package org.rangiffler.utils;

import java.io.IOException;
import java.util.Properties;

public class Property {

    private static Properties loadFromFile(String filename) {
        Properties properties = new Properties();
        try {
            properties.load(Property.class.getClassLoader().getResourceAsStream("config/" + filename + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filename + ".properties", e);
        }
        return properties;
    }

    public static String getFromConfig(String key) {
        return loadFromFile("config").getProperty(key);
    }

}
