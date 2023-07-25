package org.rangiffler.config;

import com.codeborne.selenide.Configuration;
import org.rangiffler.utils.Property;

public class DockerConfig implements Config {

    static final DockerConfig INSTANCE = new DockerConfig();

    static {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "100.0";
        Configuration.remote = "http://selenoid:4444/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    private DockerConfig() {
    }

    @Override
    public String getDBHost() {
        return Property.getFromConfig("dc.db.address");
    }

    @Override
    public int getDBPort() {
        return Integer.parseInt(Property.getFromConfig("db.port"));
    }

    @Override
    public String getDBLogin() {
        return Property.getFromConfig("db.user");
    }

    @Override
    public String getDBPassword() {
        return Property.getFromConfig("db.password");
    }

    @Override
    public String getFrontUrl() {
        return Property.getFromConfig("dc.front.url");
    }

    @Override
    public String getAuthUrl() {
        return Property.getFromConfig("dc.auth.url");
    }

    @Override
    public String getGatewayUrl() {
        return Property.getFromConfig("dc.gateway.url");
    }

    @Override
    public String getUserdataUrl() {
        return Property.getFromConfig("dc.userdata.url");
    }

    @Override
    public String getPhotosGrpcAddress() {
        return Property.getFromConfig("dc.photos.grpc.address");
    }

    @Override
    public int getPhotosGrpcPort() {
        return Integer.parseInt(Property.getFromConfig("photos.grpc.port"));
    }

    @Override
    public String getGeoGrpcAddress() {
        return Property.getFromConfig("dc.geo.grpc.address");
    }

    @Override
    public int getGeoGrpcPort() {
        return Integer.parseInt(Property.getFromConfig("geo.grpc.port"));
    }

    @Override
    public String kafkaAddress() {
        return Property.getFromConfig("dc.kafka");
    }
}
