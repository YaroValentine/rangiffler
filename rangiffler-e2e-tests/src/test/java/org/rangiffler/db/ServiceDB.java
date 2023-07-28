package org.rangiffler.db;

import org.apache.commons.lang3.StringUtils;

import static org.rangiffler.config.InitConfig.CFG;

public enum ServiceDB {

    RANGIFFLER_AUTH("jdbc:mysql://%s:%d/rangiffler-auth"),
    RANGIFFLER_USERDATA("jdbc:mysql://%s:%d/rangiffler-userdata"),
    RANGIFFLER_GEO("jdbc:mysql://%s:%d/rangiffler-geo"),
    RANGIFFLER_PHOTOS("jdbc:mysql://%s:%d/rangiffler-photos");

    private final String jdbcUrl;

    ServiceDB(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUrl() {
        return String.format(jdbcUrl,
                CFG.getDBHost(),
                CFG.getDBPort()
        );
    }

    public String p6SpyUrl() {
        String baseUrl = getJdbcUrl();
        return "jdbc:p6spy:" + StringUtils.substringAfter(baseUrl, "jdbc:");
    }
}
