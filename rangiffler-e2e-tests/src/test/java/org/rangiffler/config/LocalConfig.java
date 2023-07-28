package org.rangiffler.config;


import com.codeborne.selenide.Configuration;
import org.rangiffler.utils.Property;

public class LocalConfig implements Config {

    static final LocalConfig INSTANCE = new LocalConfig();

    static {
        Configuration.browser = "chrome";
        Configuration.browserVersion = "114.0";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
    }

    private LocalConfig() {
    }

    @Override
    public String getDBHost() {
        return Property.getFromConfig("local.db.address");
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
        return Property.getFromConfig("local.front.url");
    }

    @Override
    public String getAuthUrl() {
        return Property.getFromConfig("local.auth.url");
    }

    @Override
    public String getGatewayUrl() {
        return Property.getFromConfig("local.gateway.url");
    }

    @Override
    public String getUserdataUrl() {
        return Property.getFromConfig("local.userdata.url");
    }

    @Override
    public String getPhotosGrpcAddress() {
        return Property.getFromConfig("local.photos.grpc.address");
    }

    @Override
    public int getPhotosGrpcPort() {
        return Integer.parseInt(Property.getFromConfig("photos.grpc.port"));
    }

    @Override
    public String getGeoGrpcAddress() {
        return Property.getFromConfig("local.geo.grpc.address");
    }

    @Override
    public int getGeoGrpcPort() {
        return Integer.parseInt(Property.getFromConfig("geo.grpc.port"));
    }

    @Override
    public String kafkaAddress() {
        return Property.getFromConfig("local.kafka");
    }

}
