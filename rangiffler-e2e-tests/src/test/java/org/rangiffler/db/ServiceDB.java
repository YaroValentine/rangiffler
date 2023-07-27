package org.rangiffler.db;

import org.apache.commons.lang3.StringUtils;
import org.rangiffler.config.Config;

public enum ServiceDB {

    RANGIFFLER_AUTH("jdbc:mysql://%s:%d/niffler-auth"),
    RANGIFFLER_USERDATA("jdbc:mysql://%s:%d/niffler-userdata"),
    RANGIFFLER_GEO("jdbc:mysql://%s:%d/niffler-geo"),
    RANGIFFLER_PHOTOS("jdbc:mysql://%s:%d/niffler-photos");

    private final String jdbcUrl;

    ServiceDB(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUrl() {
        return String.format(jdbcUrl,
                Config.getConfig().getDBHost(),
                Config.getConfig().getDBPort()
        );
    }

    public String p6SpyUrl() {
        String baseUrl = getJdbcUrl();
        return "jdbc:p6spy:" + StringUtils.substringAfter(baseUrl, "jdbc:");
    }
}
