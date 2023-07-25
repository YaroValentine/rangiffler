package org.rangiffler.config;

import java.util.List;

public interface Config {

    static Config getConfig() {
        if ("docker".equals(System.getProperty("test.env"))) {
            return DockerConfig.INSTANCE;
        } else if ("local".equals(System.getProperty("test.env"))) {
            return LocalConfig.INSTANCE;
        } else throw new IllegalStateException("Can`t read 'test.env' System property");
    }

    String getDBHost();

    String getDBLogin();

    String getDBPassword();

    String getGatewayUrl();

    String getUserdataUrl();

    int getDBPort();

    String getFrontUrl();

    String getAuthUrl();

    String getGeoGrpcAddress();
    String getPhotosGrpcAddress();

    int getGeoGrpcPort();
    int getPhotosGrpcPort();

    String kafkaAddress();

    default List<String> kafkaTopics() {
        return List.of("users");
    }
}
