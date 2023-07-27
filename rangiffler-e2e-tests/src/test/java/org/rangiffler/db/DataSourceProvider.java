package org.rangiffler.db;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.p6spy.engine.spy.P6DataSource;
import org.rangiffler.config.Config;

import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum DataSourceProvider {
    INSTANCE;

    private final Map<ServiceDB, DataSource> dataSources = new ConcurrentHashMap<>();

    public DataSource getDataSource(ServiceDB service) {
        return dataSources.computeIfAbsent(service, serviceDB -> {
            MysqlDataSource sds = new MysqlDataSource();
            sds.setURL(serviceDB.getJdbcUrl());
            sds.setUser(Config.getConfig().getDBLogin());
            sds.setPassword(Config.getConfig().getDBPassword());
            return new P6DataSource(sds);
        });
    }

}
