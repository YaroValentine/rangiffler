package org.rangiffler.db.jpa;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.rangiffler.config.Config;
import org.rangiffler.db.ServiceDB;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.rangiffler.config.InitConfig.CFG;

public enum EmfProvider {
    INSTANCE;
    private final Map<ServiceDB, EntityManagerFactory> emfStore = new ConcurrentHashMap<>();

    public EntityManagerFactory getEmf(ServiceDB service) {
        return emfStore.computeIfAbsent(service, serviceDB -> {
            Map<String, Object> properties = new HashMap<>();
            properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
            properties.put("hibernate.connection.driver_class", "com.p6spy.engine.spy.P6SpyDriver");
            properties.put("hibernate.connection.username", CFG.getDBLogin());
            properties.put("hibernate.connection.password", CFG.getDBPassword());
            properties.put("hibernate.connection.url", service.p6SpyUrl());

            return new ThreadLocalEmf(Persistence.createEntityManagerFactory(
                    "rangiffler-persistence-unit-name",
                    properties
            ));
        });
    }

    public Collection<EntityManagerFactory> storedEmf() {
        return emfStore.values();
    }
}
